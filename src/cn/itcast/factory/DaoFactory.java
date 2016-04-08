package cn.itcast.factory;

import cn.itcast.exceptions.DaoException;
import com.intellij.openapi.roots.ui.configuration.artifacts.sourceItems.actions.PutSourceItemIntoParentAndLinkViaManifestAction;

import java.io.IOException;
import java.util.Properties;

//singleInstance
public class DaoFactory {
    private static DaoFactory ourInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    Properties daoconfig = new Properties();

    private DaoFactory() {
        try {
            daoconfig.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }


    public <T> T createDao(Class<T> clazz) {
        //获得相对应类名
        String name = clazz.getName();   //cn.itcast.dao.impl.UserDaoJdbcImpl
        name=name.substring(name.lastIndexOf(".")+1);
        //String name=clazz.getSimpleName();  //UserDaoJdbcImpl
        String classname = daoconfig.getProperty(name);

        try {
             T dao= (T) Class.forName(classname).newInstance();
            return dao;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


}
