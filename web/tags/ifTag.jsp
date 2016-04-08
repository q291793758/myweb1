<%@ taglib prefix="simpleitcast" uri="http://www.simpleitcast.cn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>if test=""标签</title>
    <style>
        body {
            /*text-align: center;*/
            /*margin: auto;*/
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
ifTag 通过参数test判断执行不执行标签体;<hr/>
<%
    //设置登录标记: 在这里修改执行不同情况

//        session.setAttribute("login","username"); //创建登录标记
          session.removeAttribute("login");       //删除登录标记

%>
<simpleitcast:ifTag test="${login==null}" >
    用户未登录
</simpleitcast:ifTag>

<simpleitcast:ifTag test="${login!=null}" >
    用户已登录
</simpleitcast:ifTag><br/>

<pre>
 public class ifTag extends SimpleTagSupport {
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (test) {
            this.getJspBody().invoke(null);
        }


    }
}
</pre> <hr/><hr/>

if else tag: 嵌套执行:<br/>

<simpleitcast:choose_tag>
    <simpleitcast:if_tag test="${login!=null}">
        choose_tag/if_tag  用户已经登录!<br/>
    </simpleitcast:if_tag>
    <simpleitcast:else_tag>
        choose_tag/else_tag 用户未登录<br/>
    </simpleitcast:else_tag>
</simpleitcast:choose_tag>
<hr/>
<pre>
    父标签choose_tag
    public class choose_tag extends SimpleTagSupport {
    private boolean isDo;

    public boolean isDo() {
        return isDo;
    }

    public void setDo(boolean aDo) {
        isDo = aDo;
    }

    @Override
    public void doTag() throws JspException, IOException {
        //执行标签体.
        this.getJspBody().invoke(null);
    }
}

</pre><hr/>
<pre>
    子标签if_tag
    public class if_tag extends SimpleTagSupport {
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        //获得父类标签
        choose_tag parent = (choose_tag) this.getParent();
        //判断是否执行
        if (test == true&&parent.isDo()==false) {
            this.getJspBody().invoke(null);
            parent.setDo(true);
        }
    }
}
</pre><hr/>
<pre>
    子标签else_tag
    public class else_tag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        //获得父类标签
        choose_tag parent = (choose_tag) this.getParent();
        //判断是否执行
        if (parent.isDo() == false) {
            this.getJspBody().invoke(null);
            parent.setDo(true);
        }
    }
}

</pre><hr/>


</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 16:15
  To change this template use File | Settings | File Templates.
-->