<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>

<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#user_login_loginForm').form({
			url : '${ pageContext.request.contextPath}/user!login.action',
			success : function(r) {
				var obj = jQuery.parseJSON(r);
				if (obj.success) {
					$('#user_login_loginDialog').dialog('close');
				}
				$.messager.show({
					title : '提示',
					msg : obj.msg
				});
			}
		});
		$('#user_reg_regForm input').bind('keyup', function(event) {/* 增加回车提交功能 */
			if (event.keyCode == '13') {
				$('#user_login_loginForm').submit();
			}
		});
	});
</script>

<div id="user_login_loginDialog" class="easyui-dialog" title="登陆" style="width:220px;height:180px;"
         data-options="resizable:true,modal:true,closable:false,
			buttons:[{
				text:'注册',
				handler:function(){$('#user_reg_dialog').dialog('open');}
			},{
				text:'登陆',
				handler:function(){$('#user_login_loginForm').submit();}
			}]">
        <form id="user_login_loginForm" method ="post">
         <table>
            <tr>
               <td>用户名：</td>
               <th><input name ="name" class="easyui-validatebox" data-options="required:true"/></th>
            </tr>
            <tr>
               <td>密码：</td>
               <th><input name ="password" class="easyui-validatebox" data-options="required:true"/></th>
            </tr>
         </table>
         </form>
    </div>
