package com.boventech.gplearn.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {

    void save(T t);
    
    void save(List<T> ts);

    T merge(T t);

    T findByID(ID id);

    void deleteById(ID id);

    void deleteByIds(ID[] ids);

    void delete(T t);
    
    void delete(List<T> ts);

    void update(T t);

}
