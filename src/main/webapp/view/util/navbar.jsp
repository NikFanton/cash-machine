<%@include file="util/init.jsp"%>

<section id="hero">
    <nav class="navbar navbar-light navbar-expand-md fixed-top" style="background-color:#fcd85a;">
        <div class="container-fluid"><a class="navbar-brand" href="#" style="color:rgb(34,34,34);">Cash Machine</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                    class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav mx-auto" style="font-family:Montserrat, sans-serif;font-weight:normal;">
                    <li class="nav-item" role="presentation" style="background-color:rgba(255,90,79,0.83);font-weight:normal;"><a class="nav-link active" href="api/create-check" style="color:rgb(255,255,255);font-size:17px;">Create check</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="api/check-list" style="color:rgb(34,34,34);">Check list</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="api/report" style="color:rgb(34,34,34);">Reports</a></li>
                </ul>
                <ul class="nav navbar-nav" style="font-family:Montserrat, sans-serif;">
                    <li class="nav-item" role="presentation">
                        <label>
                            <form>
                                <select class="form-control" id="lang" name="language" onchange="submit()">
                                    <option value="en-us" ${language == 'en-us' ? 'selected' : ''}>ENG</option>
                                    <option value="ru-ru" ${language == 'ru-ru' ? 'selected' : ''}>RUS</option>
                                </select>
                            </form>

                        </label>
                    </li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="api/logout" style="color:rgb(51,51,51);">Log Out</a></li>
                </ul>
            </div>
        </div>
    </nav>
</section>