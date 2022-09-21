<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <#include "/resources/css_style.ftl"/>
    <title>Edit contact</title>
</head>
<body>
    <#include "/menu.ftl"/>
    <div class="mb-3 add-form">
        <div class="title">
           <h3>Edit contact</h3> 
        </div>
        <form action="/edit/${contact.contact_id}" method="post" enctype="multipart/form-data" name="edit_form">
        <label for="exampleFormControlInput1" class="form-label">First name</label>
        <input type="text" class="form-control input_field" id="exampleFormControlInput1" name="first_name" value="${contact.first_name}">
        <label for="exampleFormControlInput1" class="form-label">Last name</label>
        <input type="text" class="form-control input_field" id="exampleFormControlInput1" name="last_name" value="${contact.last_name}">
        <label for="exampleFormControlInput1" class="form-label">Phone</label>
        <input type="text" class="form-control input_field" id="exampleFormControlInput1" name="phone" value="${contact.phone}">
        <input type="submit" value="Save" class="btn btn-success input_btn">
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/js/menu_f.js"></script>
    <script type="text/javascript" src="/js/main_functions.js"></script>
</body>
</html>