<#import "/macro/res.ftl" as res />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<title>Add Product</title>
</head>
<body>
	<form class="form-horizontal well" action="addProduct.do" method="post">
		<legend>新增商品</legend>
        <div class="control-group">
            <label class="control-label">商品名称</label>
            <div class="controls">
				<input type="text" name="productName" placeholder="请填写商品名称">
            </div>
        </div>
		<div class="control-group">
            <label class="control-label">商品编码</label>
            <div class="controls">
				<input type="text" name="productCode" placeholder="请填写商品编码">
            </div>
        </div>
		<div class="control-group">
            <label class="control-label">售价</label>
            <div class="controls">
				<input type="text" name="retailPrice" placeholder="请填写售价">
            </div>
        </div>
		<div class="control-group">
            <label class="control-label">商品属性</label>
            <div class="controls">
				<input type="text" name="skuDefinition" placeholder="请填写商品属性">
            </div>
        </div>
		<div class="control-group">
            <label class="control-label">备注</label>
            <div class="controls">
				<textarea rows="3" NAME="remark" placeholder="没有请留空"></textarea>
            </div>
        </div>
		<div class="control-group">
            <div class="controls">
            	<button type="submit" class="btn">提交</button>
            </div>
		</div>
	</form>
</body>
</html>