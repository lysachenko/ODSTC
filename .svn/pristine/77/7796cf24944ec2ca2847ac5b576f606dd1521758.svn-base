package com.netcracker.tc.server.persistence.dao.common;

import com.google.common.base.Preconditions;
import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T, PK extends Serializable> implements IDao<T, PK> {

    private Class<T> clazz;

    private SessionFactory sessionFactory;

    public AbstractHibernateDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void create(T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().save(entity);
    }

    @Override
    public void createOrUpdate(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public T get(PK pk) {
        return (T) getCurrentSession().get(clazz, pk);
    }

    @Override
    public T update(T entity) {
        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteByPK(PK pk) {
        final T entity = get(pk);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    protected <PLC extends PagingLoadConfig, T> PagingLoadResult<T> loadPagingData(Criteria criteria, PLC loadConfig){
        int dbItemCount = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();

        int pageSize = loadConfig.getPageSize();
        int pageNumber = loadConfig.getPageNumber();

        int dataPageCount = dbItemCount / pageSize;

        pageNumber = pageNumber <= dataPageCount ? pageNumber : dataPageCount;

        int fromRange = pageNumber * pageSize;
        int toRange = Math.min(fromRange + pageSize, dbItemCount);

        criteria.setProjection(null);
        criteria.setFirstResult(fromRange);
        criteria.setMaxResults(toRange - fromRange);

        List<T> result = criteria.list();

        return new PagingLoadResult<T>(result, fromRange, dbItemCount);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}