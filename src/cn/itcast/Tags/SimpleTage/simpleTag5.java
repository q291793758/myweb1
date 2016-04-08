package cn.itcast.Tags.SimpleTage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Date;

public class simpleTag5 extends SimpleTagSupport {

    private int count;
    private Date date;

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        for (int i = 0; i <count ; i++) {
            jspBody.invoke(null);
            this.getJspContext().getOut().write(date.toLocaleString());
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCount(int count) {
        this.count = count;

    }
}
