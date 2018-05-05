<%@ include file="util/init.jsp"%>
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

<jsp:include page="util/navbar.jsp"/>

<div class="container" id="content" style="background-color:#fffcf3;">
    <div class="row d-flex input-panel">
        <div class="col-md-4 d-inline" style="min-width:276px;"><label class="col-form-label" style="font-family:Roboto, sans-serif;">Search</label><input class="align-items-baseline search-field" type="text" placeholder=" id or name" style="font-family:Roboto, sans-serif;"></div>
        <div class="col d-inline"><label class="col-form-label" style="font-family:Roboto, sans-serif;">Quantity</label><input class="align-items-baseline quantity-field" type="text" inputmode="numeric" style="font-family:Roboto, sans-serif;"></div>
        <div class="col-2" style="width:178px;min-width:0px;"><button class="btn btn-primary btn-sm float-right add-prod-btn" type="button" style="background-color:#fcd85a;color:rgb(34,34,34);">Add</button></div>
    </div>
    <div class="table-responsive" style="font-family:Roboto, sans-serif;">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th style="font-family:Roboto, sans-serif;">#</th>
                <th>serial number</th>
                <th>name</th>
                <th>quantity</th>
                <th>price</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>453289781273</td>
                <td>Tea "Lipton"</td>
                <td>1</td>
                <td>12.20</td>
            </tr>
            <tr>
                <td>2</td>
                <td>463298973872<br></td>
                <td>Marshmallow "Jet-Puffed"</td>
                <td>2</td>
                <td>6.50</td>
            </tr>
            <tr>
                <td>3</td>
                <td>478214392108<br></td>
                <td>Cookies</td>
                <td>1.5</td>
                <td>5.25</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div style="height:50px;"><button class="btn btn-primary btn-sm float-right" type="submit" style="background-color:#fcd85a;color:rgb(34,34,34);font-style:normal;font-weight:bold;">Print check</button></div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>