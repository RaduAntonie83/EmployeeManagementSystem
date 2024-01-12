<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="./styles/style.css">
<t:pageTemplate pageTitle="Employee Management System">
    <br>
    <h1 class="display-4 text-center text-white" >Welcome to the Employee Management System</h1>
    <br>  <br>
    <div class="row">
        <div class="col-md-6">
            <img src="https://www.pockethrms.com/wp-content/uploads/2022/01/Happy-Workforce.jpg" alt="welcome" class="img-fluid center d-block mx-auto mt-3" style="border-radius: 10px;border-radius: 10px;">
        </div>
        <div class="col-md-6  d-flex align-items-center justify-content-center">
            <c:choose>
                <c:when test="${pageContext.request.getRemoteUser() == null}">
                    <a type="button" href="${pageContext.request.contextPath}/Login" class="btn btn-light  mt-3 ml-2 login-button">Login  → </a>
                </c:when>
                <c:otherwise>
                    <a type="button" href="${pageContext.request.contextPath}/Logout" class="btn btn-light  mt-3 ml-2 login-button">Logout  </a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</t:pageTemplate>