<%-- 
    Document   : ListVideoGamePage
    Created on : 01-Nov-2017, 17:30:37
    Author     : Eamonn Hannon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Video Games</title>
    </head>
    <body>
        <h1>List of Video Games currently in Database</h1>
        <table id="videoGameTable">
            <tr>
                <td>ID</td>
                <td>Product Name</td>
                <td>Publisher</td>
                <td>Developer</td>
                <td>Release Date</td>
                <td>RR Price</td>
                <td>Platform</td>
            </tr>
            <c:forEach var="videogame" begin="0" items="${requestScope.videogamesList}">
            <tr>
                <td>${videogame.getID()}</td>
                <td>${videogame.getProdName()}</td>
                <td>${videogame.getPubName()}</td>
                <td>${videogame.getDevName()}</td>
                <td>${videogame.getReleDate()}</td>
                <td>${videogame.getRrPrice()}</td>
                <td>${videogame.getPlatform()}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
