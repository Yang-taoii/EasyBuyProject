

//登录验证验证码
$(function () {
    const $VCode =$("#regCheckCodes"); //div 提示
    const $veryCode_i = $("#veryCode_i"); //input输入框
    const $veryCode_s = $("#veryCode_s");//span
    $VCode.blur(function () {
        const $VCode_val = $VCode.val();
        const $veryCode_i_val = $veryCode_i.val();
        alert($VCode_val+"--"+$veryCode_i_val);

        if ($VCode_val===$veryCode_i_val){
            $veryCode_s.removeClass("error");
            $veryCode_s.addClass("ok111");
            $veryCode_s.html("验证码正确！");
        }else {
            $veryCode_s.removeClass("ok111");
            $veryCode_s.addClass("error");
            $veryCode_s.html("验证码正确！");
        }

    })

})
