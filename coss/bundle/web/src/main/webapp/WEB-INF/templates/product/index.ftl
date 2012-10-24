<#import "/macro/res.ftl" as res />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>WorkBench</title>
</head>
<body class="easyui-layout"> 
	<div region="north" style="height:40px; overflow: hidden;">
		<div class="wb-header">
			<div class="wb-logo"><img src="/res/image/app/gmclogo.gif" /></div>
			<div class="nav-drop-menu" style="width:600px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" plain="true">首 页</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm1" icon="icon-edit">商品</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm2">订单</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm3">内容</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm4">客户</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm5">销售</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm6">报表</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm7">系统</a>
			    <a href="javascript:void(0)" class="easyui-menubutton" menu="#mm8" icon="icon-help"></a>
			</div>
			
			<div id="mm1">
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
			<div id="mm2">
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
			<div id="mm3">
			    <div href="http://www.google.com">Google</div>
			    <div href="http://www.msn.com">Msn</div>
			</div>
			<div id="mm4" style="width:100px;">
			    <div>Help</div>
			    <div>Update</div>
			    <div>About</div>
			</div>
		</div>
	</div>
	
	<div region="west" title="快捷操作" style="width:200px;overflow:hidden;">
	    <div class="easyui-panel wb-panel-left" title="客户信息" collapsible="true">
	        <ul class="wb-nav-list">
				<li>激活： <span class="num">68</span></li>
				<li>未激活： <span class="num">6</span></li>
				<li>3333333： <span class="num">50</span></li>
				<li>Ordinary Members： <span class="num">20</span></li>
				<li>10%discount： <span class="num">3</span></li>
			</ul>
	    </div>
	    <br/>
	    <div class="easyui-panel wb-panel-left" title="订单信息" collapsible="true">
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
	    <div class="easyui-panel wb-panel-left" title="库存信息" collapsible="true" collapsed="true">
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
	    <div class="easyui-panel wb-panel-left" title="系统信息" collapsible="true">
	        My documents<br/>
	        File folder<br/><br/>
	        Date modified: Oct.3rd 2010
	    </div>
	</div>
	
	<div region="center" resizable="false" title="工作面板" style="overflow:hidden;">
		<div id="tabpanel" class="easyui-tabs" fit="true" border="false">
			<div title="数据表" icon="icon-reload" closable="false" style="overflow:hidden;padding:5px;">
				<table id="tt2"></table>
			</div>
		</div>
	</div>
	
	<div region="east" icon="icon-reload" title="Tree Menu" split="true" style="width:180px;">
		<ul class="easyui-tree" url="tree_data.json"></ul>
	</div>
	
	<div region="south" style="height:40px; overflow: hidden;">
		<div class="wb-footer"></div>
	</div>
	<div id="wins"></div>
</body>
</html>