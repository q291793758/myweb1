package cn.itcast.utils;
//数据库工具类
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.*;

public class XmlUtils {
    private static String filepath;
    //通过类装载器获得数据库 user.xml的位置
    static{
    filepath=  XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
//        filepath = "F:/myweb/out/production/myweb/users.xml";
    }
    public static Document getDocument() throws DocumentException {
        Document document = new SAXReader().read(new File(filepath));
        return document;
    }
    //更新数据库
    public static void write2Xml(Document document) throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(filepath), format);
        format.setEncoding("UTF-8");
        xmlWriter.write(document);
        xmlWriter.close();
    }

}
