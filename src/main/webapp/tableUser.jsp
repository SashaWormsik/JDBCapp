<%@page import="org.sashaworms.pvt.service.User" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<br/>


<c:if test="${requestScope.users != null}">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Num</th>
            <th scope="col">Firstname</th>
            <th scope="col">Lastname</th>
            <th scope="col">Birthdate</th>
            <th scope="col">Sex</th>
            <th scope="col">Department</th>
            <th scope="col">Salary</th>
            <th scope="col">Actions</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <c:forEach var="i" begin="1" end="${fn:length(requestScope.users)}">
            <c:set var="User" scope="request"
                   value="${requestScope.users[i-1]}"/>
            <tr>
                <td scope="row">${User.idUser}</td>
                <td>${User.firstName}</td>
                <td>${User.lastName}</td>
                <td>
                    <%
                        Date userBirth = ((User) request.getAttribute("User")).getBirthdate();
                        if (userBirth != null) {
                            out.println(new SimpleDateFormat("yyyy-MM-dd").format(userBirth));
                        }
                    %>
                </td>
                <td><c:choose>
                    <c:when test="${User.male}">Male</c:when>
                    <c:otherwise>Female</c:otherwise>
                </c:choose></td>
                <td>${User.department.depName}</td>
                <td>${User.salary}</td>
                <td><a class="btn btn-danger"
                       href="http://localhost:8080/JDBCapp/userDelete?number=${User.idUser}">Delete</a></td>
                <td><a class="btn btn-danger"
                       href="http://localhost:8080/JDBCapp/userEdit?number=${User.idUser}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a class="btn btn-primary"
   href="http://localhost:8080/JDBCapp/userAdd">Add user</a>
<br/>
</body>
</html>
