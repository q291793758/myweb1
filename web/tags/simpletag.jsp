<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.simpleitcast.cn" prefix="simpleItcast"%>
<html>
<head>
    <title>用简单标签simpletag执行标签体</title>
    <style>
        body {
            /*text-align: center;*/
            /*margin: auto;*/
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">

<simpleItcast:simpleTag1>
    简单标签之显示标签体.
</simpleItcast:simpleTag1>
<hr/>
<pre>
    public class simpleTag1 extends SimpleTagSupport {
    @Override//控制标签体执行
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        jspBody.invoke(this.getJspContext().getOut());
        super.doTag();
        }
    }
</pre><hr/>
//控制标签体不显示:方法里啥都不写,就是不输出
<pre>
    public class simpleTag1 extends SimpleTagSupport {
    @Override//控制标签体执行
    public void doTag() throws JspException, IOException {

        }
    }
</pre><hr/>





</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 12:54
  To change this template use File | Settings | File Templates.
-->