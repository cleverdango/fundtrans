package com.mybank.fundtrans.dao;
import java.util.List;
import java.io.Serializable;

/**
 * Created by yazawanico on 2017/5/7.
 */
public interface BaseDao<T> {
    // 根据ID加载实体
    T get(Class<T> entityClazz , Serializable id);
    // 保存(插入)实体
    Serializable save(T entity);
    // 更新实体
    void update(T entity);
    // 删除实体
    void delete(T entity);
    // 根据ID删除实体
    void delete(Class<T> entityClazz , Serializable id);
    // 获取所有实体
    List<T> findAll(Class<T> entityClazz);
    // 获取实体总数
    long findCount(Class<T> entityClazz);
}
