package by.ivankov.web.dao;

import by.ivankov.web.entiry.AbstractEntity;

import java.util.List;

public abstract interface BaseDao<T extends AbstractEntity> {
    boolean insert(T t);

    boolean delete(T t);

    List<T> findAll(T t);

    T update(T t);
}
