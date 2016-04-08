package cn.itcast.Tags.SimpleTage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class foreach_tag extends SimpleTagSupport {
    //有可能传ArrayLIST HashMap等,所以类型是Object
    private Object item;
    private String var;

    @Override
    public void doTag() throws JspException, IOException {
       //迭代标签比较复杂,这里只考虑简单情况,只对List进行迭代
        List list= (List) item;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object value=iterator.next();
            //把迭代出的东西存在域里
            this.getJspContext().setAttribute(var,value);
            //通过${var}取出数据
            this.getJspBody().invoke(null);
        }
    }

    public void setItem(Object item) {
        this.item = item;
    }
    public void setVar(String var) {
        this.var = var;
    }
}
