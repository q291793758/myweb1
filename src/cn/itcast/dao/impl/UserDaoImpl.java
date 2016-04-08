package cn.itcast.dao.impl;

import cn.itcast.domain.User;
import cn.itcast.utils.ServiceUtils;
import cn.itcast.utils.XmlUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;

import java.text.SimpleDateFormat;

public class UserDaoImpl  {

    public  void add(User user) {
        try {
            Document document = XmlUtils.getDocument();
        Element rootElement = document.getRootElement();
        Element user1 = rootElement.addElement("user");
        user1.addAttribute("id", user.getId());
        user1.addAttribute("password", ServiceUtils.codingPassword(user.getPassword()));
        user1.addAttribute("username", user.getUsername());
        user1.addAttribute("nickname", user.getNickname());
        user1.addAttribute("email", user.getEmail());
        user1.addAttribute("birthday", user.getBirthday()!=null?user.getBirthday().toLocaleString():"");

            XmlUtils.write2Xml(document);
        } catch (Exception e) {
           throw new RuntimeException(e);
    }
    }
    //username exit in database or not

    public  boolean find(String username) {
        try {

            Document document = XmlUtils.getDocument();
            Node node = document.selectSingleNode("//user[@username='" +username + "']");
            if (node == null) {
                return false;
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
            return true;

    }
    //login

    public  User find(String username, String password) {
        try {
            password=ServiceUtils.codingPassword(password);
            Document document = XmlUtils.getDocument();
            Element node = (Element) document.selectSingleNode("//user[@username='" + username + "' and @password='" + password + "']");
            if (node == null) {
                return null;
            }
            User user = new User();
            user.setId(node.attributeValue("id"));
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(node.attributeValue("email"));
            user.setNickname(node.attributeValue("nickname"));
            //生日可以留空,所以要判断一下
            String birthday = node.attributeValue("birthday");
            if (birthday == null || birthday.equals("")) {
                user.setBirthday(null);
            } else {
                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
            }
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
