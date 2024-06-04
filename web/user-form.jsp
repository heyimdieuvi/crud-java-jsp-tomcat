<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5 card">
                <div class="container">
                    <h2 class="text-center" style="margin-top: 10px">
                    <c:if test="${user != null}">
                        Edit User
                    </c:if>
                    <c:if test="${user == null}">
                        Add New User
                    </c:if>
                    </h2>
                        <c:if test="${user != null}">
                            <form action="update" method="post">
                                <input type="hidden" value="${user.id}" name="id">
                                <div class="form-group">
                                    <label class="h4">Name: </label>
                                    <input type="text" class="form-control" value="<c:out value="${user.name}"/>" name="name">
                                </div>
                                <div class="form-group">
                                    <label class="h4">Email: </label>
                                    <input type="text" class="form-control" value="<c:out value="${user.email}"/>" name="email">
                                </div>
                                <div class="form-group">
                                    <label class="h4">Country: </label>
                                    <input type="text" class="form-control" value="<c:out value="${user.email}"/>" name="country">
                                </div>
                                <button type="submit" class="btn btn-success">Save</button>
                            </form>
                        </c:if>
                    <c:if test="${user == null}">
                            <form action="insert" method="post">
                                <div class="form-group">
                                    <label class="h4">Name: </label>
                                    <input type="text" class="form-control" value="${param.name}" name="name">
                                </div>
                                <div class="form-group">
                                    <label class="h4">Email: </label>
                                    <input type="text" class="form-control" value="${param.name}" name="email">
                                </div>
                                <div class="form-group">
                                    <label class="h4">Country: </label>
                                    <input type="text" class="form-control" value="${param.name}" name="country">
                                </div>
                                <button type="submit" class="btn btn-success">Save</button>
                            </form>
                        </c:if>
                </div>
                
            </div>
                
        </body>

        </html>