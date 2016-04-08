package cn.itcast.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ShowPagetag   extends TagSupport {

    @Override
    public int doEndTag() throws JspException {

        return Tag.EVAL_PAGE;
    }
}
