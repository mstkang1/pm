$(function() {

    // 모바일 GNB 슬라이드
    $('.btn-menu-open').on('click', function() {
        $('nav').addClass('on');
        $('.dim').addClass('on');
    });
    $('.btn-menu-close').on('click', function() {
        $('nav').removeClass('on');
        $('.dim').removeClass('on');
    });


    var controller = new ScrollMagic.Controller({
        globalSceneOptions: {
            duration: 900
        }
    });

    // 브랜드스토리
    new ScrollMagic.Scene({triggerElement: "#menu1",triggerHook: "onCenter", duration: 650, offset:200})
        .setClassToggle(".big-people", "on")
        // .addIndicators({indent:700})
        .addTo(controller);

    // 제품 컨트롤러
    new ScrollMagic.Scene({triggerElement: ".product1-wrap",triggerHook: "onCenter", duration: 840})
    .setClassToggle(".product1-wrap .tooltip", "on")
    // .addIndicators({indent:700})
    .addTo(controller);
        
    new ScrollMagic.Scene({triggerElement: ".product2-wrap",triggerHook: "onCenter", duration: 840})
    .setClassToggle(".product2-wrap .tooltip", "on")
    // .addIndicators({indent:700})
    .addTo(controller);

    new ScrollMagic.Scene({triggerElement: ".product3-wrap",triggerHook: "onCenter", duration: 840})
    .setClassToggle(".product3-wrap .tooltip", "on")
    // .addIndicators({indent:700})
    .addTo(controller);

    new ScrollMagic.Scene({triggerElement: ".product4-wrap",triggerHook: "onCenter", duration: 840})
    .setClassToggle(".product4-wrap .tooltip", "on")
    // .addIndicators({indent:700})
    .addTo(controller);

    new ScrollMagic.Scene({triggerElement: ".product5-wrap",triggerHook: "onCenter", duration: 840})
    .setClassToggle(".product5-wrap .tooltip", "on")
    // .addIndicators({indent:700})
    .addTo(controller);


    // 2023.04.28 GNB 이동 플러그인 주석처리
    // // GNB 이동
    // controller.scrollTo(function (newpos) {
    //     TweenMax.to(window, 1,{scrollTo: {y: newpos}});
    // });

    // var menu = document.querySelector("nav>ul");
    // // console.log(menu);  
    // menu.addEventListener("click", function (e) {
    //     var id = e.target.hash;
    //     e.preventDefault();
    //     controller.scrollTo(id);
    //     if (window.history && window.history.pushState) {
    //         history.pushState("", document.title, id);
    //     }
    // });

    // 메인배너 슬라이더
    var mainSwiper = new Swiper(".main-banner", {
        spaceBetween: 0,
        centeredSlides: true,
        speed: 1000,
        keyboard: {
            enabled: true,
        },
        loop: true,
        autoplay: {
            delay: 3500,
            disableOnInteraction: false,
        },
        pagination: {
            el: ".swiper-pagination",
            clickable: true,
        },
        navigation: {
            nextEl: ".product-button-next",
            prevEl: ".product-button-prev",
        },
    });

    // 피엠 제품 슬라이더
    var productSwiper = new Swiper(".product-slide", {
        spaceBetween: 0,
        slidesPerView: 3,
        centeredSlides: true,
        speed: 1000,
        keyboard: {
            enabled: true,
        },
        loop: true,
        autoplay: {
            delay: 2500,
            disableOnInteraction: false,
        },
        // autoplay: false,
        pagination: {
            el: ".product-pagination",
            clickable: true,
        },
        navigation: {
            nextEl: ".product-button-next",
            prevEl: ".product-button-prev",
        },
        breakpoints: {
            320: {
                slidesPerView: 1,
                spaceBetween: 0,
              },
            640: {
              slidesPerView: 3,
              spaceBetween: 0,
            },
            768: {
              slidesPerView: 3,
              spaceBetween: 0,
            },
            1024: {
              slidesPerView: 3,
              spaceBetween: 0,
            },
        },
    });
        
    // 피엠 제품 슬라이드 클릭시 제품 소개 부분으로 부드럽게 스크롤 이동
    productSwiper.on('click', function() {
        
        // 슬라이드의 갯수를 구하고 각각의 슬라이드를 클릭했을 때 각각의 href값을 id값에 변수로 담고
        // 해당 id를 찾아 스크롤 이동
        $('.product-slide .swiper-slide p a').each(function(idx) {
            // console.log(idx);
            $(this).on('click', function(e) {
                e.preventDefault();
                id = $(this).attr('href');
                
                // 2023.04.28 스크롤 이동 소스변경
                var offset = $(id).offset();
                $('html, body').animate({scrollTop : offset.top}, 700);
                // controller.scrollTo(id);
                // if (window.history && window.history.pushState) {
                //     history.pushState("", document.title, id);
                // }
            });
        });
    });

    // 무좀 치료, 원하는 스타일대로! 영상
    $('.playlist ul>li a').on('click', function(e) {
        e.preventDefault();
        $(this).parent().siblings().removeClass('on');
        $(this).parent().addClass('on');
        var youtubeLink = $($(this)).data('thumb');
        var playUrl = 'https://www.youtube.com/embed/' + youtubeLink;
        $('#player').attr('src', playUrl);
    });

    $('.playlist ul>li>span').on('click', function(e) {
        e.preventDefault();
        $(this).parent().siblings().removeClass('on');
        $(this).parent().addClass('on');
        var youtubeLink = $($(this).siblings('a')).data('thumb');
        var playUrl = 'https://www.youtube.com/embed/' + youtubeLink;
        $('#player').attr('src', playUrl);
    });

    // product1 탭
    $('.product1-wrap .product1 .tab>a').on('click', function(e) {
        $(this).parent().toggleClass('on');
        e.preventDefault();
    });
    // product2 탭
    $('.product2-wrap .product2 .tab>a').on('click', function(e) {
        $(this).parent().toggleClass('on');
        e.preventDefault();
    });
    // product3 탭
    $('.product3-wrap .product3 .tab>a').on('click', function(e) {
        $(this).parent().toggleClass('on');
        e.preventDefault();
    });
    // product4 탭
    $('.product4-wrap .product4 .tab>a').on('click', function(e) {
        $(this).parent().toggleClass('on');
        e.preventDefault();
    });
    // product5 탭
    $('.product5-wrap .product5 .tab>a').on('click', function(e) {
        $(this).parent().toggleClass('on');
        e.preventDefault();
    });
    
    // qna 펼침목록
    $('.qna>ul>li').click(function(){
        $(this).siblings().removeClass('on');
        $(this).addClass('on');
        $('.qna>ul>li>ul').slideUp();
        if ($(this).children('.qna>ul>li>ul').is(':hidden')){
            $(this).children('.qna>ul>li>ul').slideDown();
        } else{
            $(this).children('.qna>ul>li>ul').slideUp();
            $(this).removeClass('on');
        }
    });
});

// 무좀 치료, 원하는 스타일대로! 피엠
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";

var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;
function onYouTubeIframeAPIReady() {
    player = new YT.Player('player', {
    height: '360',
    width: '640',
    videoId: 'W4E3bElSZeg',  // 2023.04.28 동영상 주소변경
    playVars: { 'autoplay': 0, 'playsinline': 1, 'loop' :1, 'rel' :0, 'mute' :1, 'modestbranding' :1, 'autohide':1,'showinfo':0,'controls':0, },
    events: {
        'onReady': onPlayerReady,
    }
    });
}
var done = false;
function onPlayerReady(event) {
    setTimeout(function() {
        player.pauseVideo();
    }, 500);
    //   event.target.playVideo();
}
function stopVideo() {
    player.stopVideo();
}

//팝업 열기
function openPopup(modalname) {
    document.get
    $("." + modalname).fadeIn(300);
    $('body').css("pointer-events","none");
    $('.dim').fadeIn(500).show().addClass('on');
}

function closePopup(modalname) {
    document.get
    $("." + modalname).fadeOut(300);
    $('body').css("pointer-events","auto");
    $('.dim').fadeIn(500).hide().removeClass('on');
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

function loadingOpen(modalname) {
    document.get
    $("." + modalname).fadeIn(300);
    $('body').css("pointer-events","none");
    $('.lodaing').addClass('on');
}

function lodaingClose(modalname) {
    document.get
    $("." + modalname).fadeOut(300);
    $('body').css("pointer-events","auto");
    $('.lodaing').removeClass('on');
}

function popupWindow() {
    window.open("terms.html","popup", "width=320, height=500, left=0, top=0, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no");
}

// 2023.04.28 함수추가
function pageMove(seq){
    var offset = $("#menu" + seq).offset();
    $('html, body').animate({scrollTop : offset.top}, 700);
}
