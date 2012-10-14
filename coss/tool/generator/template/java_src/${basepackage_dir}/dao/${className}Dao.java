<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import java.io.Serializable;
import java.util.List;

import ${basepackage}.po.${className};
import ${import_common}.Page;

public interface ${className}Dao {

    public void save(${className} ${classNameLower});

    public void update(${className} ${classNameLower});
    
    public void saveOrUpdate(${className} ${classNameLower});
    
    public void deleteById(Serializable id);
    
    public void deleteByIds(List<Serializable> ids);

    public ${className} getById(Serializable id);
    
    public List<${className}> findByIds(List<Serializable> ids);
    
    public List<${className}> find(${className} ${classNameLower});

    public Page<${className}> queryPage(Integer pageIndex, Integer sizePerPage, ${className} ${classNameLower});
    
    <#list table.columns as column>
    <#if column.unique && !column.pk>
    public ${className} getBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower});
    
    </#if>
    </#list>
}
