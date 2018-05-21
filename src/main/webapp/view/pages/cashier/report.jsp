<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../util/init.jsp"%>
<%@ taglib uri="/WEB-INF/numberformat.tld" prefix="formatvalue" %>
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

<jsp:include page="../../util/navbars/cashier-navbar.jsp"/>

<div class="features-boxed" style="margin-top:35px;background-color:rgba(252,216,90,0);">
    <div class="container">
        <div class="row justify-content-center features" style="padding-bottom: 0px;">
            <div class="col-sm-6 col-md-5 col-lg-4 item">
                <div class="box">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <i class="fa fa-file-text-o icon" style="color:#7d8285;"></i>
                                    <h4 class="card-title" style="font-size:18px;font-family:Montserrat, sans-serif;"><strong><fmt:message key="x.report"/></strong></h4>
                                    <h6 class="text-muted card-subtitle mb-2" style="font-size:16px;"><fmt:message key="x.report.discription"/><br></h6>
                                    <a class="card-link" style="font-size:16px;color: #3a92ff; cursor: pointer;" onclick="var win = window.open('${pageContext.request.contextPath}make-x-report' , '_blank');win.focus();"><fmt:message key="make.x.report"/></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-5 col-lg-4 item">
                <div class="box">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-body"><i class="fa fa-file-text-o icon" style="color:rgba(255,90,79,0.83);"></i>
                                    <h4 class="card-title" style="font-size:18px;font-family:Montserrat, sans-serif;"><strong><fmt:message key="z.report"/></strong></h4>
                                    <h6 class="text-muted card-subtitle mb-2" style="font-size:16px;"><fmt:message key="z.report.discription"/></h6><a class="card-link" href="${pageContext.request.contextPath}make-z-report" style="font-size:16px;"><fmt:message key="make.z.report"/></a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row justify-content-center features" style="padding-top: 0px;">
            <jsp:useBean id="reports" scope="request" type="java.util.List"/>
            <c:if test="${not empty reports}">
                <c:set var="length" value="${fn:length(reports)}"/>
                <c:forEach var="i" begin="0" end="${length-1}" step="1">
                    <c:set var="report" value="${reports[i]}"/>

                    <div class="col-sm-6 col-md-5 col-lg-3 item">
                        <div class="box">
                            <div class="row">
                                <div class="col">
                                    <div id="check-card-${report.id}" class="modal" style="padding-top: 70px;">
                                        <div class="login-clean" style="background-color:rgba(252,216,90,0);padding-top: 30px;">
                                            <form style="padding-top: 30px;">
                                                <div class="illustration modal-content animate" style="margin: 0; padding:0;text-align:left;">
                                                    <div class="form-group" style="margin-left: 0px;margin-bottom: 0px;">
                                                        <button class="btn btn-primary btn-block btn-login" type="submit" style="text-transform: uppercase; background-color:#fcd85a;font-weight:normal;font-style:normal;font-size:16px;margin-top: 0px;margin-bottom: 10px;padding-top: 5px;padding-bottom: 5px;" onchange="document.getElementById('check-card-${check.id}').style.display = "none";"><fmt:message key="close"/> </button>
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
                                                                <td colspan="3">м.Київ, вул. Хрещатик, 36</td>
                                                            </tr>
                                                            <tr class="align-center">
                                                                <td colspan="3">ГАРЯЧА ЛІНІЯ 0 800 230 412</td>
                                                            </tr>
                                                            <tr class="align-center">
                                                                <td colspan="3">email in@supermarket.com</td>
                                                            </tr>
                                                            <tr class="align-center">
                                                                <td colspan="3"><b>Z-ЗВІТ</b></td>
                                                            </tr>
                                                            <%--<tr><td colspan="3">-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -</td></tr>--%>
                                                            <tr><td colspan="3">-----------------------------------------------------------</td></tr>
                                                            <tr>
                                                                <td colspan="2">РЕЖИМ ПРОДАЖІВ</td>
                                                                <td style="text-align:  right;">ПДВ ВКЛ.</td>
                                                            </tr>
                                                            <tr><td colspan="3">-----------------------------------------------------------</td></tr>
                                                            <tr>
                                                                <td colspan="2">ЧЕКІВ</td>
                                                                <td class="align-right">${report.checksCount}</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ПРОДАЖІ</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.checksCount}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">АНУЛЬВАНО</td>
                                                                <td class="align-right">${report.canceledChecksCount}</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ГОТІВКА</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.cashPayments/100}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr><td colspan="3">- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -</td></tr>
                                                            <tr>
                                                                <td colspan="2">ОБІГ А</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.cashPayments/100}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ОБІГ Б</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.cashlessPayments/100}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ОБІГ</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.cashPayments/100 + report.cashlessPayments/100}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="3">ПДВ А=20.00%</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="3">ПДВ Б=0.00%</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ПОДАТОК</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.cashPayments/500}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ЗАГ. СУМА</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.cashPayments/125 + report.cashlessPayments/100}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr><td colspan="3">-----------------------------------------------------------</td></tr>
                                                            <tr class="align-center">
                                                                <td colspan="3">АНУЛЬВАНО</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ЧЕКІВ</td>
                                                                <td class="align-right">${report.canceledChecksCount}</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ГОТІВКА</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.canceledCashPayments/100}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr><td colspan="3">- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -</td></tr>
                                                            <tr>
                                                                <td colspan="2">СЛУЖБОВЕ ВНЕСЕННЯ</td>
                                                                <td class="align-right">22,50</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">СЛУЖБОВА ВИДАЧА</td>
                                                                <td class="align-right"><formatvalue:formatNumber number="${report.seizedMoney/100}" format="###0.00"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2">ГОТІВКА У СЕЙФІ</td>
                                                                <td class="align-right">22,50</td>
                                                            </tr>
                                                            <tr><td colspan="3">-----------------------------------------------------------</td></tr>
                                                            <tr>
                                                                <td colspan="3">РЕГІСТРИ ДАННИХ ОБНУЛЕНІ</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="3">ДАНІ ПО ОПЕРАТОРАХ АНУЛЬОВАНО</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="3">ДАНІ ПО АРТИКУЛАХ АНУЛЬОВАНО</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="3">ФІСКАЛЬНИЙ ЗВІТ ДІЙСНИЙ</td>
                                                            </tr>
                                                            <tr><td colspan="3">-----------------------------------------------------------</td></tr>
                                                            <tr>
                                                                <td colspan="2">${report.dateTime.toLocalDate()}</td>
                                                                <td class="align-right">${report.dateTime.toLocalTime()}</td>
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
                                    <div class="card" style="cursor: pointer;" onclick="document.getElementById('check-card-${report.id}').style.display='block'">
                                        <div class="card-body">
                                            <div>
                                                <i class="fa fa-file-text-o icon" style="color:rgba(255,90,79,0.83);;"></i>
                                                <h4 class="card-title" style="font-size:18px;"><strong><fmt:message key="z.report"/> #${report.id}</strong><br></h4>
                                                <h6 class="text-muted card-subtitle mb-2" style="font-size:16px;">
                                                    <fmt:parseDate var="date" pattern="yyyy-MM-dd" value="${report.dateTime.toLocalDate()}"/>
                                                    <fmt:message var="dateFormatPattern" key="date.format"/>
                                                    <fmt:formatDate pattern = "${dateFormatPattern}" value = "${date}"/>
                                                    <c:out value="${report.dateTime.toLocalTime()}"/><br>
                                                </h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>