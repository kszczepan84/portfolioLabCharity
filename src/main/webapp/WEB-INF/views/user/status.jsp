<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<c:import url="/WEB-INF/views/user/header.jsp"/>
<section class="login-page">
    <h2>Status daru</h2>
    <ul class="help--slides-items">
        <li>
            <div class="col">
                <div class="title">                 ${placed} ${placedDate}<br>
                                                    ${received} ${receivedDate}<br>
                                                    ${transferred} ${transferredDate}<br>
                    Zmień status na: <a href="<c:url value="/user/donation/status/received/${donation.id}"/>">Odebrane przez kuriera</a>| <a href="<c:url value="/user/donation/status/transferred/${donation.id}"/>">Odebrane przez instytucję</a> <br>

                </div>
            </div>
        </li>
    </ul>
</section>

<c:import url="/WEB-INF/views/homepage/footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
