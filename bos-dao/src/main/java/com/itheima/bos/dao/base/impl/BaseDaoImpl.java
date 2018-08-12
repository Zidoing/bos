package com.itheima.bos.dao.base.impl;

import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.utils.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 11/08/2018
 * Time: 23:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao <T> {

    private Class <T> entityClass;

    @Resource
    public void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public BaseDaoImpl() {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        this.entityClass = (Class <T>) actualTypeArguments[0];
    }

    @Override
    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public T findById(Serializable id) {
        return this.getHibernateTemplate().get(entityClass, id);
    }

    @Override
    public List <T> findAll() {

        String hql = "FROM " + entityClass.getSimpleName();
        return (List <T>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public void executeUpdate(String queryName, Object... objects) {
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery(queryName);

        int i = 0;
        for (Object object : objects) {
            query.setParameter(i++, object);
        }
        query.executeUpdate();

    }

    @Override
    public void pageQuery(PageBean pageBean) {
        int currentPage = pageBean.getCurrentPage();
        int pageSize = pageBean.getPageSize();

        DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
        detachedCriteria.setProjection(Projections.rowCount());

        List <Long> countList = (List <Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);

        pageBean.setTotal(countList.get(0).intValue());

        detachedCriteria.setProjection(null);

        int maxResults = pageSize;
        int firstResult = (currentPage - 1) * pageSize;
        List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
        pageBean.setRows(rows);

    }
}