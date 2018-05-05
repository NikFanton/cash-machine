<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<body>

<jsp:include page="util/navbar.jsp"/>

<div class="features-boxed" style="margin-top:35px;background-color:rgba(252,216,90,0);">
    <div class="container">
        <div class="row justify-content-center features">
            <div class="col-sm-6 col-md-5 col-lg-4 item">
                <div class="box">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-body"><i class="fa fa-file-text-o icon" style="color:#7d8285;"></i>
                                    <h4 class="card-title" style="font-size:18px;font-family:Montserrat, sans-serif;"><strong>X-Report</strong></h4>
                                    <h6 class="text-muted card-subtitle mb-2" style="font-size:16px;">The working day will not be marked as ended<br></h6><a class="card-link" href="#" style="font-size:16px;">make x-report</a></div>
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
                                    <h4 class="card-title" style="font-size:18px;font-family:Montserrat, sans-serif;"><strong>Z-Report</strong></h4>
                                    <h6 class="text-muted card-subtitle mb-2" style="font-size:16px;">The working day will be marked as ended</h6><a class="card-link" href="#" style="font-size:16px;">make z-report</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>