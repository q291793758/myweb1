package cn.itcast.Tags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

//修改标签体 toUppercase
public class ChangeContextTag extends BodyTagSupport {

    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {

        BodyContent bodyContent = this.getBodyContent();
        String s = bodyContent.getString();
        try {
            this.pageContext.getOut().write(s.toUpperCase());
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        return Tag.EVAL_PAGE;
    }
}
