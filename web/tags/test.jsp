<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.simpleitcast.cn" %>
<html>
<head>
    <title>test</title>
    <style>
        body {
            text-align: center;
            margin: auto;
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
迭代MAP,数组等:<br/>
<%
    Map map = new HashMap();
    map.put("1","one");
    map.put("2","two");
    map.put("3","three");
    map.put("4","four");
    request.setAttribute("map",map);
%>

<c:foreach2_tag var="entry" item="${map}">
    ${entry.key} : ${entry.value}
</c:foreach2_tag>



</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 19:29
  To change this template use File | Settings | File Templates.
-->