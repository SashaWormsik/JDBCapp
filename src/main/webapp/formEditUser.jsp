<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.sashaworms.pvt.service.User" %>
<%@ page import="java.util.Date" %>


<html>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="User" scope="request"
       value="${requestScope.user}"/>

<%
    Date userBirth = ((User) request.getAttribute("User")).getBirthdate();
    String birthdate = new SimpleDateFormat("yyyy-MM-dd").format(userBirth);
%>

<form action="userEdit?number=${User.idUser}" method="POST">

    First Name: <input type="text" name="firstName"
                       value="${User.firstName}"/>
    <br/>
    Last Name: <input type="text" name="lastName"
                      value="${User.lastName}"/>
    <br/>
    BirthDate: <input type="text" name="birthdate"
                      value="<%= birthdate %>"/>
    <br/>
    <c:choose>
        <c:when test="${User.male}">
            <input type="radio" id="male" name="male" value="true" checked/> <label for="male">Male</label><br>
            <input type="radio" id="female" name="male" value="false"/> <label for="female">Female</label><br>
        </c:when>
        <c:otherwise>
            <input type="radio" id="male" name="male" value="true"/> <label for="male">Male</label><br>
            <input type="radio" id="female" name="male" value="false" checked/> <label for="female">Female</label><br>
        </c:otherwise>
    </c:choose>
    Department: <input type="text" name="department"
                       value="${User.department.depName}" list="department"/>
    <datalist id="department">
        <c:forEach var="dept" items="${requestScope.department}">
            <option>${dept.depName}</option>
        </c:forEach>
    </datalist>
    <br/>
    Salary: <input type="text" name="salary"
                   value="${User.salary}"/>
    <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
