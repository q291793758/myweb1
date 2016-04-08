<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sitcast" uri="http://www.simpleitcast.cn" %>
<html>
<head>
    <title>简单标签simpletag控制多次输出标签体</title>
    <style>
        body {
            /*text-align: center;*/
            /*margin: auto;*/
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">


<sitcast:simpleTag2>
   <div>简单标签体执行多次</div><br/>
</sitcast:simpleTag2>
<hr/>
<pre>
    public class simpleTag2 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        for (int i = 0; i <5 ; i++) {
            jspBody.invoke(null);  //默认输出到jsp,等同于jspBody.invoke(getJspContext().getOut());
        }
    }
}

</pre><hr/>
修改标签体touppercase<br/>
<sitcast:simpleTag3>
    标签体touppercase
</sitcast:simpleTag3>
<hr/>
<pre>
    //修改标签体
public class simpleTag3 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        StringWriter writer = new StringWriter();
        //写到带有缓冲区的StringWriter()里
        jspBody.invoke(writer);
        //获得缓冲的内容
        String content = writer.toString();
        content=content.toUpperCase();
        this.getJspContext().getOut().write(content);
    }
}
</pre><hr/>

描述:控制标签剩下的内容不执行:<br/>
<pre>
    public class simpleTag4 extends SimpleTagSupport{
    @Override
    public void doTag() throws JspException, IOException {
        throw new SkipPageException();
    }
}
</pre><hr/>

<sitcast:simpleTag4></sitcast:simpleTag4>
这里是不执行的部分!

</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 13:10
  To change this template use File | Settings | File Templates.
-->