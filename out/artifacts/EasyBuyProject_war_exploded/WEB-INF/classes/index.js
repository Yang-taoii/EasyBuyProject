


//广告轮播特效
$(function () {
    const $li = $("#content").find("#scroll_img").children("li");//图片
    $li.eq(0).siblings().css("display","none");
    changeImg();

    // $(".demo1").bootstrapNews({
    //     newsPerPage: 5,
    //     autoplay: true,
    //     pauseOnHover:true,
    //     direction: 'up',
    //     newsTickerInterval: 4000,
    //     onToDo: function () {
    //         //console.log(this);
    //     }
    // });

    $(".demo2").bootstrapNews({
        newsPerPage: 4,
        autoplay: true,
        pauseOnHover: true,
        navigation: false,
        direction: 'up',
        newsTickerInterval: 1800,
        onToDo: function () {
            //console.log(this);
        }
    });

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
        $li.eq(index).fadeIn(200).siblings().fadeOut(0);
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
        $li.eq(index).fadeIn(200).siblings().fadeOut(0);
        $page.eq(index).addClass("scroll_number_over").siblings().removeClass("scroll_number_over");
    },2500);
}



