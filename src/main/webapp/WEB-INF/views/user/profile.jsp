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
    <h2>Edytuje dane</h2>
    <form:form method="post" modelAttribute="user">
        <form:hidden path="id" value="${id}"/>
        <div class="form-group">
            <form:input path="firstName" type="text" placeholder="${firstName}" />
        </div>

        <div class="form-group">
            <form:input path="lastName" type="text" placeholder="${lastName}" />
        </div>

        <div class="form-group">
            <form:input path="email" type="email" placeholder="${email}" />
        </div>

        <div class="form-group">
            <form:input path="password" type="password" placeholder="Hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zapisz</button>
        </div>
    </form:form>
</section>

<c:import url="/WEB-INF/views/homepage/footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
