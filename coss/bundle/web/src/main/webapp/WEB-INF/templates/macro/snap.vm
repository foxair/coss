<#-- 页面头文件文件 -->
<#macro page_header>
<div class="wb-header">
	<div class="wb-logo"><img src="${app_context}/res/image/app/logo.gif" height="40px" /></div>
</div>
</#macro>

<#-- 控制台头部菜单 -->
<#macro headmenu>
<div class="nav-drop-menu">
	<a href="${app_context}/" class="easyui-linkbutton" plain="true">首 页</a>
    <a href="javascript:void(0)" class="easyui-splitbutton" menu="#mm1" icon="icon-edit">商品</a>
    <a href="javascript:void(0)" class="easyui-splitbutton" menu="#mm2">订单</a>
    <a href="javascript:void(0)" class="easyui-splitbutton" menu="#mm3">内容</a>
    <a href="javascript:void(0)" class="easyui-splitbutton" menu="#mm4">客户</a>
    <a href="javascript:void(0)" class="easyui-splitbutton" menu="#mm5">销售</a>
    <a href="javascript:void(0)" class="easyui-splitbutton" menu="#mm6">报表</a>
    <a href="javascript:void(0)" class="easyui-splitbutton" menu="#mm7">系统</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" icon="icon-help">Help</a>
</div>

<div id="mm">
	<div id="mm1" class="wb-menu-main">
	    <div icon="icon-redo" class="wb-nav" id="pageA1">页面1</div>
	    <div icon="icon-redo" class="wb-nav" id="pageA2">页面2</div>
		<div icon="icon-undo" class="wb-nav" id="pageA3">页面3</div>
	    <div class="menu-sep"></div>
	    <div>
	    	<span>Toolbar</span>
	        <div style="width:150px;">
	            <div>Address</div>
	            <div>Link</div>
	            <div>Navigation Toolbar</div>
	            <div>Bookmark Toolbar</div>
	            <div class="menu-sep"></div>
	            <div>New Toolbar...</div>
	        </div>
	    </div>
	</div>
	<div id="mm2" class="wb-menu-main">
	    <div class="wb-nav" id="page1">布局嵌套</div>
	    <div class="wb-nav" id="page2">功能面板</div>
	    <div class="wb-nav" id="page3">对话框</div>
	    <div class="wb-nav" id="page4">工具条</div>
	    <div class="wb-nav" id="page5">表格1</div>
	    <div class="wb-nav" id="page6">表格2</div>
	    <div class="wb-nav" id="page7">标签面板</div>
	    <div class="wb-nav" id="page8">树控件</div>
	    <div class="wb-nav" id="page9">下拉菜单</div>
	</div>
	<div id="mm3" class="wb-menu-main">
	    <div href="http://www.google.com">Google</div>
	    <div href="http://www.msn.com">Msn</div>
	</div>
	<div id="mm4" class="wb-menu-main">
	    <div>Help</div>
	    <div>Update</div>
	    <div>About</div>
	</div>
	<div id="mm5" class="wb-menu-main">
	    <div>Help</div>
	    <div>Update</div>
	    <div>About</div>
	</div>
	<div id="mm6" class="wb-menu-main">
	    <div>Help</div>
	    <div>Update</div>
	    <div>About</div>
	</div>
	<div id="mm7" class="wb-menu-main" style="width:120px">
	    <div>系统参数配置</div>
	    <div class="menu-sep"></div>
	    <div>
	    	<span>授权管理</span>
	        <div style="width:150px;">
	            <div href="${app_context}/security/users">用户管理</div>
	            <div href="${app_context}/security/roles">角色管理</div>
	            <div>权限管理</div>
	            <div>用户角色绑定</div>
	            <div>角色权限绑定</div>
	            <div>权限资源绑定</div>
	            <div class="menu-sep"></div>
	            <div>New Toolbar...</div>
	        </div>
	    </div>
	    <div>
	    	<span>日志管理</span>
	        <div style="width:150px;">
	            <div>日志查看</div>
	            <div>日志参数配置</div>
	        </div>
	    </div>
	    <div>邮件系统设置</div>
	    <div>About</div>
	</div>
</div>
</#macro>

<#-- 控制左侧菜单 -->
<#macro leftmenu>
<div class="easyui-panel wb-panel-left" title="客户信息" collapsible="true" border="false">
    <ul class="wb-nav-list">
		<li>激活： <span class="num">68</span></li>
		<li>未激活： <span class="num">6</span></li>
		<li>3333333： <span class="num">50</span></li>
		<li>Ordinary Members： <span class="num">20</span></li>
		<li>10%discount： <span class="num">3</span></li>
	</ul>
</div>
<br/>
<div class="easyui-panel wb-panel-left" title="订单信息" collapsible="true" border="false">
    <ul class="wb-nav-list">
		<li>新到订单： <span class="num">550</span></li>
		<li>处理中： <span class="num">325</span></li>
		<li>已完成： <span class="num">0</span></li>
		<li>暂停处理： <span class="num">3</span></li>
		<li>已取消： <span class="num">7</span></li>
		<li>缺货： <span class="num">0</span></li>
		<li>等待支付： <span class="num">356</span></li>
		<li>已备货： <span class="num">0</span></li>
		<li>已发货： <span class="num">0</span></li>
		<li>已取消： <span class="num">7</span></li>
	</ul>
</div>
<br/>
<div class="easyui-panel wb-panel-left" title="库存信息" collapsible="true" collapsed="true" border="false">
	<ul class="wb-nav-list">
		<li class="title"></li>
		<li>缺货Sku总数量： <span class="num">0</span></li>
		<li>其中激活： <span class="num">0</span></li>
		<li>低库存Sku总数量： <span class="num">0</span></li>
		<li>其中激活： <span class="num">0</span></li>
		<li>已到再进货时间Sku</li>
		<li>总数量： <span class="num">0</span></li>
	</ul>
</div>
<br/>
<div class="easyui-panel wb-panel-left" title="系统信息" collapsible="true" border="false">
    My documents<br/>
    File folder<br/><br/>
    Date modified: Oct.3rd 2010
</div>
</#macro>