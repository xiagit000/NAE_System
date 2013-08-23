package com.boventech.gplearn.service;

import java.io.Serializable;

/**
 * 基本业务接口
 */
public interface BaseService<T, ID extends Serializable> {

    void save(T t);

    void delete(T t);
    
    void delete(ID id);

    void update(T t);
    
    T findById(ID id);

}