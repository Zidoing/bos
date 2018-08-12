package com.itheima.bos.dao.impl;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.dao.base.impl.BaseDaoImpl;
import com.itheima.bos.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 00:10
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl <User> implements IUserDao {


    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String hql = "FROM User  WHERE username=? and password=?";


        List <User> list = (List <User>) this.getHibernateTemplate().find(hql, username, password);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


}