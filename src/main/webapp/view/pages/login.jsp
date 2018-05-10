<%@ include file="../util/init.jsp"%>
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

<body style="background-color:rgba(252,216,90,0.31);">
<div class="login-clean" style="background-color:rgba(252,216,90,0);">
    <form method="post" action="${pageContext.request.contextPath}/api/login">
        <div class="illustration"><i class="fa fa-user-circle" style="color:#fcd85a;"></i>
            <h1 class="text-center" style="font-family:Montserrat, sans-serif;font-size:33px;color:#505e6c;">Cash Machine</h1>
        </div>
        <div class="form-group"><input class="form-control" type="text" name="login" placeholder="Login" required></div>
        <div class="form-group"><input class="form-control" type="password" name="pass" placeholder="Password" required></div>
        <div class="form-group"><button class="btn btn-primary btn-block btn-login" type="submit" style="background-color:#fcd85a;font-weight:normal;font-style:normal;font-size:16px;">LOG IN</button></div>
    </form>
</div>
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>