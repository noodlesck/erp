<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 引入javascriptlib -->
<link rel="stylesheet" type="text/css" href="jslib/jquery-easyui-1.4.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jslib/jquery-easyui-1.4.5/themes/icon.css">
<script type="text/javascript" src="jslib/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function addTab(opts) {
	var t = $('#layout_center_tabs');
	
		t.tabs('add', opts);

}
</script>

<title>sshe demo</title>
</head>



<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',split:true" style="width:100px;"></div>
    <div data-options="region:'west',title:'West',split:true" style="width:100px;">
     <jsp:include page="layout/west.jsp"></jsp:include>
    </div>
    <div data-options="region:'center',title:'center title'">
    <jsp:include page="layout/center.jsp"></jsp:include>
    </div>
    
    

   
    <jsp:include page="user/login.jsp"></jsp:include>
    <jsp:include page="user/reg.jsp"></jsp:include>
    
    
    
</body>


</html>