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
    <link rel="stylesheet" href="/view/assets/css/Check.css">

</head>

<body>

<jsp:include page="../../util/cashier-navbar.jsp"/>

<c:set var="green" value="#bae860;"/>
<c:set var="yellow" value="#fcd85a;"/>
<c:set var="red" value="rgba(255,90,79,0.83);"/>

<div class="features-boxed" style="margin-top:35px;background-color:rgba(252,216,90,0);">
    <div class="container">
        <div class="row justify-content-center features" style="padding-top: 10px; padding-bottom: 10px;">

            <jsp:useBean id="checks" scope="request" type="java.util.List"/>
            <c:set var="length" value="${fn:length(checks)}"/>
            <c:forEach var="i" begin="1" end="${length}" step="1">
                <c:set var="check" value="${checks[length-i]}"/>

                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box">
                        <div class="row">
                            <div class="col">
                                <div id="check-card-${check.id}" class="modal" style="padding-top: 70px;">
                                    <div class="login-clean" style="background-color:rgba(252,216,90,0);padding-top: 30px;">
                                        <form style="padding-top: 30px;">
                                            <div class="illustration modal-content animate" style="margin: 0; padding:0;text-align:left;">
                                                <div class="form-group" style="margin-left: 0px;margin-bottom: 0px;">
                                                    <button class="btn btn-primary btn-block btn-login" type="submit" style="background-color:#fcd85a;font-weight:normal;font-style:normal;font-size:16px;margin-top: 0px;margin-bottom: 10px;padding-top: 5px;padding-bottom: 5px;" onchange="document.getElementById('check-card-${check.id}').style.display = "none";">CLOSE</button>
                                                </div>
                                                <div class="bill">
                                                    <table>
                                                        <tr class="align-center">
                                                            <td colspan="3">ТОВ "SuperMarket"</td>
                                                        </tr>
                                                        <tr class="align-center">
                                                            <td colspan="3">Магазин "Продукти-234"</td>
                                                        </tr>
                                                        <tr class="align-center">
                                                            <td colspan="3">Вітаємо</td>
                                                        </tr>
                                                        <tr class="align-center">
                                                            <td colspan="3">ГАРЯЧА ЛІНІЯ 0 800 230 412</td>
                                                        </tr>
                                                        <tr class="align-center">
                                                            <td colspan="3">email in@supermarket.com</td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="3">${check.employee.firstName} ${check.employee.lastName}</td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2">Чек ${check.id}</td>
                                                            <td class="align-right">#</td>
                                                        </tr>

                                                        <c:set var="total" value="${0}"/>
                                                        <c:forEach var="product" items="${check.productsInCheck}">
                                                            <tr>
                                                                <td>${product.quantity}${product.productType == 'UNCOUNTABLE' ? 'kg' : ''} x</td>
                                                                <td class="align-right">${product.price/100 }</td>
                                                                <td></td>
                                                            </tr>
                                                            <tr>
                                                                <td>${product.name}</td>
                                                                <c:set var="total" value="${total + product.quantity * product.price/100.}"/>
                                                                <td class="align-right">${product.quantity * product.price/100}</td>
                                                                <td class="align-right">A</td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <td colspan="3">-----------------------------------------------------------</td>
                                                        </tr>
                                                        <tr>
                                                            <td>СУМА</td>
                                                            <td colspan="2" class="align-right">${total}</td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="3">- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -</td>
                                                        </tr>
                                                        <tr>
                                                            <td>ГОТІВКА</td>
                                                            <td colspan="2" class="align-right">${check.cashPayment/100}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>КАРТКА</td>
                                                            <td colspan="2" class="align-right">${check.cashlessPayment/100}</td>
                                                        </tr>
                                                        <tr class="align-center">
                                                            <td colspan="3">ДЯКУЄМО ЗА ПОКУПКУ!</td>
                                                        </tr>
                                                        <tr>
                                                            <td><c:out value="${check.dateTime.toLocalDate()}"/></td>
                                                            <td colspan="2" class="align-right"><c:out value="${check.dateTime.toLocalTime()}"/></td>
                                                        </tr>
                                                        <tr class="align-center">
                                                            <td colspan="3">ФІСКАЛЬНИЙ ЧЕК</td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                                <div class="card" style="cursor: pointer;">
                                    <div class="card-body">
                                        <div onclick="document.getElementById('check-card-${check.id}').style.display='block'">
                                            <i class="fa fa-circle icon" style="color:${check.checkType == 'NORMAL' ? green
                                                                                                        : check.checkType == 'ALTERED' ? yellow
                                                                                                        : red}"></i>
                                            <h4 class="card-title" style="font-size:18px;">
                                                <strong>
                                                    Check #<c:out value="${check.id}"/>
                                                </strong><br>
                                            </h4>
                                            <h6 class="text-muted card-subtitle mb-2" style="font-size:16px;">
                                                <c:out value="${check.dateTime.toLocalDate()}"/>
                                                <c:out value="${check.dateTime.toLocalTime()}"/>
                                                    <%--03.05.2018 - 14:25--%>
                                                <br>
                                            </h6>
                                        </div>
                                        <p style="margin-bottom: 6px;font-size:16px;margin-top: 6px;" <c:out value="${check.checkType != 'CANCELED' ? 'hidden' : ''}"/>>Returned ${total}</p>
                                        <c:if test="${role ne 'SENIOR_CASHIER'}">
                                            <p style="margin-bottom: 6px;font-size:16px;margin-top: 6px;" <c:out value="${check.checkType == 'CANCELED' ? 'hidden' : ''}"/>>&#8203;</p>
                                        </c:if>
                                        <c:if test="${role eq 'SENIOR_CASHIER'}">
                                            <a class="card-link" href="${pageContext.request.contextPath}cancel-check?checkId=${check.id}" style="font-size:16px;" <c:out value="${check.checkType == 'CANCELED' ? 'hidden' : ''}"/>>cancel check</a>
                                        </c:if>
                                        <%--<div class="form-group" style="margin-left: 0px;margin-bottom: 0px;">--%>
                                            <%--<button class="btn btn-primary btn-block btn-login" type="submit" style="background-color:#fcd85a;font-weight:normal;font-style:normal;font-size:16px;margin-top: 0px;margin-bottom: 10px;padding-top: 5px;padding-bottom: 5px; border-color:#fcd85a;">cancel check</button>--%>
                                        <%--</div>--%>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <div style="align-content: center">
            <nav>
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" aria-label="Previous" href="${pageContext.request.contextPath}/api/check-list?page=1"><span style="color: #222222;" aria-hidden="true">«</span></a></li>

                    <c:set var="num_page_buttons" value="3"></c:set>

                    <c:forEach var="i" begin="${(page - num_page_buttons < 1) ? 1 : page - num_page_buttons}" end="${(page + num_page_buttons > maxPageNumber) ? maxPageNumber : page + num_page_buttons}" step="1">
                        <%--<li class="page-item active"><a class="page-link">1<></a></li>--%>
                        <li class="page-item <c:out value="${i eq page ? 'active' : ''}"/>">
                            <a class="page-link" style="<c:out value="${i eq page ? 'background-color: #fcd85a;border-color: #ffc107;' : 'color:  #000;'}"/>" href="${pageContext.request.contextPath}/api/check-list?page=${i}"> ${i} </a>
                        </li>
                    </c:forEach>
                    <li class="page-item"><a class="page-link" aria-label="Next" href="${pageContext.request.contextPath}/api/check-list?page=${maxPageNumber}"><span style="color: #222222;" aria-hidden="true">»</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
