<%@ taglib prefix="simpleitcast" uri="http://www.simpleitcast.cn" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过标签实现迭代集合</title>
    <style>
        body {
            /*text-align: center;*/
            /*margin: auto;*/
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
//创建Arraylist
<%
    List list = new ArrayList();
    list.add("aaaaa");
    list.add("bbbbb");
    list.add("ccccc");
    list.add("ddddd");
    session.setAttribute("list", list);
%>
//通过标签迭代<br/>
<simpleitcast:foreach_tag var="str" item="${list}">
    ${str}<br/>
</simpleitcast:foreach_tag>

<pre>
    public class foreach_tag extends SimpleTagSupport {
    //有可能传ArrayLIST HashMap等,所以类型是Object
    private Object item;
    private String var;

    @Override
    public void doTag() throws JspException, IOException {
       //迭代标签比较复杂,这里只考虑简单情况,只对List进行迭代
        List list= (List) item;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object value=iterator.next();
            //把迭代出的东西存在域里
            this.getJspContext().setAttribute(var,value);
            //通过$ {var}取出数据
            this.getJspBody().invoke(null);
        }
    }

    public void setItem(Object item) {
        this.item = item;
    }
    public void setVar(String var) {
        this.var = var;
    }
}

</pre>
<hr/>
<hr/>
迭代MAP,对象数组,基本类型的数组等:<br/>
<%
    Map map = new HashMap();
    map.put("1","one");
    map.put("2","two");
    map.put("3","three");
    map.put("4","four");
    request.setAttribute("map",map);
%>

<simpleitcast:foreach2_tag var="entry" item="${map}">
    ${entry.key}:${entry.value}
</simpleitcast:foreach2_tag>
<hr/><hr/>

<simpleitcast:foreach2_tag var="str" item="${list}">
    ${entry}<br/>
</simpleitcast:foreach2_tag>

<hr>
<pre>
    package cn.itcast.Tags.SimpleTage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class foreach2_tag extends SimpleTagSupport{
    private Object item;
    private String var;
    private Collection collection;

    public void setVar(String var) {
        this.var = var;
    }

    public void setItem(Object item) {
        //单列集合
        this.item = item;
        if (item instanceof Collection) {
            collection= (Collection)item;
        }
        //双列数组转单列 Map -->entryset()
        if (item instanceof Map) {
            Map map=  (Map)item;
            collection= map.entrySet();
        }
        //对象数组
        if (item instanceof Objects[]) {
            Object[] obj= (Object[])item;
            collection = Arrays.asList(obj);
        }
        //基本数据类型(int short long等)与以上都不匹配
        //用继承者 java.lang.Class  .getClass().isArray()判定此 Class 对象是否表示一个数组类。
        if (item.getClass().isArray()) {
            Collection collection=new ArrayList();
           //java.lang.reflect Array 类提供了动态创建和访问 Java 数组的方法。
            //获得数组的长度
           int length= Array.getLength(item);
            //get(Object array, int index) 返回指定数组对象中索引组件的值。
            for (int i = 0; i < length ; i++) {
                Object value = Array.get(item, i);
                collection.add(value);
            }

        }
    }
    @Override
    public void doTag() throws JspException, IOException {
        Iterator iterator = this.collection.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            this.getJspContext().setAttribute("entry",value);
            this.getJspBody().invoke(null);
        }
    }
}
</pre>

</body>
</html>
<!--

Created by IntelliJ IDEA.
User: Administrator
Date: 2016/3/16
Time: 17:17
To change this template use File | Settings | File Templates.
-->