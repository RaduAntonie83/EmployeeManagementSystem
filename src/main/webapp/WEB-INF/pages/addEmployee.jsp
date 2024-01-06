<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddEmployee">
    <h1>Add Employee</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddEmployee">
    <style>
        .form-container {
            background: rgba(255, 255, 255, 0.2); /* Adjust the alpha value for transparency */
            padding: 20px;
            width: 30%;
            border-radius: 10px;
            backdrop-filter: blur(10px); /* Adjust the blur value */
        }
    </style>

    <div class="form-container">
            <div class="row">
                <div class="col-md-10 mb-3">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Name is required.
                    </div>
                </div>
            </div>

                <div class="row">
                    <div class="col-md-10 mb-3">
                        <label for="email">E-mail</label>
                        <input type="text" class="form-control" id="email" name="email" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            E-mail is required.
                        </div>
                    </div>
                </div>

            <div class="row">
                <div class="col-md-10 mb-3">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Address is required.
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-10 mb-3">
                    <label for="salary">Salary</label>
                    <input type="text" class="form-control" id="salary" name="salary" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Salary is required.
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-5 mb-3">
                    <label for="class">Class</label>
                    <input type="text" class="form-control" id="class" name="class" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Class is required.
                    </div>
                </div>

                <div class="col-md-5 mb-3">
                    <label for="Hours">Hours</label>
                    <input type="text" class="form-control" id="hours" name="hours" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Hours are required.
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-5 mb-3">
                    <label for="birthdate">Birthdate</label>
                    <input type="date" class="form-control" id="birthdate" name="birthdate" required>
                    <div class="invalid-feedback">
                        Birthdate is required.
                    </div>
                </div>

                <div class="col-md-5 mb-3">
                    <label for="gender">Gender</label>
                    <select class="form-control" id="gender" name="gender" required>
                        <option value="" selected disabled>Select </option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select>
                    <div class="invalid-feedback">
                        Gender is required.
                    </div>
                </div>
            </div>

            <div class="row text-center">
                <div class="col-md-6 mb-3 mx-auto">
                    <button type="submit" class="btn btn-primary">+ Add<i class="fas fa-plus"></i></button>
                </div>
            </div>
            <img src="https://www.pockethrms.com/wp-content/uploads/2022/01/Happy-Workforce.jpg" alt="welcome" style="margin-left: 500px; margin-top: -550px; width:800px; border-radius: 10px;">
    </div>
    </form>
</t:pageTemplate>


