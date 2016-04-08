<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<html>
<head>
    <title>用户注册</title>
</head>
<style>
    body {
        margin: 0 auto;
        text-align: center;
    }

    td {
        margin: 0 auto;
        padding-top: 5px;
        color: white;
    }
    .button {
        padding-left:70px;
    }
    input {
        background-color:#0069aa ;
        color: white;
        border: 1px solid darkblue;
    }
</style>
<body bgcolor="0069aa">
<div><h1>用户注册</h1></div>
<div>
    <table id="table">
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">

            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value="${form.username}"/> <span>${form.errors.username}</span></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password1" value="${form.password1}"/><span>${form.errors.password1}</span></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="password2" value="${form.password2}" /><span>${form.errors.password2}</span></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" value="${form.email}"/><span>${form.errors.email}</span></td>
            </tr>
            <tr>
                <td>生日</td>
                <td><input type="text" name="birthday" value="1995-02-02"/><span>${form.errors.birthday}</span></td>
            </tr>
            <tr>
                <td>昵称</td>
                <td><input type="text" name="nickname"value="${form.nickname}"/><span>${form.errors.nickname}</span></td>
            </tr>
            <tr>
                <td class="button"><input type="reset" value="重置"> <span></span></td>
                <td class="button"><input type="submit" value="提交"> <span></span></td>
            </tr>
        </form>
    </table>
</div>



</body>
</html>
<!--

Created by IntelliJ IDEA.
User: Administrator
Date: 2016/3/14
Time: 18:25
To change this template use File | Settings | File Templates.
-->