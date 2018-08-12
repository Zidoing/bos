package com.itheima.bos.utils;

import com.itheima.bos.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class BOSUtils {

    public static HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }


    public static User getLoginUser() {
        return (User) getSession().getAttribute("loginUser");
    }
}