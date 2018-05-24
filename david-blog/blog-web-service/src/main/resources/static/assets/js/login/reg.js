$(function () {
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
           //自定义验证规则
            form.verify({

            });
    });
//用户注册
  $('#submit').click(function(){
      var username = $("#username").val();
      if(username == null || username == ''){
          layer.msg('请输入手机号', {icon: 5});
          return false;
      }else if(!(/^1[34578]\d{9}$/.test(username))){
          layer.msg('手机号码格式不正确', {icon: 5});
          return false;
      }
      var password = $("#password").val();
      if (password == null || password == ''){
          layer.msg('请输入密码！',{icon:5});
          return false;
      }else if(!(/^(\w){6,20}$/.test(password))){
          layer.msg('只能输入6-20个字母、数字、下划线！',{icon:5});
          return false;
      }
      var repassword = $("#repassword").val();
      if (repassword == null || repassword == ''){
          layer.msg('请输入确认密码！',{icon:5});
          return false;
      }else if (repassword != password){
          layer.msg('两次密码不相符！',{icon:5});
          return false;
      }
      $.ajax({
          url:"/auth/insertUser",
          type:"post",
          datatype:"json",
          data:{
              phoneNum:username,
              password:password
          },
          success:function (data) {
              if (data.state=1) {
                  layer.msg(data.message, {icon: 5});
              }else {
                  layer.msg(data.message, {icon: 5});
              }
          }
      });
  });
});

