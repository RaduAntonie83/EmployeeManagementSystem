<%--
  Created by IntelliJ IDEA.
  User: Radu
  Date: 11/13/2023
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <link href="carousel.css" rel="stylesheet">
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <li class="nav-item">
<c:if test="${not empty sessionScope.name}">
    <span class="text-white">Welcome, ${sessionScope.name}!</span>
</c:if>
<c:if test="${empty sessionScope.name}">
    <%-- Assuming you set the sessionScope.name attribute to "user" when the user logs in --%>
    <%
        // Example: Set the sessionScope.name when the user logs in
        session.setAttribute("name", "employee");
    %>
    <span class="text-white">Welcome, ${sessionScope.name}!</span>
</c:if>
                    </li>
                </ul>
                <a class="navbar-brand mx-auto" href="">Employee Management</a>
            </div>
        </nav>
    </header>
</main>

