package cn.itcast.Tags.SimpleTage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
//修改标签体
public class simpleTag3 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        StringWriter writer = new StringWriter();
        //写到带有缓冲区的StringWriter()里
        jspBody.invoke(writer);
        //获得缓冲的内容
        String content = writer.toString();
        content=content.toUpperCase();
        this.getJspContext().getOut().write(content);
    }
}
