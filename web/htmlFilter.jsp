<%@ taglib prefix="simpleitcast" uri="http://www.simpleitcast.cn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>超链接转义</title>
    <style>
        body {
            text-align: center;
            margin: auto;
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">

<simpleitcast:htmlFilterTag>
    <a href="htmlFilter.jsp">转义超链接</a>   转义为:
</simpleitcast:htmlFilterTag><hr/>
<simpleitcast:htmlFilterTag>
    &lt;a href=&quot;htmlFilter.jsp&quot;&gt;转义超链接&lt;/a&gt;
</simpleitcast:htmlFilterTag>
<pre>

    //转义html链接以原样输出
public class htmlFilterTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        //获得标签体
        StringWriter stringWriter=new StringWriter();
        this.getJspBody().invoke(stringWriter);
        String str = stringWriter.toString();
        //转义字符
        str = filter(str);
        //输出标签体
        getJspContext().getOut().write(str);

    }
    //代码来自 ../apache-tomcat-6.0.29\webapps\examples\WEB-INF\classes\\\\util\HTMLFilter.java
    public static String filter(String message) {

        if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot;");
                    break;
                default:
                    result.append(content[i]);
            }
        }
        return (result.toString());

    }

}
</pre>

</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 21:15
  To change this template use File | Settings | File Templates.
-->