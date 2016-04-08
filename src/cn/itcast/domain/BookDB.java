package cn.itcast.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
    static Map map = new LinkedHashMap();

    public static Map getAll() {
        return map;
    }

    static{

        map.put("1",new Book("1","Java基础教程","张孝祥","java基础学习,为期一个半月.",39.8));
        map.put("2",new Book("2","MySQL&JDBC数据库开发","张孝祥","学习数据库开发.",40.0));
        map.put("3",new Book("3","网络编程(socket)","任小龙","网络socket流,文件上传下载等.",25.5));
        map.put("4",new Book("4","AJAX开发","张孝祥","学习AJAX开发.",20));
        map.put("5",new Book("5","SSH基本框架","毕向东","Spring+Hibernet框架学习.",50.0));

    }
}

