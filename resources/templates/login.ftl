<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "/resources/css_style.ftl"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Login</title>
</head>
<body>

    <#if Login?has_content>
        <#if Login == "false">
           <div class="box_message alert alert-danger">
                <div>
                    Entered username or password are invalid!
                </div>
                <div id="close-message-btn">
                    <button type="button" id="close_message_btn" class="btn-close" aria-label="Close" onclick="close_message_box()"></button>
                </div>
            </div>
        </#if>
    </#if>       
        
    <div class="main_title">
        Welcome to contacts web application!
    </div>
    <div class="login_form">
        <div class="title">
            <h3>Login</h3>
        </div>
        <div class="login_data">
            <form action="/login" method="post">
                <label for="exampleFormControlInput1" class="form-label">Username</label>
                <input  autocomplete="off" type="text" class="form-control input_field" id="exampleFormControlInput1" name="username" maxlength="50" required>
                <label for="exampleFormControlInput1" class="form-label">Password</label>
                <input type="password" class="form-control input_field" id="exampleFormControlInput1" name="password" maxlength="64" required><br>
                <input type="submit" value="Login" class="btn btn-primary input_btn"><br><br>
                <a href="/register">Go to register</a>
            </form>
        </div>
    </div>
    <script>
        const message_box = $(".alert-danger");
        function close_message_box(){ message_box.hide(); }
    </script>
</body>
</html>