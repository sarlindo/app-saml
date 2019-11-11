<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Keycloak Example App</title>

        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </head>
    <body>
        <jsp:useBean id="controller" class="ca.cds.keycloaksaml.Controller" scope="request"/>
        
        <c:set var="isLoggedIn" value="<%=controller.isLoggedIn(request)%>"/>
        <c:if test="${isLoggedIn}">
            <c:redirect url="profile.jsp"/>
        </c:if>

        <div class="wrapper" id="welcome">
            <div class="menu">
                <button name="loginBtn" onclick="location.href = 'profile.jsp'" type="button">Login</button>
            </div>

            <div class="content">
                <div class="message">Please login</div>
            </div>
        </div>
    </body>
</html>
