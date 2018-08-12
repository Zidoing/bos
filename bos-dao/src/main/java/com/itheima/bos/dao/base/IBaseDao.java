package com.itheima.bos.dao.base;

import com.itheima.bos.utils.PageBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 11/08/2018
 * Time: 23:45
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface IBaseDao<T> {

    public void save(T entity);

    public void delete(T entity);

    public void update(T entity);

    public T findById(Serializable id);

    public List <T> findAll();

    public void executeUpdate(String queryName, Object... objects);

    public void pageQuery(PageBean pageBean);


}