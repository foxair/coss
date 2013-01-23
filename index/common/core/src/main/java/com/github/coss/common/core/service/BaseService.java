package com.github.coss.common.core.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.core.orm.mybatis.QueryRequest;
import com.github.coss.common.core.orm.mybatis.SqlMapDao;

@Transactional
public abstract class BaseService<T> {

    protected abstract SqlMapDao<T> getSqlMapDao();

    /** 插入数据 */
    protected int save(T entity) throws DataAccessException {
        return getSqlMapDao().save(entity);
    }

    /** 根据id检查是否插入或是更新数据 */
    protected int saveOrUpdate(T entity) throws DataAccessException {
        return getSqlMapDao().saveOrUpdate(entity);
    }

    protected int removeById(Serializable id) throws DataAccessException {
        return getSqlMapDao().deleteById(id);
    }

    protected int removeByIds(Serializable[] ids) throws DataAccessException {
        return getSqlMapDao().deleteByIds(ids);
    }

    protected int update(T entity) throws DataAccessException {
        return getSqlMapDao().update(entity);
    }

    @Transactional(readOnly = true)
    protected T getById(Serializable id) throws DataAccessException {
        return (T) getSqlMapDao().getById(id);
    }

    @Transactional(readOnly = true)
    protected List<T> findAll() throws DataAccessException {
        return (List<T>) getSqlMapDao().findAll();
    }

    @Transactional(readOnly = true)
    protected Page<T> findPage(QueryRequest<?> pr) {
        return getSqlMapDao().findPage(pr);
    }

}
