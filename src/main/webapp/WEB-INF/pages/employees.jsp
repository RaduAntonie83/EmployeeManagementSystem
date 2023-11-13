<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="Employees">
    <h1>Employees</h1>
    <div class = "container text-center">
        <div class="row">
            <div class="col">
                Employee 1
            </div>
            <div class="col">
                Salary 1
            </div>
            <div class="col">
                Class 1
            </div>
        </div>
        <div class="row">
            <div class="col">
                Employee 2
            </div>
            <div class="col">
                Salary 2
            </div>
            <div class="col">
                Class 2
            </div>
        </div>
    </div>
    <h5>Number of employees: ${numberOfEmployees}</h5>
</t:pageTemplate>

