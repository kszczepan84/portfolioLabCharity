<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <h2>Zaloguj się</h2>
    <form method="post">
        <div class="form-group">
            <input type="email" name="email" placeholder="Email"/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło"/>
            <br>


            <%--            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">--%>
            <%--                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>--%>
            <%--            </c:if>--%>
<%--            <c:forEach items="${errors}" var="error">--%>
<%--                    ${error}--%>
<%--            </c:forEach>--%>

             <h3>${errorMessage} </h3>


<%--            ${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'Bad credentials', 'Username/Password are incorrect')}--%>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zaloguj się</button>
            <a href="<c:url value="/user/register"/>" class="btn btn--without-border">Załóż konto</a>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
    </form>
</section>

<c:import url="/WEB-INF/views/homepage/footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
