package com.netcracker.tc.server.persistence.dao.common;

import com.netcracker.tc.server.persistence.exception.DaoException;

import java.io.Serializable;

/**
 * Created by unconsionable on 29.07.2014.
 */
public interface IDao<T, PK extends Serializable> {

    void create(T entity);

    void createOrUpdate(T entity);

    T get(PK pk);

    T update(T entity);

    void delete(T entity);

    void deleteByPK(PK pk);
}