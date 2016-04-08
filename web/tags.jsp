<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义标签库开发</title>
    <style>
        body {
            text-align: center;
            margin: auto;
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
<div>
    <a href="FactoryModle.jsp">Factory Modle</a>
</div><hr/>
        <div>标签执行器所在目录:cn/itcast/Tags</div><hr/>
        <div>自定义标签</div><br/>
        <div><a href="/tags/tag.jsp">测试自定义标签的jsp</a></div><br/>
        <div><a href="/tags/tag2.jsp">使用标签控制页面是否输出</a></div><br/>
        <div><a href="/tags/tag3.jsp">tag控制多次输出</a></div><hr/>

         <div>简单标签simpletag</div>
        <div><a href="/tags/simpletag.jsp">用简单标签simpletag执行标签体</a></div>    <br/>
        <div><a href="/tags/referertag.jsp">防盗链标签演示</a></div>    <br/>
        <div><a href="/tags/ifTag.jsp">ifTag 通过参数test判断执行不执行标签体;</a></div> <br/>
        <div><a href="/tags/simpletag2.jsp">简单标签simpletag控制多次输出标签体</a></div>  <br/>
        <div><a href="/tags/simpletag3.jsp">带属性标签通过输入值控制输出多少次标签体</a></div> <br/>
        <div><a href="/tags/simpletag4.jsp">通过标签实现迭代集合</a></div>    <br/>

</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 20:35
  To change this template use File | Settings | File Templates.
-->