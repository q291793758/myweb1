package cn.itcast.domain;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
//获得表单数据并校验
public class Formbean {
    private String username;
    private String password1;
    private String password2;
    private String email;
    private String birthday;
    private String nickname;

    private Map errors = new HashMap();
    boolean isOK = true;

    public boolean checkform(HttpServletRequest request) {

        //校验数据,并将错误信息存储在集合中
        //1,username应是4-12位 字母或数字,必须以字母开头
        if (username == null || username.trim().equals("")) {
            isOK = false;
            errors.put("username", "用户名不能为空!");
        } else {
            if ((!username.matches("[a-zA-Z]\\w{3,11}"))) {
                isOK = false;
                errors.put("username", "用户名应是4-12位字母或数字,必须以字母开头!");
            }
        }
        //2,password1应是8-12位 字母或数字,必须以字母开头
        if (password1 == null || password1.trim().equals("")) {
            isOK = false;
            errors.put("password1", "密码不能为空!");
        } else {
            if (!password1.matches("[a-zA-Z]\\w{7,11}")) {
                isOK = false;
                errors.put("password1", "密码应是8-12位 字母或数字,必须以字母开头!");
            }
        }
        //3,password2应和password1一样
        if (password2 == null || password2.trim().equals("")) {
            isOK = false;
            errors.put("password2", "密码不能为空!");
        } else {
            if (!password1.equals(password2)) {
                isOK = false;
                errors.put("password2", "密码不一致!");
            }
        }
        //4,email 字母或数字 @ (字母或数字.字母)+ 必须以字母或数字开头;
        if (email == null || email.trim().equals("")) {
            isOK = false;
            errors.put("email", "邮箱不能为空!");
        } else {
            if (!email.matches("[a-zA-Z0-9].+@([a-zA-Z_0-9]+\\.[a-zA-Z]+)+")) {
                isOK = false;
                errors.put("email", "邮箱格式不正确!");
            }
        }
        //nickname 必须是汉字 常用汉字区间 \u4e00-\u9fa5
        if (nickname == null || nickname.trim().equals("")) {
            isOK = false;
            errors.put("nickname", "昵称不能为空!");
        } else {
            if (!nickname.matches("[\u4e00-\u9fa5]+")) {
                isOK = false;
                errors.put("nickname", "昵称应是汉字!");
            }

        }

        //birthday要么为空,要么可以转成Date的正确格式
        if (birthday != null && !birthday.trim().equals("")) {
            try {
//                DateLocaleConverter dic = new DateLocaleConverter();
//                dic.convert(birthday, "yyyy-MM-dd");
                new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            } catch (Exception e) {
                isOK = false;
                errors.put("birthday", "生日格式应为: 年年年年-月月-日日");
            }
        }

        return isOK;
    }

    public Map getErrors() {
        return errors;
    }

    public void setErrors(Map errors) {
        this.errors = errors;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}
