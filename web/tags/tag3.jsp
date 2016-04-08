<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="itcast" uri="http://www.itcast.cn"  %>
<html>
<head>
    <title>tag控制多次输出</title>
    <style>
        body {
            /*text-align: center;*/
            /*margin: auto;*/
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
<pre>
    //控制标签体执行五次
    public class IteratiorTag extends TagSupport {
    int x=5;
    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }
    @Override
    public int doAfterBody() throws JspException {
        x--;
        if (x > 0) {
            return IteratiorTag.EVAL_BODY_AGAIN;
        } else {
            return IteratiorTag.SKIP_BODY;
        }
    }
}
    <hr/>
</pre>
<itcast:IteratiorTag>
<h2 style="text-align: center">标签体</h2>
</itcast:IteratiorTag>
    <hr/>
    <hr/><h1>tag标签修改页面中的内容:toUpperCase()</h1>
<itcast:ChangeContextTag>
    touppercase
</itcast:ChangeContextTag>
<hr/>
<pre>
  //修改标签体 toUppercase
public class ChangeContextTag extends BodyTagSupport {

    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {

        BodyContent bodyContent = this.getBodyContent();
        String s = bodyContent.getString();
        try {
            this.pageContext.getOut().write(s.toUpperCase());
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        return Tag.EVAL_PAGE;
    }
}
</pre>

</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 10:18
  To change this template use File | Settings | File Templates.
-->