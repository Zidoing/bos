package com.itheima.bos.service.impl;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 00:42
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public User login(User user) {
        String password = MD5Utils.md5(user.getPassword());

        return userDao.findUserByUsernameAndPassword(user.getUsername(), password);
    }

    @Override
    public void editPassword(String id, String password) {
        userDao.executeUpdate("user.editpassword", password, id);
    }
}