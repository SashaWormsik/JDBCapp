<%@page import="org.sashaworms.pvt.service.Department" %>

<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<br/>


<c:if test="${requestScope.department != null}">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Num</th>
            <th scope="col">Department</th>
            <th scope="col">Actions</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <c:forEach var="dept" items="${requestScope.department}">
            <tr>
                <td scope="row">${dept.depId}</td>
                <td>${dept.depName}</td>
                <td><a class="btn btn-danger"
                       href="http://localhost:8080/JDBCapp/deptDelete?number=${dept.depId}">Delete</a></td>
                <td><a class="btn btn-danger"
                       href="http://localhost:8080/JDBCapp/deptEdit?deptName=${dept.depName}">Edit</a></td>
            </tr>

        </c:forEach>
    </table>
</c:if>

<a class="btn btn-primary"
   href="http://localhost:8080/JDBCapp/formDept.jsp">Add department</a>

</body>
</html>