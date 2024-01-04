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
                        <c:choose>
                            <c:when test="${not empty sessionScope.username}">
                                <span style="color: white;">Welcome, ${sessionScope.username}!</span>
                            </c:when>
                            <c:otherwise>
                                <span style="color: white;">Not logged in</span>
                            </c:otherwise>
                        </c:choose>



                    </li>
                </ul>
                <a class="navbar-brand mx-auto" href="">Employee Management</a>
                <button class="navbar-toggler vh-10" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>
    </header>
</main>

