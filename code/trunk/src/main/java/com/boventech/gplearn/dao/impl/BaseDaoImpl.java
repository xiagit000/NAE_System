package com.boventech.gplearn.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import me.donnior.rtl.paginate.PaginateSupportArray;

import com.boventech.gplearn.dao.BaseDao;
import com.google.common.base.Strings;

public abstract class BaseDaoImpl<T, I extends Serializable> implements BaseDao<T, I> {

    static final int DEFAULT_PAGESIZE = 10;

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void save(T t) {
        entityManager.persist(t);
    }

    public void save(List<T> ts) {
        int i = 0;
        for (T t : ts) {
            entityManager.persist(t);
            if (i % 30 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

    public T merge(T t) {
        return entityManager.merge(t);
    }

    public void update(T t) {
        entityManager.merge(t);
    }

    public void deleteById(I id) {
        final Class<T> pclass = this.entityClass;
        T t = entityManager.find(pclass, id);
        if (null != t) {
            entityManager.remove(t);
        }
    }

    public void deleteByIds(I[] ids) {
        for (I id : ids) {
            deleteById(id);
        }
    }

    public void delete(T t) {
        if (null != t) {
            entityManager.remove(t);
        }
    }

    public void delete(List<T> ts) {
        for (T t : ts) {
            delete(t);
        }
    }
    
    public T findByID(I id) {
        final Class<T> pclass = this.entityClass;
        return entityManager.find(pclass, id);
    }

    public int executeCountQuery(String queryString, Object... restricts) {
        Query query = entityManager.createQuery(queryString);
        for (int i = 0; i < restricts.length; i++) {
            query.setParameter(i + 1, restricts[i]);
        }
        Number singleResult = null;
        try {
            singleResult = (Number) query.getSingleResult();
        } catch (NoResultException e) {
        }
        return null == singleResult ? 0 : singleResult.intValue();
    }

    /**
     * 
     * @param queryString
     *            jpql查询字符串
     * @param pageIndex
     *            当前翻页条件
     * @param restricts
     *            查询的限制条件
     * @return 符合查询条件的当前页资源list
     */
    @SuppressWarnings("unchecked")
    protected PaginateSupportArray<T> executeQueryWithPagination(String queryString, String order,
            Integer page, Object... restricts) {
        if (page == null || page < 0) {
            page = 1;
        }
        int total = executeCountQuery("select count(*) " + queryString, restricts);

        String queryWithOrd = Strings.isNullOrEmpty(order) ? queryString : (queryString + order);
        Query query = entityManager.createQuery(queryWithOrd);
        setParameter(query, restricts);
        query.setFirstResult((page - 1) * DEFAULT_PAGESIZE);
        query.setMaxResults(DEFAULT_PAGESIZE);

        List<T> result = query.getResultList();
        PaginateSupportArray<T> paginateList = new PaginateSupportArray<T>(result);
        paginateList.setPage(page);
        paginateList.setTotal(total);
        paginateList.setPageSize(DEFAULT_PAGESIZE);

        return paginateList;
    }

    @SuppressWarnings("unchecked")
    public List<T> executeQueryWithoutPaging(String queryString, Object... restricts) {
        Query query = entityManager.createQuery(queryString);
        for (int i = 0; i < restricts.length; i++) {
            query.setParameter(i + 1, restricts[i]);
        }
        return query.getResultList();
    }

    public List<?> executeQuery(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    protected int executeUpdateOrDelete(String sqlString, Object... restricts) {
        Query query = entityManager.createQuery(sqlString);
        setParameter(query, restricts);
        return query.executeUpdate();

    }

    protected void setParameter(Query query, Object... restricts) {
        for (int i = 0; i < restricts.length; i++) {
            query.setParameter(i + 1, restricts[i]);
        }
    }

    public void flush() {
        entityManager.flush();
        entityManager.clear();
    }
}
