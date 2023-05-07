$(function() {
    // 모바일 GNB 슬라이드
    $('.btn-menu-open').on('click', function() {
        $('nav').addClass('on');
    });
    $('.btn-menu-close').on('click', function() {
        $('nav').removeClass('on');
    });

    
    // 주변 약국찾기
    /*$('.location button').each(function(idx) {
        $(this).on('click', function(e) {
            e.preventDefault();
            console.log(idx);
            $(this).addClass('on');
            $(this).siblings().removeClass('on');
            $(this).parent().siblings().removeClass('on');
            $(this).parent().siblings().eq(idx).addClass('on');
        });
    });

    // 거리로 찾기
    $('.distance button').each(function(idx) {
        $(this).on('click', function(e) {
            e.preventDefault();
            $(this).addClass('on');
            $(this).siblings().removeClass('on');
        });
    });

    // 주소로 찾기
    $('.juso button').each(function(idx) {
        $(this).on('click', function(e) {
            e.preventDefault();
            $(this).addClass('on');
            $(this).siblings().removeClass('on');
        });
    });*/
});

//팝업 열기

function openPopup(modalname) {
    document.get
    $("." + modalname).fadeIn(300);
    $('body').css("pointer-events","none");
}

function closePopup(modalname) {
    document.get
    $("." + modalname).fadeOut(300);
    $('body').css("pointer-events","auto");
}

function openPopupDim(modalname) {
    document.get
    $("." + modalname).fadeIn(300);
    $('body').css("pointer-events","none");
    $('.dim').addClass('on');
}

function closePopupDim(modalname) {
    document.get
    $("." + modalname).fadeOut(300);
    $('body').css("pointer-events","auto");
    $('.dim').removeClass('on');
}

function popupWindow() {
    window.open("terms.html","popup", "width=400, height=500, left=0, top=0, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no");
}