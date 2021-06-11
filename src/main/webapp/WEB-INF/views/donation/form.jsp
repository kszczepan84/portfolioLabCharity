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
<c:import url="/WEB-INF/views/donation/header.jsp"/>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <%--        <form action="form-confirmation.html" method="post">--%>
        <form:form modelAttribute="donation" method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>


                    <%--                                    <c:forEach items="${categories}" var="category" varStatus="status">--%>
<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>

<%--                        <form:checkboxes path="categories"--%>
<%--                                         items="${categories}" itemValue="name"/>--%>
<%--                        <span class="checkbox"></span>--%>
<%--                        <span class="description">${categories.get(status.index).name}</span>--%>
<%--                    </label>--%>
<%--                </div>--%>


                    <%--                                    </c:forEach>--%>

                    <%--------------------------------------------------------------------------------------------------------------------------------%>
                                    <div class="form-group form-group--checkbox">
                                        <label>
                                            <form:radiobutton id="categories0"
                                                    path="categories"
                                                    value="${categories[0]}"

                                            />
                                            <span class="checkbox radio"></span>
                                            <span class="description" id="categories0name"
                                            >${categories[0].name}</span>
                                        </label>
                                    </div>

                                    <div class="form-group form-group--checkbox">
                                        <label>
                                            <form:radiobutton id="categories1"

                                                    path="categories"
                                                    value="${categories[1]}"
                                            />
                                            <span class="checkbox radio"></span>
                                            <span class="description" id="categories1name">${categories[1].name}</span>
                                        </label>
                                    </div>

                                    <div class="form-group form-group--checkbox">
                                        <label>
                                            <form:radiobutton id="categories2" path="categories" value="${categories[2]}"/>
                                            <span class="checkbox radio"></span>
                                            <span class="description" id="categories2name">${categories[2].name}</span>
                                        </label>
                                    </div>

                                    <div class="form-group form-group--checkbox">
                                        <label>
                                            <form:radiobutton id="categories3" path="categories" value="${categories[3]}"/>
                                            <span class="checkbox radio"></span>
                                            <span class="description" id="categories3name">${categories[3].name}</span>
                                        </label>
                                    </div>

                                    <div class="form-group form-group--checkbox">
                                        <label>
                                            <form:radiobutton path="categories"  id="categories4" value="${categories[4]}"/>
                                            <span class="checkbox radio"></span>
                                            <span class="description" id="categories4name">${categories[4].name}</span>
                                        </label>
                                    </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <%--------------------------------------------------------------------------------------------------------------------------------%>

                        <!-- STEP 2 -->
                        <div data-step="2">
                            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                            <div class="form-group form-group--inline">
                                <label>
                                    Liczba 60l worków:
                                    <form:input type="number" path="quantity" step="1" min="1"
                                                id="donationQuantity"/>
                                </label>
                            </div>

                            <div class="form-group form-group--buttons">
                                <button type="button" class="btn prev-step">Wstecz</button>
                                <button type="button" class="btn next-step">Dalej</button>
                            </div>
                        </div>


            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton path="institution" value="${institution[0]}" id="institution0"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title" id="institution0title">${institution[0].name}</div>
                  <div class="subtitle">
                          ${institution[0].description}
                  </div>
                </span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton path="institution" value="${institution[1]}" id="institution1"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title" id="institution1title">${institution[1].name}</div>
                  <div class="subtitle">
                          ${institution[1].description}
                  </div>
                </span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton path="institution" value="${institution[2]}" id="institution2"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title" id="institution2title">${institution[2].name}</div>
                  <div class="subtitle">
                          ${institution[2].description}
                  </div>
                </span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton path="institution" value="${institution[3]}" id="institution3"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title" id="institution3title">${institution[3].name}</div>
                  <div class="subtitle">
                          ${institution[3].description}
                  </div>
                </span>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input type="text" path="street" id="streetNameInput"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input type="text" path="city" id="cityNameInput"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input type="text" path="zipCode" id="zipCodeInput"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <input type="phone" name="phone" id="phoneInput"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input type="date" path="pickUpDate" id="pickUpDateInput"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input type="time" path="pickUpTime" id="pickUpTimeInput"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="pickUpComment" rows="5" id="pickUpCommentInput"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                    <span id="donationQuantityP"></span> worki <span id="categoryInput"></span></span
                                >
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
<%--                                >Dla fundacji "Mam marzenie" w Warszawie</span>--%>
                                >Dla: <span id="institutionValue"></span></span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="streetName">Prosta 51</li>
                                <li id="cityName">Warszawa</li>
                                <li id="zipCodeName">99-098</li>
                                <li id="phone">123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="pickUpDate">13/12/2018</li>
                                <li id="pickUpTime">15:40</li>
                                <li id="comments">Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
        <%--        </form>--%>
    </div>
</section>
<c:import url="/WEB-INF/views/donation/footer.jsp"/>


<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
