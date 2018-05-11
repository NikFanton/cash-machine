<%@ include file="../../util/init.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>cash-machine</title>
    <link rel="stylesheet" href="/view/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/view/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/view/assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arvo">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,500&amp;subset=cyrillic,cyrillic-ext">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,500&amp;subset=cyrillic,cyrillic-ext">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700&amp;subset=cyrillic,cyrillic-ext">
    <link rel="stylesheet" href="/view/assets/css/Article-Dual-Column.css">
    <link rel="stylesheet" href="/view/assets/css/Features-Boxed.css">
    <link rel="stylesheet" href="/view/assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="/view/assets/css/styles.css">
</head>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>cash-machine</title>
    <link rel="stylesheet" href="/view/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/view/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arvo">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,500&amp;subset=cyrillic,cyrillic-ext">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,500&amp;subset=cyrillic,cyrillic-ext">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700&amp;subset=cyrillic,cyrillic-ext">
    <link rel="stylesheet" href="/view/assets/css/Article-Clean.css">
    <link rel="stylesheet" href="/view/assets/css/Article-Dual-Column.css">
    <link rel="stylesheet" href="/view/assets/css/Features-Boxed.css">
    <link rel="stylesheet" href="/view/assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="/view/assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="/view/assets/css/styles.css">
</head>

<body style="background-color:rgba(252,216,90,0.31);">

<jsp:include page="../../util/admin-navbar.jsp"/>

<div class="register-photo" style="background-color:rgba(255,255,255,0.21);">
    <div class="form-container">
        <div class="image-holder"></div>
        <form method="post" style="background-color:rgba(255,255,255,0.76);">
            <h2 class="text-center"><strong>CREATE NEW ACCOUNT</strong></h2>
            <div class="form-group"><input class="form-control" type="text" name="firstName" placeholder="First name"></div>
            <div class="form-group"><input class="form-control" type="text" name="lastName" placeholder="Last name"></div>
            <div class="form-group">
                <select class="form-control" style="margin-left:10px;">
                    <option value="countable" selected="">Cashier</option>
                    <option value="uncountable">Senior cashier</option>
                    <option value="uncountable">Merchant</option>
                </select>
            </div>
            <div class="form-group"><input class="form-control" type="text" name="login" placeholder="Login"></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
            <div class="form-group"><button class="btn btn-primary btn-block btn-login" type="submit" style="background-color:#fcd85a;font-weight:normal;font-style:normal;font-size:16px;">SIGN UP</button></div>
        </form>
    </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>