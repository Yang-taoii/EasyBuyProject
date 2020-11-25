



//广告轮播特效
$(function () {
    changeImg();
})
function changeImg(){
    let index = 0;
    let flag = false;
    const $li = $("#content").find("#scroll_img").children("li");//图片
    const $page = $("#content").find("#scroll_number").children("li");//数字
    $page.eq(index).addClass("scroll_number_over").siblings().removeClass("scroll_number_over");

    $page.mouseover(function(){
        flag = true;
        index = $page.index($(this));
        $li.eq(index).fadeIn().siblings().fadeOut();
        $(this).addClass("scroll_number_over").siblings().removeClass("scroll_number_over");
    }).mouseout(function(){
        flag = false;
    });
    //自动播放
    setInterval(function(){
        if(flag) return;
        index++;
        if(index >= $li.length){
            index = 0;
        }
        $li.eq(index).stop(true,true).fadeIn(0).siblings().fadeOut(0);
        $page.eq(index).addClass("scroll_number_over").stop(true,true).siblings().removeClass("scroll_number_over");
    },2000);
}



