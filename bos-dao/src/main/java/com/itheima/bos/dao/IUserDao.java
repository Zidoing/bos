package com.itheima.bos.dao;

import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 00:09
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface IUserDao extends IBaseDao <User> {
    User findUserByUsernameAndPassword(String username, String password);
}