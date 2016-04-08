package cn.itcast.Tags.SimpleTage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

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
