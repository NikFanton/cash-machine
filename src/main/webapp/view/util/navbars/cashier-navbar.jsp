<%@include file="../init.jsp"%>

<section id="hero">
    <nav class="navbar navbar-light navbar-expand-md fixed-top" style="background-color:#fcd85a;">
        <div class="container-fluid"><a class="navbar-brand" href="#" style="color:rgb(34,34,34);">Cash Machine</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                    class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav mx-auto" style="font-family:Montserrat, sans-serif;font-weight:normal;">
                    <li class="nav-item" role="presentation" style="background-color:rgba(255,90,79,0.83);font-weight:normal;"><a class="nav-link active" href="${pageContext.request.contextPath}create-check" style="color:rgb(255,255,255);font-size:17px;"><fmt:message key="nav.create.check"/> </a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}find-product-form" style="color:rgb(34,34,34);"><fmt:message key="nav.find.product"/> </a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}check-list" style="color:rgb(34,34,34);"><fmt:message key="nav.check.list"/> </a></li>
                    <c:if test="${role == 'SENIOR_CASHIER'}">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}report" style="color:rgb(34,34,34);"><fmt:message key="nav.reports"/></a></li>
                    </c:if>
                </ul>
                <ul class="nav navbar-nav" style="font-family:Montserrat, sans-serif;">

                    <li class="nav-item" role="presentation">
                            <form>
                                <select class="form-control" id="language" name="language" onchange="submit()">
                                    <option value="en_US" ${language == 'en_US' ? 'selected' : ''}>ENG</option>
                                    <option value="ru_RU" ${language == 'ru_RU' ? 'selected' : ''}>RUS</option>
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