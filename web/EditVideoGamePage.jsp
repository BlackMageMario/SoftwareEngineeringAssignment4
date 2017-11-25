<%-- 
    Document   : EditVideoGamePage
    Created on : 04-Nov-2017, 18:31:25
    Author     : Eamonn Hannon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit a Video Game</title>
    </head>
    <body>
        <h1>Edit the Video Game Record</h1>
        <form method="post" action="EditVideoGame">
            <table>
                <c:forEach var="videogame" begin="0" items="${videogameList}">
                    <c:if test="${videogame.getId() == param.id}">
                        <input type="hidden" name="id" value="${videogame.getId()}"/>
                        <tr>
                            <td>Game Name</td>
                            <td><input type="text" name="prodName" value="${videogame.getProdName()}"/></td>
                        </tr>
                        <tr>
                            <td>Publisher</td>
                            <td><input type="text" name="pubName" value="${videogame.getPubName()}"/></td>
                        </tr>
                        <tr>
                            <td>Developer</td>
                            <td><input type="text" name="devName" value="${videogame.getDevName()}"/></td>
                        </tr>
                        <tr>
                            <td>Release Date (Format: dd/MM/yyyy)</td>
                            <td><input type="text" name="releDate" value="${videogame.getReleDate()}"/></td>
                        </tr>
                        <tr>
                            <td>RR Price</td>
                            <td><input type="text" name="rrPrice" value="${videogame.getRrPrice()}"/></td>
                        </tr>
                        <tr>
                            <td>Platform</td>
                            <td><input type="text" name="platform" value="${videogame.getPlatform()}"/></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <input type="submit" id="EditVideoGame" value="EditVideoGame"/>
        </form>
    </body>
</html>
