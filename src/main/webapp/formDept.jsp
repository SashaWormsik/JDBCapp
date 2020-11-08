<html>

<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="dept" scope="request"
       value="${requestScope.dept}"/>

<c:choose>
    <c:when test="${dept == null}">
        <form action="deptAdd" method="POST">
            Department : <input type="text" name="department"/>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
    </c:when>
    <c:otherwise>
        <form action="deptEdit?number=${dept.depId}" method="POST">
            Department : <input type="text" name="department" value="${dept.depName}"/>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
