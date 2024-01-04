<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 20.12.2023
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Login">
    <c:if test="${message !=null}">
        <div class="alert alert-warning" role="alert">
                ${message}
        </div>
    </c:if>

    <section class="vh-100">
        <div class="container py-5 h-100">
            <div class="row d-flex align-items-center justify-content-center h-100">
                <div class="col-md-8 col-lg-7 col-xl-6">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
                         class="img-fluid" alt="Phone image">
                </div>
                <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                    <h1 style="color: white;">Login</h1>
                    <br>
                    <form>

                        <div class="form-outline mb-4">
                            <input type="email" id="emailAddress" class="form-control form-control-lg" />
                            <label style="color: white;" class="form-label" for="emailAddress">Email address</label>
                        </div>


                        <div class="form-outline mb-4">
                            <input type="password" id="password" class="form-control form-control-lg" />
                            <label style="color: white;" class="form-label" for="password">Password</label>
                        </div>

                        <div class="d-flex justify-content-around align-items-center mb-4">

                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="rememberMe" checked />
                                <label style="color: white;" class="form-check-label" for="rememberMe"> Remember me </label>
                            </div>
                            <a href="#!">Forgot password?</a>
                        </div>


                        <button type="submit" class="btn btn-primary btn-lg btn-block" style="color: white;">Sign in</button>



                    </form>
                </div>
            </div>
        </div>
    </section>
</t:pageTemplate>
