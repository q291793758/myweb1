<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="itcast" uri="http://www.itcast.cn" %>
<itcast:ShowPagetag></itcast:ShowPagetag>
<html>
<head>
    <title>使用标签控制页面是否输出</title>
    <style>
        body {
            text-align: center;
            margin: auto;
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
<h1>this is a jsp page;</h1>


<itcast:Showbodytag>
    tag控制标签体是否输出<hr/>
    return Tag.EVAL_BODY_INCLUDE;<br/>
    该标记输出标签体<hr/>
    return Tag.SKIP_BODY;<br/>
    该标记不输出标签体<hr/>

</itcast:Showbodytag>
<pre>

    tag控制标签体是否输出<hr/>
    return Tag.EVAL_BODY_INCLUDE;<br/>
    该标记输出标签体<hr/>
    return Tag.SKIP_BODY;<br/>
    该标记不输出标签体<hr/>

    public class ShowPagetag   extends TagSupport {

    @Override
    public int doEndTag() throws JspException {

        return Tag.SKIP_PAGE;
    }
}
<hr/>
    return Tag.SKIP_PAGE;<br/>
    该标记跳过jsp,下面的不显示<hr/>

    return Tag.EVAL_PAGE;<br/>
    该标记显示下面的jsp<hr/>
</pre>

</body>
</html>
<!--

Created by IntelliJ IDEA.
User: Administrator
Date: 2016/3/16
Time: 9:54
To change this template use File | Settings | File Templates.
-->