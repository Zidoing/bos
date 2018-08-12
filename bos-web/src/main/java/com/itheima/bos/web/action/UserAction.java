package com.itheima.bos.web.action;

import com.itheima.bos.domain.User;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.bos.utils.MD5Utils;
import com.itheima.bos.web.action.base.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 00:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction <User> {
    private String checkcode;

    @Autowired
    private IUserService userService;

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public String login() {
        System.out.println("here");
        String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        if (StringUtils.isNoneBlank(checkcode) && checkcode.equals(key)) {
            User user = userService.login(model);
            if (user != null) {
                ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
                return HOME;
            } else {
                this.addActionError("用户名密码错误");
                return LOGIN;
            }
        } else {
            this.addActionError("输入验证码错误");
            System.out.println("enter invalid code");
            return LOGIN;
        }
    }


    public String logout() {
        ServletActionContext.getRequest().getSession().invalidate();
        return LOGIN;
    }

    public String editPassword() throws IOException {
        String f = "1";
        String password = model.getPassword();
        password = MD5Utils.md5(password);

        User user = BOSUtils.getLoginUser();
        user.setPassword(password);
        try {
            userService.editPassword(user.getId(), password);

        } catch (Exception e) {
            f = "0";
            e.printStackTrace();
        }
        ServletActionContext.getResponse().getWriter().write(f);
        return NONE;
    }

}