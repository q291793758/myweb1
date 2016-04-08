<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="itcast" uri="http://www.simpleitcast.cn" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EL表达式 </title>
    <style>
        body {
            text-align: center;
            margin: auto;
            width: 80%;
        }
    </style>
</head>
< bgcolor="c7edcc">
<div>获取请求头</div>
${header['Accept-Language']}<hr/>
<div>获取cookie中的Jsession</div>
${cookie.JSESSIONID.name} <br/>
<%--//cookie.JSESSION拿到的是一个cookie对象--%>
${cookie.JSESSIONID.value}<hr/>

EL函数 WEB-INF/itcast.tld里配置:<br/>
1.该函数必须是 static 静态的<br/>
2,该函数必须在tld里描述<br/>
3,只能封装与web无关的,因为获得不了web相关的对象(request,context等)<br/>
4,需要支持Servlet2.4/JSP2.0技术的web服务器
${itcast:filter("    <function>
        <name>filter</name>
        <function-class>cn.itcast.Tags.SimpleTage.htmlFilterTag</function-class>
        <function-signature>java.lang.String filter(java.lang.String)</function-signature>
        </function>")}<br/>
${itcast:filter("<a href='localhost'>")}<hr/>

FN函数:<br/>
转大小写:
${fn:toLowerCase("TOUPERCASE")}
${fn:toUpperCase("toupercase")}
<br/>
<%
request.setAttribute("arr",new String[5]);
%>
${fn:length(arr)}<hr/>

新的迭代方式:<br/>
<%
    ArrayList arrayList = new ArrayList();
    arrayList.add("aa");
    arrayList.add("bb");
    arrayList.add("cc");
    arrayList.add("dd");
    request.setAttribute("arraylist",arrayList);
%>
 用步长1,从0到length迭代
<c:forEach var="i" begin="0" end="${fn:length(arraylist)}">
    ${arraylist[i]}
</c:forEach><br/>
  内部iterator迭代
<c:forEach var="str" items="${arraylist}">
    ${str}
</c:forEach> <hr/>

fn实现数据回显checked选择<br/>
<%
request.setAttribute("likes",new String[]{"dance","sing"});
%>
<%--获取参数--%>
${param.likes}

<input type="checkbox" name="likes" value="sing" ${fn:contains(fn:join(likes,","),"sing")?"checked":""}>唱歌
<input type="checkbox" name="likes" value="dace"${fn:contains(fn:join(likes,","),"dance")?'checked':''}>跳舞
<input type="checkbox" name="likes" value="basketball"${fn:contains(fn:join(likes,","),"basketball")?"checked":""}>篮球
<input type="checkbox" name="likes" value="football"${fn:contains(fn:join(likes,","),"football")?'checked':""}>足球
<input type="checkbox" name="likes" value="readbooks" checked>看书



</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/17
  Time: 9:58
  To change this template use File | Settings | File Templates.
-->