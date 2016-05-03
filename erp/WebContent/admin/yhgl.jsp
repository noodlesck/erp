<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$('#admin_yhgl_datagrid').datagrid({
    url:'${pageContext.request.contextPath}/user!dataGrid.action',
    idField:'id',
    frozenColumns:[[{field:'id',title:'用户编号',width:100}]],
    fitColumns:true,
    pageNumber:1,
    pageSize:10,
    pageList:[10,20,30,40,50],
    pagination:true,
    columns:[[
        
        {field:'name',title:'用户名字',width:100},
        {field:'password',title:'密码',width:100,align:'right'}
        
    ]]
});
</script>
<div class="easyui-layout">
<table id="admin_yhgl_datagrid"></table>
</div>

	<div>
		<form>
			<table>
               <table>
			<tr>
				<th>编号</th>
				<td><input name="id" readonly="readonly" />
				</td>
				<th>登录名称</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="pwd" type="password" class="easyui-validatebox" data-options="required:true" />
				</td>
				<th>创建时间</th>
				<td><input name="createdatetime" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<th>最后修改时间</th>
				<td><input name="modifydatetime" readonly="readonly" />
				</td>
				<th></th>
				<td></td>
			</tr>

			</table>
		</form>

	</div>


</body>
</html>