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
                        <c:if test="${pageContext.request.isUserInRole('READ_EMPLOYEES')}">
                            <a class="nav-link ${activePage eq   'Employees' ? 'active' : ''}"
                               aria-current="page" href="${pageContext.request.contextPath}/Employees">Employees</a>
                        </c:if>
                    </li>
                </ul>
                <a class="navbar-brand mx-auto" href="${pageContext.request.contextPath}">Employee Management</a>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${pageContext.request.getRemoteUser() == null}">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
</main>

