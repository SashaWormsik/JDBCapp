<html>

<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<form action="userAdd" method="POST">
    First Name: <input type="text" name="firstName"/>
    <br/>
    Last Name: <input type="text" name="lastName"/>
    <br/>
    BirthDate: <input type="text" name="birthdate"/>
    <br/>
    <input type="radio" id="male" name="male" value="true"/>
    <label for="male">Male</label><br>
    <input type="radio" id="female" name="male" value="false"/>
    <label for="female">Female</label><br>
    Department: <input type="text" name="department" list = "department"/>
    <datalist id="department">
        <c:forEach var="dept" items="${requestScope.department}">
            <option>${dept.depName}</option>
        </c:forEach>
    </datalist>
    <br/>
    Salary: <input type="text" name="salary"/>
    <br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>

