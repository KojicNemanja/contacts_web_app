<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "/resources/css_style.ftl"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Contacts</title>
</head>
<body>
    <span id="top_page"></span>

    <#include "/menu.ftl"/> 
    
    <#if SaveContact?has_content>
        <#if SaveContact == "true">
            <div class="box_message alert alert-success">
                <div>
                    Contact has been saved!
                </div>
                <div id="close-message-btn">
                    <button type="button" id="close_message_btn" class="btn-close" aria-label="Close" onclick="close_info_message()"></button>
                </div>
            </div>
        <#else>
            <div class="box_message alert alert-danger">
                <div>
                    There was an error saving contact!
                </div>
                <div id="close-message-btn">
                    <button type="button" id="close_message_btn" class="btn-close" aria-label="Close" onclick="close_error_message()"></button>
                </div>
            </div>
        </#if>
    </#if>

    <#if EditContact?has_content>
        <#if EditContact == "true">
            <div class="box_message alert alert-success">
                <div>
                    Contact has been updated!   
                </div>
                <div id="close-message-btn">
                    <button type="button" id="close_message_btn" class="btn-close" aria-label="Close" onclick="close_info_message()"></button>
                </div>
            </div>
        <#else>
            <div class="box_message alert alert-danger">
                <div>
                    There was an error updating contact!
                </div>
                <div id="close-message-btn">
                    <button type="button" id="close_message_btn" class="btn-close" aria-label="Close" onclick="close_error_message()"></button>
                </div>
            </div>
        </#if>
    </#if>

    <#if DeleteContact?has_content>
        <#if DeleteContact == "true">
            <div class="box_message alert alert-success">
                <div>
                    Contact has been deleted!   
                </div>
                <div id="close-message-btn">
                    <button type="button" id="close_message_btn" class="btn-close" aria-label="Close" onclick="close_info_message()"></button>
                </div>
            </div>
        <#else>
            <div class="box_message alert alert-danger">
                <div>
                    There was an error deleting contact!
                </div>
                <div id="close-message-btn">
                    <button type="button" id="close_message_btn" class="btn-close" aria-label="Close" onclick="close_error_message()"></button>
                </div>
            </div>
        </#if>
    </#if>

    <div class="contact-box">
        <div class="title">
            <h3>All Contacts</h3>
        </div>
        <div>
            <form id="search_form" action="/" method="get">
                <input autocomplete="off" class="form-control me-2" type="search" placeholder="Full name, phone" aria-label="Search" name="phrase">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <form id="small_form" action="/" method="get">
                <input  autocomplete="off" class="form-control" type="text" name="phrase" placeholder="Full name, phone" aria-label=".form-control-sm example">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
        <#list contacts as contact>
        <div class="contact_data">
            <div class="image">
                <#if contact.photo != "">
                    <img class="photo" src="/contacts_images/${contact.photo}" data-contactid="${contact.contact_id}" 
                    data-contactphoto="${contact.photo}" alt="image.png">
                <#else>
                    <i class="fa-solid fa-user"></i>
                    <label id="add_image_lbl" onclick="show_add_photo_box(${contact.contact_id})"></label>
                </#if>
            </div>
            <div class="data">
                <div class="personal_data">
                    ${contact.first_name} ${contact.last_name}
            </div>
            <div class="phone">
                ${contact.phone}
            </div>
            <div class="buttons_container">
                <a id="edit-btn" href="/edit/${contact.contact_id}">Edit</a>
                <button id="delete-btn" class="delete_btn"
                data-contactName="${contact.first_name} ${contact.last_name}"
                data-contactPhone="${contact.phone}"
                data-contactId="${contact.contact_id}">Delete</button>
                <!-- onclick="show_delete_dialog('${contact.first_name} ${contact.last_name}', ${contact.contact_id})" -->
            </div>
            </div>
            </div>
            </#list>
            <a id="move_top" href="#top"><i class="fa-solid fa-angle-up"></i></a>
        </div>
         
        <!--      Delete dialog      -->
        <div class="delete_dialog">
            <div id="dialog_title">
                Do you wish to delete:
            </div>
            <div id="dialog_contact">
                <div id="dialog_contact_name">
                    <span id="span_contactname"></span>
                </div>
                <div id="dialog_contact_phone">
                    <span id="span_phone"></span>
                </div>
            </div>
            
            <div id="dialog_buttons">
                <a id="submit_delete" href="#"><i  class="fa-solid fa-square-check"></i></a>
                <button id="close_delete"><i class="fa-solid fa-square-xmark"></i></button>
            </div>
        </div>
    
    <!-- Add new photo -->
    <div class="add_photo_box">
        <img id="added_photo_link" src="#" alt="noimage.png">
        <i id="btn_close_add_box" class="fa-solid fa-xmark"></i>
        <i id="btn_save_added_photo" class="fa-solid fa-check"></i>
        <div id="default_photo">
            <i class="fa-solid fa-user"></i>
        </div>
        <div id="btn_add_photo">
            <i class="fa-solid fa-plus"></i>
            <form id="form_add_photo" action="#" method="post" enctype="multipart/form-data" accept="image/*">
            <label id="add_photo_label" for="file-new_photo">
                <input id="file-new_photo" type="file" name="added_photo">
                Add photo
            </label>
        </form>
        </div>
    </div>

    
    <!-- Edit photo -->
    <div class="edit_photo_box">
        <img id="uploaded_photo_link" src="#" alt="noimage">
        <i id="btn_close_edited_photo" class="fa-solid fa-xmark"></i>
        <i id="btn_save_edited_photo" class="fa-solid fa-check save_uploaded_photo"></i>
        <div id="btn_upload_photo">
            <i class="fa-solid fa-cloud-arrow-up"></i>
            <form id="form_edit_photo" action="#" method="post" enctype="multipart/form-data" accept="image/*">
                <label id="edit_photo_label" for="file-upload">
                    <input id="file-upload" type="file" name="new_photo"> Upload new photo
                </label>
            </form>
        </div>
        <div id="btn_delete_photo">
            <i id="delete_photo_icon" class="fa-solid fa-trash-can-arrow-up"></i>
            <a id="delete_photo_link"  href="#">Delete photo</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/js/menu_f.js"></script>
    <script type="text/javascript" src="/js/home_f.js"></script>

</body>
</html>