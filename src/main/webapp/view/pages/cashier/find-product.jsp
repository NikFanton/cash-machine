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

<body style="background-color:rgba(252,216,90,0.31);">

<jsp:include page="../../util/navbars/cashier-navbar.jsp"/>

<div class="container" id="content" style="background-color:#fffcf3;">
    <div class="row d-flex input-panel">
        <form method="post" action="/api/find-product">
            <div class="col-md-4 d-inline" style="min-width:276px;">
                <label class="col-form-label" style="text-transform: capitalize; font-family:Roboto, sans-serif;"><fmt:message key="search"/> </label>
                <input class="align-items-baseline search-field" name="name" type="text" placeholder=" <fmt:message key="name"/>" style="font-family:Roboto, sans-serif;">
                <button class="btn btn-primary btn-sm float-right add-prod-btn" type="submit" style="text-transform: capitalize; background-color:#fcd85a;color:rgb(34,34,34);" onchange="submit()"><fmt:message key="find"/></button>
            </div>
            <div class="col-2" style="width:178px;min-width:0px;">

            </div>
        </form>
    </div>
        <div class="table-responsive" style="font-family:Roboto, sans-serif;">
            <table class="table table-striped table-sm">
                <thead>
                <tr>
                    <th style="font-family:Roboto, sans-serif;">#</th>
                    <th><fmt:message key="serial.number"/> </th>
                    <th><fmt:message key="name"/></th>
                    <th><fmt:message key="price"/></th>
                </tr>
                </thead>
                <tbody>
                <c:set var="total" value="${0}"/>
                <%--<jsp:useBean id="products" scope="request" type="java.util.List"/>--%>
                <c:forEach var="product" items="${products}" varStatus="loop">
                    <tr>
                        <td><c:out value="${loop.index + 1}"/></td>
                        <td><c:out value="${product.id}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.price/100.}"/></td>
                        <c:set var="total" value="${total + product.quantity * product.price/100.}"/>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>