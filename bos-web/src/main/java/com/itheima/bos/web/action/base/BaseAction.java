package com.itheima.bos.web.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 00:05
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven <T> {
    public static final String HOME = "home";
    public static final String LIST = "list";

    protected T model;

    @Override
    public T getModel() {
        return model;
    }


    public BaseAction() {

        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        Class <T> actualTypeArgument = (Class <T>) actualTypeArguments[0];
        try {
            model = actualTypeArgument.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}