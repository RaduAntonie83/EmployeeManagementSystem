<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<t:pageTemplate pageTitle="EditEmployee">
    <br>
    <h1 class="text-white display-10 left">Edit Employee</h1>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditEmployee">
                    <div class="form-container">
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="name" class="text-white">Name</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="" value="${employee.name}"
                                       required>
                                <div class="invalid-feedback">
                                    Name is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="address" class="text-white">Address</label>
                                <input type="text" class="form-control" id="address" name="address" placeholder=""
                                       value="${employee.address}" required>
                                <div class="invalid-feedback">
                                    Address is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="email" class="text-white">E-mail</label>
                                <input type="text" class="form-control" id="email" name="email" placeholder="" value="${employee.email}"
                                       required>
                                <div class="invalid-feedback">
                                    E-mail is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="password" class="text-white">Password</label>
                                <input type="text" class="form-control" id="password" name="password" placeholder=""
                                       value="" >
                                <div class="invalid-feedback">
                                    Password is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="religion" class="text-white">Religion</label>
                                <input type="text" class="form-control" id="religion" name="religion" placeholder=""
                                       value="${employee.religion}" required>
                                <div class="invalid-feedback">
                                    Religion is required.
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="salary" class="text-white">Salary</label>
                                    <input type="text" class="form-control" id="salary" name="salary" placeholder=""
                                           value="${employee.salary}" required>
                                    <div class="invalid-feedback">
                                        Salary is required.
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="workinghours" class="text-white">Working Hours</label>
                                    <input type="text" class="form-control" id="workinghours" name="workinghours" placeholder=""
                                           value="${employee.workingHours}" required>
                                    <div class="invalid-feedback">
                                        Working Hours are required.
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="dateofbirth" class="text-white">Date of Birth</label>
                                    <input type="date" class="form-control" id="dateofbirth" name="dateofbirth"
                                    value="${fn:escapeXml(employee.dateOfBirth)}" required>
                                    <div class="invalid-feedback">
                                        Date of Birth is required.
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="gender" class="text-white">Gender</label>
                                    <select class="form-control" id="gender" name="gender" required>
                                        <option value="" selected disabled>Select</option>
                                        <option value="male" ${employee.gender eq 'male' ? 'selected' : ''}>Male</option>
                                        <option value="female" ${employee.gender eq 'female' ? 'selected' : ''}>Female</option>
                                        <option value="other" ${employee.gender eq 'other' ? 'selected' : ''}>Other</option>
                                    </select>
                                    <div class="invalid-feedback">
                                        Gender is required.
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr class="my-4">
                        <input type="hidden" name="employee_id" value="${employee.id}" />
                        <div class="row text-center">
                            <div class="col-md-6 mb-3 mx-auto">
                                <button type="submit" class="btn btn-primary">+ Add<i class="fas fa-plus"></i></button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-6 d-flex align-items-center justify-content-left">
                <img src="https://img.freepik.com/premium-vector/recruitment-concept-idea-employment-human_277904-2607.jpg" alt="welcome"
                     class="img-fluid" style="border-radius: 10px;">
            </div>
        </div>
    </div>
</t:pageTemplate>


