<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddEmployee">
    <br>
    <h1 class="text-white display-10 left">Add Employee</h1>
    <div class="container">
        <div class="row">

            <div class="col-md-6">
                <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddEmployee">
                    <div class="form-container">
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="name" style="color: white;">Name</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="" value=""
                                       required>
                                <div class="invalid-feedback">
                                    Name is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="address" style="color: white;">Address</label>
                                <input type="text" class="form-control" id="address" name="address" placeholder=""
                                       value="" required>
                                <div class="invalid-feedback">
                                    Address is required.
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="email" style="color: white;">E-mail</label>
                                <input type="text" class="form-control" id="email" name="email" placeholder="" value=""
                                       required>
                                <div class="invalid-feedback">
                                    E-mail is required.
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="password" style="color: white;">Password</label>
                                <input type="text" class="form-control" id="password" name="password" placeholder=""
                                       value="" required>
                                <div class="invalid-feedback">
                                    Password is required.
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="religion" style="color: white;">Religion</label>
                                <input type="text" class="form-control" id="religion" name="religion" placeholder=""
                                       value="" required>
                                <div class="invalid-feedback">
                                    Religion is required.
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="salary" style="color: white;">Salary</label>
                                    <input type="text" class="form-control" id="salary" name="salary" placeholder=""
                                           value="" required>
                                    <div class="invalid-feedback">
                                        Salary is required.
                                    </div>
                                </div>

                                <div class="col-md-6 mb-3">
                                    <label for="workinghours" style="color: white;">Working Hours</label>
                                    <input type="text" class="form-control" id="workinghours" name="workinghours"
                                           placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Working Hours are required.
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="dateofbirth" style="color: white;">Date of Birth</label>
                                    <input type="date" class="form-control" id="dateofbirth" name="dateofbirth"
                                           required>
                                    <div class="invalid-feedback">
                                        Date of Birth is required.
                                    </div>
                                </div>

                                <div class="col-md-6 mb-3">
                                    <label for="gender" style="color: white;">Gender</label>
                                    <select class="form-control" id="gender" name="gender" required>
                                        <option value="" selected disabled>Select</option>
                                        <option value="male">Male</option>
                                        <option value="female">Female</option>
                                        <option value="other">Other</option>
                                    </select>
                                    <div class="invalid-feedback">
                                        Gender is required.
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row text-center">
                            <div class="col-md-6 mb-3 mx-auto">
                                <button type="submit" class="btn btn-primary">+ Add<i class="fas fa-plus"></i></button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-6 d-flex align-items-center justify-content-left">
                <img src="https://www.pockethrms.com/wp-content/uploads/2022/01/Happy-Workforce.jpg" alt="welcome"
                     class="img-fluid" style="border-radius: 10px;">
            </div>
        </div>
    </div>
</t:pageTemplate>