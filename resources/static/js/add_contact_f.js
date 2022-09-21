photo_box = $(".preview_uploaded_photo_box");
upload_photo_link = $("#upload_photo_link");
upload_photo_name = $("#upload_file_lbl");
btn_remove_photo = $("#remove_upload_photo_btn");
upload_photo = $("#upload_file");

btn_remove_photo.click(remove_uploaded_photo);
upload_photo_name.change(show_uploaded_photo);

$(document).mouseup(click_outside_box);


function show_photo_box(){ photo_box.show(); }
function hidde_photo_box(){ photo_box.hide(); }
function remove_uploaded_photo(){ upload_photo.val(null); hidde_photo_box(); }
function show_uploaded_photo(){
    let file_reader = new FileReader();
    file_reader.onload = () =>{
        upload_photo_link.attr("src", file_reader.result);
    }
    file_reader.readAsDataURL(event.target.files[0]);
    show_photo_box();
}

function click_outside_box(){
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