<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <#include "/resources/css_style.ftl"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Add contact</title>
</head>
<body>

    <#include "/menu.ftl"/>
    <div class="mb-3 add-form">
        <div class="title">
           <h3>New contact</h3> 
        </div>
        <form  action="/add_contact" method="post" enctype="multipart/form-data">
        <label for="exampleFormControlInput1" class="form-label">First name</label>
        <input type="text" class="form-control input_field" id="exampleFormControlInput1" name="first_name">
        <label for="exampleFormControlInput1" class="form-label">Last name</label>
        <input type="text" class="form-control input_field" id="exampleFormControlInput1" name="last_name">
        <label for="exampleFormControlInput1" class="form-label">Phone</label>
        <input type="text" class="form-control input_field" id="exampleFormControlInput1" name="phone">
        <div class="preview_uploaded_photo_box">
            <i id="remove_upload_photo_btn" class="fa-solid fa-trash-can-arrow-up"></i>
            <img id="upload_photo_link" src="#" alt="image.png">
        </div>
        <div>
            <i class="fa-solid fa-cloud-arrow-up"></i>            
            <label id="upload_file_lbl" for="upload_file">
                <input type="file" name="upload_photo" id="upload_file"> Upload photo
            </label><br>
        </div>
        <input type="submit" value="Save" class="btn btn-success input_btn">
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/js/menu_f.js"></script>
    <script src="/js/add_contact_f.js"></script>
</body>
</html>