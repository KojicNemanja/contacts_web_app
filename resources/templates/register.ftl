<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "/resources/css_style.ftl"/>
    <title>Register</title>
</head>
<body>

    <div class="main_title">
        Welcome to register!
    </div>
    <div class="login_form">
        <div class="title">
            <h3>Register</h3>
        </div>
        <div class="login_data">
            <form action="/register" method="post">
                <label for="exampleFormControlInput1" class="form-label">First name</label>
                <input autocomplete="off" type="text" class="form-control input_field" id="exampleFormControlInput1" name="first_name" required>
                <label for="exampleFormControlInput1" class="form-label">Last name</label>
                <input autocomplete="off" type="text" class="form-control input_field" id="exampleFormControlInput1" name="last_name" required>
                <label for="exampleFormControlInput1" class="form-label">Username</label>
                <input autocomplete="off" type="text" class="form-control input_field" id="exampleFormControlInput1" name="username" required>
                <label for="exampleFormControlInput1" class="form-label">Password</label>
                <input autocomplete="off" type="password" class="form-control input_field" id="exampleFormControlInput1" name="password" required><br>
                <input type="submit" value="Register" class="btn btn-primary input_btn"><br><br>
                <a href="/login">Go to login</a>
            </form>
        </div>
    </div>
</body>
</html>