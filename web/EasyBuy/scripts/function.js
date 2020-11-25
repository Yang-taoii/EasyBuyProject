//验证用户名
function checkName() {
    //验证格式：
    const reg_name = /^[^0-9][a-z][A-Z]{4,10}$/;
    if(!reg_name.test($("#userName").val())){
        $("#spanName").addClass("div_color");
        $("#spanName").html("&nbsp;用户名格式错误");
        return false;
    }
    //正确：
    $("#spanName").html("&nbsp;OK!");
    $("#spanName").removeClass("error");
    return true;
}

//验证密码




$(function () {
    $("#userName").blur(checkName);
    $("#passWord").blur(checkPassword);
    $("#rePassword").blur(second_Pwd);

    $("#regForm").submit(function () {
        var a1=  checkName();
        var a2 = checkPassword();
        var a3 = second_Pwd();
        return a1 && a2 && a3;
    });

})
