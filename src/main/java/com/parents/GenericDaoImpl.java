package com.parents;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T,ID> {
    private Class<T> persistentClass;
    private SessionFactory sessionFactory;

    public GenericDaoImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T findById(ID id) {
        return (T)getSession().get(getPersistentClass(), id);
    }

    public List<T> findAll() {
        return findByCriteria();
    }

    public List<T> findByExample(T exampleInstance, String... excludeProperty) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        Example example =  Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        criteria.add(example);
        return criteria.list();
    }

    public T findOneByExample(T example, String... excludeProperty) {
        List<T> results = findByExample(example, excludeProperty);
        if(results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }

    public T save(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public List<T> findByCriteria(Criterion... criterion) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        return criteria.list();
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }
    
    public void refresh(T entity) {
    	getSession().refresh(entity);
    }
   
}