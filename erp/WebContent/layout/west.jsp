<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="aa" class="easyui-accordion"
	data-options="fit:true,boder:false">
	<div title="Title1" data-options="iconCls:'icon-save',selected:true">
		<ul id="index_tree" class="easyui-tree"
			data-options="url:'${pageContext.request.contextPath}/menu!getTree.action',
			parentField : 'id',lines : true,
			onClick: function(node){
			if(node.attributes.url){
			var url = '${pageContext.request.contextPath}'+node.attributes.url;
			addTab({title : node.text,closable:true,href:'admin/yhgl.jsp'});
			}
			}">
		</ul>
	</div>
	<div title="Title2" data-options="iconCls:'icon-reload'"></div>
</div>