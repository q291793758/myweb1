package cn.itcast.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Showbodytag extends TagSupport{

    @Override
    public int doStartTag() throws JspException {

        return Tag.SKIP_BODY;
    }
}
