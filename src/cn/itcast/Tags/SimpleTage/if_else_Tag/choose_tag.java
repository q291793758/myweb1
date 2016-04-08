package cn.itcast.Tags.SimpleTage.if_else_Tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

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
