<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<script type="text/javascript">
	$(function() {
		$('#user_reg_regForm').form({
			url : '${ pageContext.request.contextPath}/user!reg.action',
			success : function(r) {
				var obj = jQuery.parseJSON(r);
				if (obj.success) {
					$('#user_reg_regDialog').dialog('close');
				}
				$.messager.show({
					title : '提示',
					msg : obj.msg
				});
			}
		});
		$('#user_reg_regForm input').bind('keyup', function(event) {/* 增加回车提交功能 */
			if (event.keyCode == '13') {
				$('#user_reg_regForm').submit();
			}
		});
	});
</script>

 <div id="user_reg_dialog" class="easyui-dialog" title="新用户注册" style="width:220px;height:180px;"
         data-options="resizable:true,modal:true,closable:true,closed:true,
			buttons:[{
				text:'注册',
				handler:function(){
				$('#user_reg_regForm').submit();
				}
			}]">
         <form id="user_reg_regForm" method="post">
         <table>
         <tr><td>用户名：</td>
         <th><input name ="name" class="easyui-validatebox" data-options="required:true"/></th>
         </tr>
         <tr><td>密码：</td>
         <th><input id="pwd" name ="password" class="easyui-validatebox" data-options="required:true"/></th>
         </tr>
         <tr><td>确认密码：</td>
         <th><input id="pwd2" name ="password2" class="easyui-validatebox" data-options="required:true" validType="equals['#pwd']"/></th>
         </tr>
         </table>
         </form>
    </div>
    
