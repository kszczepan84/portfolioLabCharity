<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
  </head>
  <body>
<%--  <c:import url="/WEB-INF/views/donation/header.jsp"/>--%>
    <header class="header--form-page">
      <nav class="container container--70">
        <ul class="nav--actions">
          <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
              <li class="logged-user">
                Witaj,     <sec:authentication  property="principal.username"/>
                <ul class="dropdown">
                  <li><a href="<c:url value="/user/profile"/>">Profil</a></li>
                  <li><a href="<c:url value="/user/donations"/>">Moje zbiórki</a></li>
                  <li><a href="javascript: document.logoutForm.submit()">Wyloguj</a></li>
                  <form:form action="${'/logout'}" method="post" hidden="true" name="logoutForm">
                    <input type="submit" value="Logout"/>
                  </form:form>
                </ul>
              </li>
            </c:when>
            <c:otherwise>
              <li><a href="<c:url value="/user/login"/>"  class="btn btn--small btn--without-border">Zaloguj</a></li>
              <li><a href="<c:url value="/user/register"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </c:otherwise>
          </c:choose>
        </ul>

        <ul>
          <li><a href="<c:url value="/"/>" class="btn btn--without-border">Start</a></li>
          <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
          <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
          <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
          <li><a href="<c:url value="/donation/add"/>" class="btn btn--without-border">Przekaż dary</a></li>
          <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
      </nav>

      <div class="slogan container container--90">
          <h2>
            Dziękujemy za przesłanie formularza Na maila prześlemy wszelkie
            informacje o odbiorze.
          </h2>
      </div>
    </header>

<c:import url="/WEB-INF/views/donation/footer.jsp"/>
<script src="<c:url value="/resources/js/app.js"/>"></script>
  </body>
</html>
