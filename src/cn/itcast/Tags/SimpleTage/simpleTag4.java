package cn.itcast.Tags.SimpleTage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

//控制标签剩下的内容不执行:
public class simpleTag4 extends SimpleTagSupport{
    @Override
    public void doTag() throws JspException, IOException {
        throw new SkipPageException();
    }
}
