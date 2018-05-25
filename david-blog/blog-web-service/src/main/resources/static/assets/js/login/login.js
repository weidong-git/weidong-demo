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
  /*用户登录*/
   $("#submit").click(function () {
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
       }
       $.ajax({
           url:"/auth/login",
           type:"post",
           datatype:"json",
           data:{
               phoneNum:username,
               password:password
           },
           success:function (data) {
               if (data.state=1) {
                   layer.msg(data.message, {icon: 5});
                   window.localhost.href="/view/admin-admin";
               }else {
                   layer.msg(data.message, {icon: 5});
               }
           }
       });

   });



});


// 刷新图片
function changeImg() {
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", changeUrl(src));
}
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function changeUrl(url) {
    var timestamp = (new Date()).valueOf();
    var index = url.indexOf("?",url);
    if (index > 0) {
        url = url.substring(0, url.indexOf(url, "?"));
    }
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}