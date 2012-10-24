<#import "/spring.ftl" as spring/>
<#import "/macro/res.ftl" as res />
<#import "/macro/snap.ftl" as snap />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html> 
<head> 
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    <title>Portal Layout Sample</title> 
	<@res.ext />
	<link rel="stylesheet" type="text/css" href="${app_context}/res/script/ext/portal/portal.css" /> 
    <script type="text/javascript" src="res/script/ext/portal/portal.js"></script> 
    <script type="text/javascript" src="res/script/app/index.js"></script> 
</head> 
<body> 
    <span id="app-msg" style="display:none;"></span> 
</body> 
</html>