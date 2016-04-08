package cn.itcast.Tags.SimpleTage;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class simpleTag2 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        for (int i = 0; i <5 ; i++) {
            jspBody.invoke(null);  //默认输出到jsp,等同于jspBody.invoke(getJspContext().getOut());
        }
    }
}
