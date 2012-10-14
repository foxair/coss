<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.po.${className};
import ${basepackage}.service.${className}Service;
import ${import_common}.Page;
import ${import_common}.SqlMapDao;
import ${import_project_package}.common.core.service.BaseService;

@Service("${classNameLower}Service")
@Transactional
public class ${className}ServiceImpl extends BaseService<${className}> implements ${className}Service{

    @Resource
	private ${className}Dao ${classNameLower}Dao;
	
    public void save(${className} ${classNameLower}) {
        ${classNameLower}Dao.save(${classNameLower});
    }

    public void update(${className} ${classNameLower}) {
        ${classNameLower}Dao.update(${classNameLower});
    }
    
    public void saveOrUpdate(${className} ${classNameLower}) {
        if(${classNameLower}.getId() == null) 
            save(${classNameLower});
        else
            update(${classNameLower});
    }
    
    public void deleteById(Serializable id) {
        ${classNameLower}Dao.deleteById(id);
    }
    
    public void deleteByIds(List<Serializable> ids) {
        ${classNameLower}Dao.deleteByIds(ids);
    }

    public ${className} getById(Serializable id) {
        ${className} object = (${className}) ${classNameLower}Dao.getById(id);
        return object;
    }
    
    public List<${className}> findByIds(List<Serializable> ids) {
        List<${className}> ${classNameLower}List = ${classNameLower}Dao.findByIds(ids);
        return ${classNameLower}List;
    }
    
    public List<${className}> find(${className} ${classNameLower}){
        List<${className}> ${classNameLower}List = ${classNameLower}Dao.find(${classNameLower});
        return ${classNameLower}List;
    }
    
    public Page<${className}> queryPage(Integer pageIndex, Integer sizePerPage, ${className} ${classNameLower}) {
        return ${classNameLower}Dao.queryPage(pageIndex, sizePerPage, ${classNameLower});
    }
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public int deleteBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower}){
		return ${classNameLower}Dao.deleteBy${column.columnName}(${column.columnNameFirstLower});
	}
	
	</#if>
	</#list>
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	@Transactional(readOnly=true)
	public ${className} getBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower}) {
		return ${classNameLower}Dao.getBy${column.columnName}(${column.columnNameFirstLower});
	}
	
	</#if>
	</#list>
	
	public void set${className}Dao(${className}Dao dao) {
        this.${classNameLower}Dao = dao;
    }
    
    @SuppressWarnings("unchecked")
    public SqlMapDao<${className}> getSqlMapDao() {
        return (SqlMapDao<${className}>) this.${classNameLower}Dao;
    }
}
