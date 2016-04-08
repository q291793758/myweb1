<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tag测试jsp</title>
    <style>
        body {
            text-align: center;
            margin: auto;
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
<%
request.setAttribute("data",null);
%>
<br/>
//excapeXML 是否转义输出:
<c:out value="<a hre='/1.jsp'>超链接</a>" default="缺省值" escapeXml="true"></c:out><hr/>
<c:out value="${data}" default="前边获取不到就输出缺省值啦!"/>

<c:set var="data" value="databasexxx" scope="page"/>
${data}

<%
    Map map = new HashMap();
%>
<c:set property="dd" value="xxx" target="${map}"/>
${map.dd}







</body>
</html>
