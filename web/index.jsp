<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册登录界面</title>
</head>
<style>
    body {

        margin:0 auto;
        background-color: #016aa9;
        /*text-align: center; !*网页居中*!*/
        font-size: 18px;
        overflow: hidden;
    }

    #container {
        margin:0 auto;
    }

    #login {
        background-image: url(pic/login.gif);
        width: 1107px;
        height: 399px;
        /*margin-top: 100px;*/
        /*margin-left: 450px;*/
        position: absolute;
    }

    #form {
        margin-top: 200px;
        margin-left: 440px;
        /*position: absolute;*/
    }

    #input input{
        margin-bottom: 10px;
       background-color: #292910;
        width: 120px;
        color: #6cd0ff;
        border: 0px;
        font-size: 18px;
    }

    #buttos {
        margin-left: 25px;;
        /*height: 120px;*/
        /*width: 250px;*/
    }
    #buttos input {
        margin-left: 20px;
    }
    #username {
        color: white;
    }
   #password {
       color: white;
        /*margin-top: 15px;*/
    }

</style>

<body>

<div id="container">
    <div id="login">
        <div id="form">
            <form action="/loginServlet" method="post">
                <div id="input">
                    <div id="username">用户:<input type="text" name="username" value=""/></span></span><br/></div>
                    <div id="password">密码:<input type="password" name="password"/> <br/></div><span>${username}</span>
                </div>
                <div id="buttos">
                    <input type="submit" value="登录" onclick="window.location.href='/loginServlet'"/>
                    <input type="button" value="注册" onclick="window.location.href='/registerUI'" />
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>
