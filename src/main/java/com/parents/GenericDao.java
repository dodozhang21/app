package com.parents;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
    Object findById(ID id);

    List<T> findAll();

    List<T> findByExample(T exampleInstance, String... excludeProperty);

    T findOneByExample(T exampleInstance, String... excludeProperty);

    Object save(T entity);

    void delete(T entity);

    List<T> findByCriteria(Criterion... criterion);

    void flush();

    void clear();
}
