package com.itheima.bos.web.interceptor;

import com.itheima.bos.domain.User;
import com.itheima.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class BOSLoginInteceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {


        User user = BOSUtils.getLoginUser();
        if (user == null) {
            return "login";
        } else {
            return invocation.invoke();
        }
    }
}