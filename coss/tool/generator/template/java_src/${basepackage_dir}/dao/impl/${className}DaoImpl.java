<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.po.${className};
import ${import_common}.BaseSqlMapDao;
import ${import_common}.Page;
import ${import_common}.QueryRequest;

@Repository("${classNameLower}Dao")
public class ${className}DaoImpl extends BaseSqlMapDao<${className}> implements ${className}Dao{
	
    public void save(${className} ${classNameLower}) {
        getSqlSessionTemplate().insert("${classNameLower}.insert", ${classNameLower});
    }

    public void update(${className} ${classNameLower}) {
        getSqlSessionTemplate().update("${classNameLower}.update", ${classNameLower});
    }
    
    public void saveOrUpdate(${className} ${classNameLower}) {
        if(${classNameLower}.getId() == null) 
            save(${classNameLower});
        else
            update(${classNameLower});
    }
    
    public void deleteById(Serializable id) {
        getSqlSessionTemplate().delete("${classNameLower}.deleteById", id);
    }
    
    public void deleteByIds(List<Serializable> ids) {
        getSqlSessionTemplate().delete("${classNameLower}.deleteByIds", ids);
    }

    public ${className} getById(Serializable id) {
        ${className} object = (${className}) getSqlSessionTemplate().selectOne("${classNameLower}.getById", id);
        return object;
    }
    
    public List<${className}> findByIds(List<Serializable> ids) {
        List<${className}> ${classNameLower}List = getSqlSessionTemplate().selectList("${classNameLower}.findByIds", ids);
        return ${classNameLower}List;
    }
    
    public List<${className}> find(${className} ${classNameLower}){
        List<${className}> ${classNameLower}List = getSqlSessionTemplate().selectList("${classNameLower}.find", ${classNameLower});
        return ${classNameLower}List;
    }
    
    public Page<${className}> queryPage(Integer pageIndex, Integer sizePerPage, ${className} ${classNameLower}) {
        QueryRequest<Product> queryRequest = new QueryRequest<Product>(pageIndex, sizePerPage, ${classNameLower});
        return this.findPage(queryRequest);
    }
    
    <#list table.columns as column>
    <#if column.unique && !column.pk>
    public ${className} getBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower}) {
        return (${className})getSqlSessionTemplate().selectOne("${classNameLower}.getBy${column.columnName}",${column.columnNameFirstLower});
    }
    
    </#if>
    </#list>
    
    public String getSqlMapNamesapce() {
        return "${classNameLower}";
    }

}
