<%--@elvariable id="CryptoUtil" type="ua.training.model.dao.util.CryptoUtil"--%>
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

<body style="background-color:rgba(252,216,90,0.31);">

<jsp:include page="../../util/cashier-navbar.jsp"/>

<div class="container" id="content" style="background-color:#fffcf3;">
    <div class="row d-flex input-panel">
        <form method="post" action="/api/add-product">
            <div class="col-md-4 d-inline" style="min-width:276px;">
                <label class="col-form-label" style="font-family:Roboto, sans-serif;">Search</label>
                <input class="align-items-baseline search-field" name="id" type="text" placeholder=" id" style="font-family:Roboto, sans-serif;">
            </div>
            <div class="col d-inline">
                <label class="col-form-label" style="font-family:Roboto, sans-serif;">Quantity</label>
                <input class="align-items-baseline quantity-field" name="quantity" type="text" placeholder=" number / weight" inputmode="numeric" style="font-family:Roboto, sans-serif;">
            </div>
            <div class="col-2 d-inline" style="width:178px;min-width:0px;">
                <button class="btn btn-primary btn-sm float-right add-prod-btn" type="submit" style="background-color:#fcd85a;color:rgb(34,34,34);margin-top: 4px;" onchange="submit()">ADD</button>
            </div>
        </form>
    </div>
    <form method="post" action="/api/save-check">
        <div class="table-responsive" style="font-family:Roboto, sans-serif;">
            <table class="table table-striped table-sm">
                <thead>
                <tr>
                    <th style="font-family:Roboto, sans-serif;">#</th>
                    <th>serial number</th>
                    <th>name</th>
                    <th>quantity</th>
                    <th>price</th>
                    <c:if test="${role eq 'SENIOR_CASHIER'}">
                        <th></th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <c:set var="total" value="${0}"/>
                <%--<jsp:useBean id="products" scope="request" type="java.util.List"/>--%>

                <c:forEach var="product" items="${products}" varStatus="loop">
                        <tr>
                            <%--<form method="post" action="${pageContext.request.contextPath}/api/remove-from-check?productId=${product.id}">--%>
                                <div>
                                    <td><c:out value="${loop.index + 1}"/></td>
                                    <td><c:out value="${product.id}"/></td>
                                    <td><c:out value="${product.name}"/></td>
                                    <td><c:out value="${product.quantity}${product.productType == 'UNCOUNTABLE' ? ' kg' : ''}"/></td>
                                    <td><c:out value="${product.price/100.}"/></td>
                                    <c:if test="${role eq 'SENIOR_CASHIER'}">
                                        <%--<td><div class="btn btn-primary btn-sm float-right add-prod-btn"><a href="/api/remove-from-check?productId=${product.id}">delete</a></div> </td>--%>
                                        <td style="width: 32px;"><button class="btn btn-primary btn-sm float-right add-prod-btn" type="button" style="background-color:#fcd85a;color:rgb(34,34,34);" onclick="location.href='${pageContext.request.contextPath}/api/remove-from-check?productId=${product.id}'" ">REMOVE</button></td>
                                    </c:if>
                                </div>
                            <%--</form>--%>
                            <c:set var="total" value="${total + product.quantity * product.price/100.}"/>
                        </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div style="height:50px;">
            <button class="btn btn-primary btn-sm float-right" type="submit" style="background-color:#fcd85a;color:rgb(34,34,34);font-style:normal;font-weight:bold;">DONE</button>
            <p class="float-left" style="color:rgb(34,34,34);font-style:normal;">TOTAL ${total}</p>
        </div>
    </form>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>