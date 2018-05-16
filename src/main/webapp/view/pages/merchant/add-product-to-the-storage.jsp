<%@ include file="../../util/init.jsp"%>
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
        <form method="post" action="${pageContext.request.contextPath}/api/add-product-to-storage" style="background-color:rgba(255,255,255,0.76);">
            <h2 class="text-center" style="text-transform: uppercase;"><strong><fmt:message key="title.add.new.product"/></strong></h2>
            <div class="form-group"><input class="form-control" type="text" name="productName" style="text-transform: capitalize;" placeholder="<fmt:message key="product.name"/>" required></div>
            <div class="form-group"><input class="form-control" type="text" name="productQuantity" style="text-transform:capitalize;" placeholder="<fmt:message key="quantity"/>" required></div>
            <div class="form-group"><input class="form-control" type="text" name="productPrice" style="text-transform:capitalize;" placeholder="<fmt:message key="price"/>" required></div>
            <div class="form-group"><select class="form-control" name="productType" style="margin-left:10px;" required>
                <option value="COUNTABLE" selected><fmt:message key="countable"/></option>
                <option value="UNCOUNTABLE"><fmt:message key="uncountable"/></option></select></div>
            <div class="form-group"><button class="btn btn-primary btn-block btn-login" type="submit" style="text-transform:uppercase; background-color:#fcd85a;font-weight:normal;font-style:normal;font-size:16px;"><fmt:message key="add.product"/></button></div>
        </form>
    </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
