<%-- 
    Document   : user-form.jsp
    Created on : 24 May 2024, 00:15:03
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="usermanagement.web.UserServlet" %>
<%@page import="usermanagement.model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                <a href="https://www.w3schools.com/js/js_examples.asp" target="_blank" 
                   class="navbar-brand" style="margin-left: 10px">
                    User Management App</a>
                <a href="<%=request.getContextPath()%>/link" class="nav-link" style="color: white">
                    Users
                </a>
            </nav>
        </div>
        <div class="container">
            <div>
                <h3 class="text-center" style="margin-top: 20px ">                            
                List of User
                </h3> 
                <hr><!-- a line to break content -->
                <a class="btn btn-success" href="<%=request.getContextPath()%>/new">
                    Add New User
                </a>
            </div>
                    <br>        
            <div>        
                <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th><!-- comment -->
                        <th>Country</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${listUser}"> 
                        <tr>
                            <td>
                                <c:out value="${user.id}"/> 
                            </td>
                            <td>
                                <c:out value="${user.name}"/>
                            </td>
                            <td>
                                <c:out value="${user.email}"/>
                            </td>
                            <td>
                                <c:out value="${user.country}"/>
                            </td>
                            <td>
                                <a href="edit?id=<c:out value="${user.id}" />">Insert</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value="user.id"/>">Delete</a>                            
                            </td>
                        </tr>
                        </c:forEach>
                </tbody>
                </table>
            </div>
        </div>
            
    </body>
</html>
