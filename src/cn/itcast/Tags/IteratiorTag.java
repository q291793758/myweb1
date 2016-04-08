package cn.itcast.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//控制标签体执行五次
public class IteratiorTag extends TagSupport {
    int x=5;
    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }
    @Override
    public int doAfterBody() throws JspException {
        x--;
        if (x > 0) {
            return IteratiorTag.EVAL_BODY_AGAIN;
        } else {
            return IteratiorTag.SKIP_BODY;
        }

    }
}
