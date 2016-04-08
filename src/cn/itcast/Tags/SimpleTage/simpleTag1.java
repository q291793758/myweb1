package cn.itcast.Tags.SimpleTage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class simpleTag1 extends SimpleTagSupport {
    @Override//控制标签体执行
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        jspBody.invoke(this.getJspContext().getOut());
        super.doTag();
    }
}
