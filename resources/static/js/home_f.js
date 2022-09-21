let contact_box = $(".contact-box");
let delete_dialog = $(".delete_dialog");

let btn_close_photo_edit_box = $("#btn_close_edited_photo");
btn_close_photo_edit_box.click(close_edit_photo_box);

let upload_photo_file = $("#edit_photo_label");
upload_photo_file.change(show_uploaded_photo);

$("#btn_close_add_box").click(close_add_photo_box);

$("#close_delete").click(function(){
    $(".delete_dialog").animate({opacity: 0}, 400, function(){
        $(".delete_dialog").hide();
        $(".delete_dialog").css("opacity", "1");
    });
});


$(".contact-box").mouseup(click_outside_box);

images = $(".photo");

images.click(function(){
    let contact_id = this.getAttribute("data-contactid");
    let contact_photo = this.getAttribute("data-contactphoto");
    show_edit_photo_box(contact_photo, contact_id)
});

let delete_contact_btn = $(".delete_btn");

delete_contact_btn.click(function(){
    let contact_name = this.getAttribute("data-contactName");
    let contact_phone = this.getAttribute("data-contactPhone");
    let contact_id = this.getAttribute("data-contactId");
    show_delete_dialog(contact_name, contact_phone, contact_id);
});

$(window).scroll(function(){
    y = $(window).scrollTop();
    move = $("#move_top");
    if(y > 0){
        move.show();
    }else{
        move.hide();
    }
});

function show_add_photo_box(contact_id){
    let photo_box = $(".add_photo_box");
    photo_box.show();
    show_added_photo(contact_id);
}

function show_added_photo(contact_id){ 
    let file_reader = new FileReader();
    let photo = $("#added_photo_link");
    let upload_file = $("#add_photo_label");
    let save_btn = $("#btn_save_added_photo");
    let default_photo = $("#default_photo");
    upload_file.change(function(){
        file_reader.onload = () => {
            photo.attr("src", file_reader.result);
        }
        file_reader.readAsDataURL(event.target.files[0]);
        default_photo.hide();
        photo.show(); 
        save_btn.show();
        save_btn.click(function(){
            save_new_photo(contact_id);
        });
    })
}

function save_new_photo(contact_id){
    let form = $("#form_add_photo");
    form.attr("action", "/add_photo/" + contact_id);
    form.submit();
}

function show_edit_photo_box(photo_name, contact_id){
    let photo = $("#uploaded_photo_link");
    let delete_link = $("#delete_photo_link");
    let save_btn = $("#btn_save_edited_photo");
    photo.attr("src", "/contacts_images/" + photo_name);
    delete_link.attr("href", "/delete_photo/" + contact_id);
    let photo_box = $(".edit_photo_box");
    photo_box.show();
    save_btn.click(function(){
        save_edit_photo(contact_id);
    })
}

function show_uploaded_photo(){
    photo = $("#uploaded_photo_link");
    btn_save = $("#btn_save_edited_photo");
    let file_reader = new FileReader();
    file_reader.onload = () => {
        photo.attr("src", file_reader.result);
    }
    file_reader.readAsDataURL(event.target.files[0]);
    btn_save.show();
}

function save_edit_photo(contact_id){
    form = $("#form_edit_photo");
    form.attr("action", "/uploaded_photo/" + contact_id);
    form.submit();
}

function close_add_photo_box(){
    let box = $(".add_photo_box");
    box.animate({opacity : "0"}, 500, function(){
        box.hide();
        box.css("opacity", "1");
    });
}

function close_edit_photo_box(){
    let box = $(".edit_photo_box");
    box.animate({opacity : "0"}, 500, function(){
        box.hide();
        box.css("opacity", "1");
    });
}

function close_info_message(){
    $(".alert-success").hide();
}

function close_error_message(){
    $(".alert-danger").hide();
}

function show_delete_dialog(contact_name, contact_phone, contact_id){
    $("#span_contactname").text(contact_name);
    $("#span_phone").text(contact_phone);
    $("#submit_delete").attr("href", "delete/" + contact_id);
    let dialog = $(".delete_dialog");
    dialog.css("opacity", "0");
    dialog.show();
    dialog.animate({opacity : "1"}, 200);
}

function close_delete_dialog(){ $(".delete_dialog").hide(); }

function click_outside_box(){
    box = $(".add_photo_box");
    if((!box.target) && (box.is(":visible"))){
        box.hide();
    }
    box = $(".edit_photo_box");
    if(!box.target && box.is(":visible")){
        box.hide();
    }
    box = $(".delete_dialog");
    if(!box.target && box.is(":visible")){
        box.hide();
    }
    box = $("#drop_menu");
    if(!box.target && box.is(":visible")){
        box.css("height", "0");
        box.hide();
    }
    box = $("#logout_item");
    if(!box.target && box.is(":visible")){
        box.hide();
    }
}