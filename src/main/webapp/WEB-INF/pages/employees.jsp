<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">

<t:pageTemplate pageTitle="Employees">
    <form method="POST" action="${pageContext.request.contextPath}/Employee">
<div class="background-white-rounded">
    <div>
        <div class="row">
            <div class="col">
                <h3>Employees</h3>
            </div>
            <div class="col"></div>
            <div class="col">
                <c:if test="${pageContext.request.isUserInRole('WRITE_EMPLOYEES')}">
                <button type="button" class="btn btn-light">
                    <i class="bi bi-trash"></i>
                    Delete
                </button>
                </c:if>
                <button type="button" class="btn btn-light">
                    <i class="bi bi-filter"></i>
                    Filters
                </button>
                <button type="button" class="btn btn-outline-dark">
                    <i class="bi bi-cloud-download"></i>
                    Export
                </button>
                <c:if test="${pageContext.request.isUserInRole('WRITE_EMPLOYEES')}">
                <button class="btn btn-primary" type="submit">
                    <i class="bi bi-plus-lg"></i>
                    Add new Employee
                </button>
                </c:if>
            </div>
        </div>
    </div>
    <div class = "container-fluid text-justify">
        <div class="row border-bottom border-top background-light-gray">
            <div class="col">
                <div class="form-check">
                    <input class="form-check-input checkbox-sml" type="checkbox" value="" id="flexCheckIndeterminate">
                    <label class="form-check-label" for="flexCheckIndeterminate">
                    </label>
                </div>
            </div>
            <div class="col">
                Name
                <i class="bi bi-arrow-down"></i>
            </div>
            <div class="col">
                Address
                <i class="bi bi-arrow-down"></i>
            </div>
            <div class="col">
                Salary
                <i class="bi bi-arrow-down"></i>
            </div>
            <div class="col">
                Class
                <i class="bi bi-arrow-down"></i>
            </div>
            <div class="col">
                Hours
                <i class="bi bi-arrow-down"></i>
            </div>
            <div class="col">
                Gender
                <i class="bi bi-arrow-down"></i>
            </div>
            <div class="col">
                Birthdate
                <i class="bi bi-arrow-down"></i>
            </div>
            <div class="col">
                Email
                <i class="bi bi-arrow-down"></i>
            </div>
        </div>
        <c:forEach var="employee" items="${employeeList}">
            <div class="row border-bottom">
                <div class="col">
                    <div class="form-check">
                        <input class="form-check-input checkbox-sml" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                        </label>
                    </div>
                </div>
                <div class="col">
                   ${employee.name}
                </div>
                <div class="col">
                    ${employee.address}
                </div>
                <div class="col">
                    ${employee.salary}
                </div>
                <div class="col">
                    ${employee.class}
                </div>
                <div class="col">
                    ${employee.workingHours}
                </div>
                <div class="col">
                    ${employee.gender}
                </div>
                <div class="col">
                    ${employee.dateOfBirth}
                </div>
                <div class="col">
                    ${employee.email}
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</div>
    </form>
</t:pageTemplate>

