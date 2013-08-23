
$(function(){
	

	$(".header_list").find("a").hover(function(){
		$(".header_list a").removeClass("list_current");
		$(this).addClass("list_current");
		return false;
	});

	$(".content-box-tabs").find("a").click(function(){
		$("[data-tab]").removeClass("curr-tab");
		$(this).addClass("curr-tab");
		$(".tab-content").hide();
		$($(this).attr("data-tab")).show();
		return false;
	});

	$(".tabUl").find("li").hover(function(){
					$(".tabCon").hide();
					$("#" + $(this).attr("data-target")).show();
					$(".tabUl").find("li").removeClass("tabOn");
					$(this).addClass("tabOn");
				},function(){
				
				});
		   $("#slide").KinSlideshow({
                intervalTime:3,   		//设置间隔时间为8秒  [默认为5秒]
                mouseEvent:"mouseover",		//设置鼠标事件为“鼠标滑过切换”  [默认鼠标点击时切换]
                titleFont:{TitleFont_size:14,TitleFont_color:"#fff"} //设置标题文字大小为14px，颜色：#ff0000
        });
	
	});
	
		$(".menu_li").hide();

			$(".menu_ul li, .menu_li").hover(function(){
				$(this).find(".menu_li").show();
			},function(){
				$(".menu_li").hide();
			});

	
		$(function(){
		 $(".menu_ul").children("li:has(ul)").hover(
			function(){
				$(this).find(".menu_li").show();
			},
			function(){
				$(this).find(".menu_li").hide();
			});


			});
    $(function(){
        $(".img_enter").find("a").each(function() {
            $(this).hover(function() { 
                $(this).siblings().find("img").stop().fadeTo("slow",0.4);
            },
            function() {
                $(this).siblings().find("img").stop().fadeTo("slow",1);
            });
        });
    })
