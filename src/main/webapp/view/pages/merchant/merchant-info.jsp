<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cash Machine</title>
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

<body>

<jsp:include page="../../util/navbars/merchant-navbar.jsp"/>

<div class="register-photo" style="background-color:rgba(255,255,255,0.21);">
    <div class="form-container">
        <div class="product-image-holder"></div>
        <form method="post" style="background-color:rgba(255,255,255,0.76);">
            <h2 class="text-center"><strong>ADD NEW PRODUCT</strong></h2>
            <div class="form-group"><input class="form-control" type="text" name="login" placeholder="Product name"></div>
            <div class="form-group"><input class="form-control" type="text" name="login" placeholder="Quantity"></div>
            <div class="form-group"><input class="form-control" type="text" name="login" placeholder="Price"></div>
            <div class="form-group"><select class="form-control" style="margin-left:10px;"><option value="countable" selected="">Countable</option><option value="uncountable">Uncountable</option></select></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
            <div class="form-group"><button class="btn btn-primary btn-block btn-login" type="submit" style="background-color:#fcd85a;font-weight:normal;font-style:normal;font-size:16px;">ADD PRODUCT</button></div>
        </form>
    </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
