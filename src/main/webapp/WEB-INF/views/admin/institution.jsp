<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/admin.css"/>" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
            crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="<c:url value="/admin/main"/>">Index</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
            class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <%--                    <div class="sb-sidenav-menu-heading">CRUD</div>--%>
                    <a class="nav-link" href="<c:url value="/admin/main"/>">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Strona główna
                    </a>
                    <a class="nav-link" href="<c:url value="/admin/institution"/>">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Instytucje
                    </a>
                    <a class="nav-link" href="<c:url value="/admin/admins"/>">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Administratorzy
                    </a>
                    <a class="nav-link" href="<c:url value="/admin/users"/>">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Użytkownicy
                    </a>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Zalogowany jako:</div>
                <sec:authentication property="principal.firstname"/>
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Instytucje</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">CRUD</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        Lista instytucji
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nazwa instytucji</th>
                                <th>Opis</th>
                                <th>Akcja</th>
                            </tr>
                            </thead>

                            <c:forEach items="${institutions}" var="institution">
                                <tbody>
                                <tr>
                                    <td>${institution.id}</td>
                                    <td>${institution.name}</td>
                                    <td>${institution.description}</td>
                                    <td>
                                        <a href="<c:url value="/admin/institution/add"/>">Dodaj</a>
                                         |
                                        <a href="<c:url value="/admin/institution/edit/${institution.id}"/>">Edytuj</a>
                                        |
                                        <a href="<c:url value="/admin/institution/delete/${institution.id}"/>">Usuń</a>
                                    </td>
                                </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Your Website 2021</div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/chart-area-demo.js"/>"></script>
<script src="<c:url value="/resources/js/chart-bar-demo.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/datatables-simple-demo.js"/>"></script>
</body>
</html>