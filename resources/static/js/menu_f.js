const dropdown_menu_btn = $("#dropdown_menu_btn");
const dropdown_logout_btn = $("#dropdown_logout_btn");

dropdown_menu_btn.click(function(){
    let menu = $("#drop_menu");
    if(menu.is(":visible")){
        menu.animate({height: "0px"}, 100, function(){
            menu.hide();
        });
        
    }else{
        menu.css("display", "flex");
        menu.animate({height: "130px"}, 200);
    }
});

dropdown_logout_btn.click(function(){
    item = $("#logout_item");
    if(item.is(":visible")){
        item.hide();
    }else{
        item.css("display", "flex");
    }
});
