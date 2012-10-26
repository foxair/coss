<#import "/macro/res.ftl" as res />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<title>ProductList</title>
</head>
<body>
	<button class="btn" onclick="window.open('addProduct.htm')">新增</button><br />
	<table class="table table-hover">
		<tr><th>产品名称</th><th>编号</th><th>售价</th></tr>
		<#list page.result as product>
		<tr><td>${product.productName}</td><td>${product.productCode}</td><td>${product.retailPrice}</td></tr>
		</#list>
	</table>
	<div class="pagination">
		<ul>
			<li><a href="?page=${page.previousPageNumber}">Prev</a></li>
			<#list pageNumbers as num>
			<li><a href="?page=${num}">${num}</a></li>
			</#list>
			<li><a href="?page=${page.nextPageNumber}">Next</a></li>
		</ul>
	</div>
</body>
</html>