





   $("#submit").click(function () {
       var username = $("#username").val();
       if(username == null || username == ''){
           layer.msg('请输入手机号', {icon: 5});
           return false;
       }else if(!(/^1[34578]\d{9}$/.test(username))){
           layer.msg('手机号码格式不正确', {icon: 5});
           return false;
       }
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