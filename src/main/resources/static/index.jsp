<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST"
           action="/card-number" modelAttribute="cardRequestModel">
    <table>
        <tr>
            <td><form:label path="cardNumber">cardNumber</form:label></td>
            <td><form:input path="cardNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>