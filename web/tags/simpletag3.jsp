<%@ page import="java.util.Date" %>
<%@ taglib prefix="simpleitcast" uri="http://www.simpleitcast.cn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>带属性标签</title>
    <style>
        body {
            /*text-align: center;*/
            /*margin: auto;*/
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">

传值控制标签输出几次:
<simpleitcast:simpleTag5 count="8" date="<%=new Date() %>">
    标签体<br/>
</simpleitcast:simpleTag5><br/>
<pre>
    标签处理类:
   public class simpleTag5 extends SimpleTagSupport {

    private int count;

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        for (int i = 0; i<count;i++) {
       jspBody.invoke(null);
       }
        }
        public void setCount(int count) {this.count = count;}
    }

</pre>

</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
-->