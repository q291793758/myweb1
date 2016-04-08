package cn.itcast.Tags;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

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
