package cn.itcast.Tags.SimpleTage.if_else_Tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

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
