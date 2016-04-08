<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp"%>
<html>
<head>
    <title>您的购物车</title>
  <style>
body {
  text-align: center;
}

  </style>
  <script type="text/javascript">
    function deleteitem(id) {
      var confirm = window.confirm("确定删除该商品?");
      if (confirm) {
        window.location.href="${pageContext.request.contextPath}/DeleteCartItem?id="+id;
      }
    }

    function clearCart() {
      var confirm = window.confirm("您确定要清空购物车吗?");
      if (confirm) {
        window.location.href="${pageContext.request.contextPath}/ClearCartServlet";
      }
    }

    function changeQuantity(input,id,oldvalue) {
      var quantity = input.value;
//      //检查用户输入的是不是一个数字
//      if (isNaN(quantity)) {
//        alert("请输入正整数!")
//        input.value=oldvalue;
//        return;
//      }

      //检查用户输入的是不是一个正整数
      if (quantity<0||quantity!=parseInt(quantity)) {
        alert("请输入正整数!")
        input.value=oldvalue;
        return;
      }

      var confirm=window.confirm("您确定把数量修改为"+quantity+"本吗?");
      if (confirm==true) {
        window.location.href =
                "/ChangeQuantityServlet?id="+id+"&quantity="+quantity;
//                "/ChangeQuantityServlet?id="+ id +"&quantity = "+quantity; 错误写法
//                Jsp里面的地址中间不要夹杂空格,浏览器解析会导致传值错误(2016年3月15日 23:49:36 浪费我一个多小时找问题)
      }

    }

  </script>
</head>
<body bgcolor="c7edcc">
<div><h1>您的购物车:</h1></div>

<%--<c:if test="${cart.map==empty||cart.map==null}"></c:if>--%>
<c:if test="${empty(cart.map)}">
  <div>您的购物车空空如也!再去逛逛吧.</div>
  <div><a href="/ListBookServlet">天喵书城</a></div>
</c:if>

<c:if test="${!empty(cart.map)}">
<table width="70%" border="1">
  <tr>
    <td>书名</td>
    <td>作者</td>
    <td>单价</td>
    <td>数量</td>
    <td>小计</td>
    <td>操作</td>
  </tr>
  <c:forEach var="entry" items="${cart.map}">
    <tr>
      <td>${entry.value.book.bookname}</td>
      <td>${entry.value.book.author}</td>
      <td>${entry.value.book.price}</td>
      <td><input type="text" name="quantity" value="${entry.value.quantity}"
                 style="width:30px;" onchange="changeQuantity(this,${entry.key},${entry.value.quantity})"/> </td>
      <td>${entry.value.price}</td>
      <td>
        <a href="javascript:void(0)" onclick="deleteitem(${entry.key})">删除</a>
      </td>

    </tr>

  </c:forEach>
  <tr>
    <td colspan="3">总价</td>
    <td colspan="2">${cart.totalprice }元</td>
    <td colspan="1">
      <a href="javascript:void(0)" onclick="clearCart()">清空购物车</a>
    </td>

  </tr>

</table>
</c:if>

</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/15
  Time: 19:25
  To change this template use File | Settings | File Templates.
-->