<%@include file="../init.jsp"%>

<section id="hero">
    <nav class="navbar navbar-light navbar-expand-md fixed-top" style="background-color:#fcd85a;">
        <div class="container-fluid"><a class="navbar-brand" href="#" style="color:rgb(34,34,34);">Cash Machine</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav mx-auto" style="font-family:Montserrat, sans-serif;font-weight:normal;">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}add-product-to-storage-form" style="color:rgb(34,34,34);font-size:17px;">add product</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}merchant-info" style="color:rgb(34,34,34);font-size:17px;">info</a></li>
                </ul>
                <ul class="nav navbar-nav" style="font-family:Montserrat, sans-serif;">

                    <li class="nav-item" role="presentation">
                        <form>
                            <select class="form-control" id="language" name="language" onchange="submit()">
                                <option value="en_US" ${language == 'en_US' ? 'selected' : ''}>ENG</option>
                                <option value="uk_UA" ${language == 'uk_UA' ? 'selected' : ''}>UKR</option>
                            </select>
                        </form>
                        </label>
                    </li>
                    <li class="nav-item" role="presentation"><div class="nav-link active" style="color:rgb(51,51,51);">${firstName}</div></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="api/logout" style="color:rgb(51,51,51);"><fmt:message key="nav.logout"/></a></li>
                </ul>
            </div>
        </div>
    </nav>
</section>