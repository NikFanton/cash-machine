<%@ include file="../../util/init.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cash Machine</title>
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

<jsp:include page="../../util/navbars/admin-navbar.jsp"/>

<div class="register-photo" style="background-color:rgba(255,255,255,0.21);">
    <div class="form-container">
        <div class="image-holder"></div>
        <form method="post" action="${pageContext.request.contextPath}/api/register-employee" style="background-color:rgba(255,255,255,0.76);">
            <h2 class="text-center" style="text-transform: uppercase;"><strong><fmt:message key="create.new.account"/> </strong></h2>
            <div class="form-group"><input class="form-control" type="text" name="newFirstName" placeholder="<fmt:message key="first.name"/>"required></div>
            <div class="form-group"><input class="form-control" type="text" name="newLastName" placeholder="<fmt:message key="last.name"/>" required></div>
            <div class="form-group">
                <select class="form-control" style="margin-left:10px;" name="newRole" required>
                    <option value="CASHIER" selected=""><fmt:message key="cashier"/></option>
                    <option value="SENIOR_CASHIER"><fmt:message key="senior.cashier"/></option>
                    <option value="MERCHANT"><fmt:message key="merchant"/></option>
                </select>
            </div>
            <div class="form-group"><input class="form-control" type="text" name="newLogin" placeholder="<fmt:message key="login"/>" required></div>
            <div class="form-group"><input class="form-control" type="password" name="newPassword" placeholder="<fmt:message key="password"/>" required></div>
            <div class="form-group"><button class="btn btn-primary btn-block btn-login" type="submit" style="background-color:#fcd85a;font-weight:normal;font-style:normal;font-size:16px; text-transform: uppercase;"><fmt:message key="register"/></button></div>
        </form>
    </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>