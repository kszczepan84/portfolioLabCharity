<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
</head>
<body>
<form:form modelAttribute="donation" method="post">
    category:
    <form:checkboxes path="categories"
                     items="${categories}" itemLabel="name"/>
    <br>
    institution:
    <form:select path="institution" items="${institution}" itemLabel="name"/>
    <br>
    zipcode:
    <form:input path="zipCode" />
    <br>
    street:
    <form:input path="street" />
    <br>
    city:
    <form:input path="city"/>
    <br>
    quantity:
    <form:input path="quantity"/>
    <br>
    comment:
    <form:textarea path="pickUpComment"/>
    <br>
    date:
    <form:input type="date" path="pickUpDate"/>
    <br>
    time:
    <form:input type="time" path="pickUpTime" />

    <button type="submit"> Submit </button>
</form:form>


</body>
</html>
