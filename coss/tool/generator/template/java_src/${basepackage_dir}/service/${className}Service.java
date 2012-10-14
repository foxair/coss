<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import java.io.Serializable;
import java.util.List;

import ${import_common}.Page;
import ${basepackage}.po.${className};

public interface ${className}Service{
    
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
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public int deleteBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower});
	
	</#if>
	</#list>
}
