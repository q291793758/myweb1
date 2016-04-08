<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp"%>
<html>
<head>
    <title>天喵书城</title>
</head>
<style>
  body {
    text-align: center;
  }
</style>
<body bgcolor="c7edcc">
<h1>欢迎来到天喵书城!</h1>
<h2>天喵书城欢迎您!&nbsp;&nbsp;${login}</h2>
<h3>请尽情选购!</h3>
<table width="70%" border="1">
  <tr>
    <td>书名</td>
    <td>作者</td>
    <td>描述</td>
    <td>售价</td>
    <td>操作</td>
  </tr>
  <c:forEach var="entry" items="${bookmap}">
  <tr>
    <td>${entry.value.bookname}</td>
    <td>${entry.value.author}</td>
    <td>${entry.value.discription}</td>
    <td>${entry.value.price}</td>
    <td>
      <a href="${pageContext.request.contextPath}/BuyServlet?bookid=${entry.value.bookid}"target="_blank">购买</a>
    </td>
  </tr>

</c:forEach>


</table>

</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/15
  Time: 13:18
  To change this template use File | Settings | File Templates.
-->