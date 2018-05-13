<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%--<jsp:include page="../../util/cashier-navbar.jsp"/>--%>

<div id="check-card-${xreport.id}" class="modal" style="padding-top: 0px; display:block;">
    <div class="login-clean" style="padding-top: 30px; background-color: #fef2cb;">
        <form style="padding-top: 30px;">
            <div class="illustration modal-content animate" style="margin: 0; padding:0;text-align:left;">
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
                            <td colspan="3"><b>X-ЗВІТ</b></td>
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
                            <td class="align-right">${xreport.checksCount}</td>
                        </tr>
                        <tr>
                            <td colspan="2">ПРОДАЖІ</td>
                            <td class="align-right">${xreport.checksCount}</td>
                        </tr>
                        <tr>
                            <td colspan="2">АНУЛЬВАНО</td>
                            <td class="align-right">${xreport.canceledChecksCount}</td>
                        </tr>
                        <tr>
                            <td colspan="2">ГОТІВКА</td>
                            <td class="align-right">${xreport.cashPayments/100}</td>
                        </tr>
                        <tr><td colspan="3">- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -</td></tr>
                        <tr>
                            <td colspan="2">ОБІГ А</td>
                            <td class="align-right">${xreport.cashPayments/100}</td>
                        </tr>
                        <tr>
                            <td colspan="2">ОБІГ Б</td>
                            <td class="align-right">${xreport.cashlessPayments/100}</td>
                        </tr>
                        <tr>
                            <td colspan="2">ОБІГ</td>
                            <td class="align-right">${xreport.cashPayments/100 + xreport.cashlessPayments/100}</td>
                        </tr>
                        <tr>
                            <td colspan="3">ПДВ А=20.00%</td>
                        </tr>
                        <tr>
                            <td colspan="3">ПДВ Б=0.00%</td>
                        </tr>
                        <tr>
                            <td colspan="2">ПОДАТОК</td>
                            <td class="align-right">${xreport.cashPayments/500}</td>
                        </tr>
                        <tr>
                            <td colspan="2">ЗАГ. СУМА</td>
                            <td class="align-right">${xreport.cashPayments/125 + xreport.cashlessPayments/100}</td>
                        </tr>
                        <tr><td colspan="3">-----------------------------------------------------------</td></tr>
                        <tr class="align-center">
                            <td colspan="3">АНУЛЬВАНО</td>
                        </tr>
                        <tr>
                            <td colspan="2">ЧЕКІВ</td>
                            <td class="align-right">${xreport.canceledChecksCount}</td>
                        </tr>
                        <tr>
                            <td colspan="2">ГОТІВКА</td>
                            <td class="align-right">${xreport.canceledCashPayments/100}</td>
                        </tr>
                        <tr><td colspan="3">- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -</td></tr>
                        <tr>
                            <td colspan="2">СЛУЖБОВЕ ВНЕСЕННЯ</td>
                            <td class="align-right">22.50</td>
                        </tr>
                        <tr>
                            <td colspan="2">ГОТІВКА У СЕЙФІ</td>
                            <td class="align-right">${xreport.cashPayments/100 + 22.50}</td>
                        </tr>
                        <tr><td colspan="3">-----------------------------------------------------------</td></tr>

                        <tr class="align-center">
                            <td colspan="3">СЛУЖБОВИЙ ЧЕК</td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="features-boxed" style="margin-top:35px;background-color:rgba(252,216,90,0);">
    <div class="container">
        <div class="row justify-content-center features" style="padding-top: 0px;">

        </div>
    </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>