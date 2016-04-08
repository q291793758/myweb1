package cn.itcast.Tags.SimpleTage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class foreach2_tag extends SimpleTagSupport{
    private Object item;
    private String var;
    private Collection collection;

    public void setVar(String var) {
        this.var = var;
    }

    public void setItem(Object item) {
        //单列集合
        this.item = item;
        if (item instanceof Collection) {
            collection= (Collection)item;
        }
        //双列数组转单列 Map -->entryset()
        if (item instanceof Map) {
            Map map=  (Map)item;
            collection= map.entrySet();
        }
        //对象数组
        if (item instanceof Objects[]) {
            Object[] obj= (Object[])item;
            collection = Arrays.asList(obj);
        }
        //基本数据类型(int short long等)与以上都不匹配
        //用反射类中的 .getClass().isArray()判定此 Class 对象是否表示一个数组类。
        if (item.getClass().isArray()) {
            Collection collection=new ArrayList();
           //java.lang.reflect Array 类提供了动态创建和访问 Java 数组的方法。
            //获得数组的长度
           int length= Array.getLength(item);
            //get(Object array, int index) 返回指定数组对象中索引组件的值。
            for (int i = 0; i < length ; i++) {
                Object value = Array.get(item, i);
                collection.add(value);
            }

        }
    }
    @Override
    public void doTag() throws JspException, IOException {
        Iterator iterator = this.collection.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            this.getJspContext().setAttribute("entry",value);
            this.getJspBody().invoke(null);
        }
    }

}
