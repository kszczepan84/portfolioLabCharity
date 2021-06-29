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
    <h2>Lista darów</h2>
<c:forEach items="${donations}" var="donation">
    <ul class="help--slides-items">
        <li>
            <div class="col">
                <div class="title">nr ${donation.id}, przekazane dla: ${donation.institution}, ilość worków: ${donation.quantity},
                miejsce odbioru w: ${donation.city} ${donation.street} ${donation.zipCode}, data odbioru: ${donation.pickUpDate}
                    o godzinie: ${donation.pickUpTime}|
                    <a href="<c:url value="/user/donation/edit/${donation.id}"/>">Edytuj</a>|
                    <a href="<c:url value="/user/donation/delete/${donation.id}"/>">Usuń</a>

                </div>
            </div>
        </li>
    </ul>
   </c:forEach>
</section>

<c:import url="/WEB-INF/views/homepage/footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
