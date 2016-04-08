<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="itcast" uri="http://www.itcast.cn" %>
<html>
<head>
    <title>测试自定义标签的jsp</title>

  <style>
    body {
      /*text-align: center;*/
      /*margin: auto;*/
      width :80%;
    }

    pre {
      padding-left :120px;
    }

  </style>

</head>
<body bgcolor="c7edcc">

<div style="text-align: center">您的IP是:<itcast:viewIP/></div>

<pre>

  使用标签输出客户机IP:
  <hr/>
  1,编写一个实现tag接口的实现类
  public class VIewIPTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        //通过 pageContext获得相关要操作的对象.
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        JspWriter out = pageContext.getOut();

        String ip=request.getRemoteUser()+"     IP:"+request.getRemoteAddr();
        try {
            out.write(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return super.doStartTag();
    }
  }
<hr/>
  2,在tld文件中对标签处理器进行描述(web/WEB-INF目录下)
    tld在tomcat/webapps/jsp2/有模版
<hr/>
  3,在jsp页面中导入和使用自定义标签
  < %@taglib prefix="itcast" uri="http://www.itcast.cn" %>

  < itcast:viewIP/>
<hr/>
</pre>








</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 9:21
  To change this template use File | Settings | File Templates.
-->