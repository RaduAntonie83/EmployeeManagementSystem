<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
<script src="<c:url value='/scripts/checkbox.js'/>"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<t:pageTemplate pageTitle="Employees">
    <form method="POST" id="deleteForm" action="${pageContext.request.contextPath}/Employees">
        <div class="background-white-rounded">
            <div>
                <div class="row">
                    <div class="col">
                        <h3>Employees</h3>
                    </div>
                    <div class="col"></div>
                    <div class="col">
                        <c:if test="${pageContext.request.isUserInRole('WRITE_EMPLOYEES')}">
                            <button type="submit" class="btn btn-danger" id="deleteButton">
                                <i class="bi bi-trash"></i>
                                Delete
                            </button>
                        </c:if>
                        <c:if test="${pageContext.request.isUserInRole('WRITE_EMPLOYEES')}">
                            <a type="button" class="btn btn-outline-dark" href="${pageContext.request.contextPath}/PayEmployees">
                                <i class="bi bi-currency-dollar"></i>
                                Pay
                            </a>
                        </c:if>
                        <c:if test="${pageContext.request.isUserInRole('WRITE_EMPLOYEES')}">
                            <a class="btn btn-primary" type="submit" href="${pageContext.request.contextPath}/AddEmployee">
                                <i class="bi bi-plus-lg"></i>
                                Add new Employee
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class = "container-fluid text-justify">
                <div class="row border-bottom border-top background-light-gray text-center">
                    <div class="col-1">
                        <div class="form-check">
                            <input class="form-check-input checkbox-sml" type="checkbox" id="selectAll" onclick="toggleCheckboxes(this)">
                            <label for="selectAll">Select All</label>
                        </div>
                    </div>
                    <div class="col-1">
                        Name
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Address
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Salary
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Class
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Hours
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Gender
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Birthdate
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Email
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Tax Class
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Bonus
                        <i class="bi bi-arrow-down"></i>
                    </div>
                    <div class="col-1">
                        Number of Shares
                        <i class="bi bi-arrow-down"></i>
                    </div>
                </div>
                <c:forEach var="employee" items="${employeeList}">
                    <div class="row border-bottom text-center">
                        <div class="col-1">
                            <div class="form-check">
                                <input class="form-check-input checkbox-sml employee-checkbox" type="checkbox" name="employee_ids" value="${employee.id}" id="employee_${employee.id}">
                                <label for="employee_${employee.id}"></label>
                            </div>
                        </div>
                        <div class="col-1">
                            <a class="" href="${pageContext.request.contextPath}/EditEmployee?id=${employee.id}">${employee.name}</a>
                        </div>
                        <div class="col-1">
                            ${employee.address}
                        </div>
                        <div class="col-1">
                            ${employee.salary}
                        </div>
                        <div class="col-1">
                            <c:set var="className" value="${fn:split(employee.class, '.')[fn:length(fn:split(employee.class, '.'))-1]}" />
                            <c:set var="simpleClassName" value="${fn:substring(className, 0, fn:length(className) - 3)}" />
                            ${simpleClassName}
                        </div>
                        <div class="col-1">
                            ${employee.workingHours}
                        </div>
                        <div class="col-1">
                            ${employee.gender}
                        </div>
                        <div class="col-1">
                            ${employee.dateOfBirth}
                        </div>
                        <div class="col-1">
                            ${employee.email}
                        </div>
                        <div class="col-1">
                            ${employee.taxClass}
                        </div>
                        <c:if test="${fn:contains(employee.class, 'common.LecturerDto')}">
                            <div class="col-1">
                                N/A
                            </div>
                            <div class="col-1">
                                N/A
                            </div>
                        </c:if>
                        <c:if test="${fn:contains(employee.class, 'common.AssociateDto')}">
                            <div class="col-1">
                                ${employee.bonus}
                            </div>
                            <div class="col-1">
                                N/A
                            </div>
                        </c:if>
                        <c:if test="${fn:contains(employee.class, 'common.ExecutiveDto')}">
                            <div class="col-1">
                                ${employee.bonus}
                            </div>
                            <div class="col-1">
                                ${employee.numberOfShares}
                            </div>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </div>
    </form>
</t:pageTemplate>