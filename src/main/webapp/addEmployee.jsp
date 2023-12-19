<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="Add Employee">
    <h1>Add an Employee</h1>
    <style>
        body {
            background: cornflowerblue fixed center no-repeat;
        }

        .form-container {
        background: rgba(255, 255, 255, 0.2); /* Adjust the alpha value for transparency */
        padding: 20px;
            width: 30%;
            border-radius: 10px;
        backdrop-filter: blur(10px); /* Adjust the blur value */
        }
    </style>
    <div class="form-container">
    <form action="AddEmployee" method="post" class="mt-3">

        <label>Name:</label>
        <input type="text" name="name" required><br>

        <label>Address:</label>
        <input type="text" name="address" required><br>

        <label>Salary:</label>
        <input type="number" name="salary" required><br>

        <label>Class:</label>
        <input type="text" name="employeeClass" required><br>

        <label>Hours:</label>
        <input type="number" name="hours" required><br>

        <label>Gender:</label>
        <select name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select><br>

        <label>Birthdate:</label>
        <input type="date" name="birthdate" required><br>

        <input type="submit" value="Add Employee">

    </form>
    </div>
</t:pageTemplate>

