function codes(n){
    const a = "zxcvbnmasdfghjklqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
    let b = "";
    for(let i=0; i<n; i++){
        const index = Math.floor(Math.random() * 62);
        //根据下标来获取字符：
        b+=a.charAt(index)+" ";
    }
    return b;
}
function show(){
    document.getElementById("regCheckCodes").innerHTML=codes(4);
}
window.onload=show;
//  end of codes

//验证登录密码
function checkPassword() {
    const $span = $("#password_s");
    const $input = $("#passWord");
    //非空验证：
    if($input.val()===""){
        $span.addClass("error");
        $span.html("&nbsp;密码不能为空");
        return false;
    }
    //正确：
    $span.removeClass("error");
    return true;
}

//验证第二次输入的密码
function second_Pwd(){
    const $span1 = $("#password_ss");
    const $raped = $("#password_again");
    if($raped.val()===""){
        $span1.addClass("error");
        $span1.html("输入不能为空");
        return false;
    }
    const pwd1 = $("#passWord").val();
    const pwd2 = $raped.val();

    if(pwd2!==pwd1){
        $span1.addClass("error");
        $span1.html("两次输入的密码不一致");
        return false;
    }
    //正确：
    $span1.html("ok")
    $span1.removeClass("error");
    $span1.addClass("ok111")
    return true;
}




$(function () {
    $("#userName").blur(function () {
        const $name = $("#userName").val();
        const $spanName = $("#spanName")
        if ($name==null || $name===""){
            $spanName.removeClass("ok111")
            $spanName.addClass("error");
            $spanName.html("用户名不能为空");
        }else {
            $.post("../UserServlet?method=doRename",{"name":$name},function (data) {
                if (data.flag ==="true"){
                    $spanName.removeClass("error")
                    $spanName.addClass("ok111");
                    $spanName.html("用户名可以使用！！！");
                }else{
                    $spanName.removeClass("ok111");
                    $spanName.addClass("error");
                    $spanName.html("用户名已被注册！！！");
                }
            },"JSON");
        }
    })

    $("#passWord").blur(checkPassword);
    $("#password_again").blur(second_Pwd);




})

