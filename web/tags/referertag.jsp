<%@ taglib prefix="simpleitcast" uri="http://www.simpleitcast.cn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<simpleitcast:refererTag site="http://localhost" page="http://localhost:8080/index.jsp"/>
<html>
<head>
    <title>防盗链标签演示</title>
    <style>
        body {
            text-align: center;
            margin: auto;
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
页面内容
<pre>
    public class refererTag extends SimpleTagSupport{
    private String site;
    private String page;

    public void setSite(String site) {
        this.site = site;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext= (PageContext) this.getJspContext();
        HttpServletRequest request= (HttpServletRequest) pageContext.getRequest();
        HttpServletResponse response= (HttpServletResponse) pageContext.getResponse();
        System.out.println(request.getContextPath());
        String referer = request.getHeader("referer");
        //判断是盗链:
        if (referer == null || !referer.startsWith(site)) {
            if (page.startsWith(request.getContextPath())) {
                response.sendRedirect(page);
            } else if (page.startsWith("/")) {
                response.sendRedirect(request.getContextPath() + page);
                return;

            } else {
                response.sendRedirect(request.getContextPath() + "/" + page);
            }
            throw new SkipPageException();
        }
        //不是盗链,显示下面的内容

    }
}

</pre>
</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/16
  Time: 15:41
  To change this template use File | Settings | File Templates.
-->