<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>--%>
<!DOCTYPE html>
<html lang="pl">
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
<%--            ------------------------------------------------------------%>
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                <li class="logged-user">
                    Witaj,     <sec:authentication  property="principal.firstname"/>
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
                    <li><a href="<c:url value="/login"/>"  class="btn btn--small btn--without-border">Zaloguj</a></li>
                    <li><a href="<c:url value="/user/register"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
                </c:otherwise>
            </c:choose>

    <%--            ------------------------------------------------------------%>
        </ul>

        <ul>
            <li><a href="<c:url value="/"/>" class="btn btn--without-border">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="<c:url value="/donation/add"/>" class="btn btn--without-border active">Przekaż dary</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br />
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>