<%-- 
    Document   : CreateVideoGamePage
    Created on : 02-Nov-2017, 13:16:12
    Author     : Eamonn Hannon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Video Game</title>
    </head>
    <body>
        <h1>Create a Video Game record</h1>
        <form action="CreateVideoGame" method ="post">
            <table>
                <tr>
                    <td>Game Name</td>
                    <td><input type="text" id="prodName" name="prodName"/></td>
                </tr>
                <tr>
                    <td>Publisher</td>
                    <td><input type="text" id="pubName" name="pubName"/></td>
                </tr>
                <tr>
                    <td>Developer</td>
                    <td><input type="text" id="devName" name="devName"/></td>
                </tr>
                <tr>
                    <td>Release Date (Format: dd/MM/yyyy)</td>
                    <td><input type="text" id="releDate" name="releDate"/></td>
                </tr>
                <tr>
                    <td>RR Price</td>
                    <td><input type="number" id="rrPrice" name="rrPrice"/></td>
                </tr>
                <tr>
                    <td>Platform</td>
                    <td><input type="text" id="platform" name="platform"/></td>
                </tr>
            </table>
            <input type="submit" id="CreateGame" value="CreateGame"/>
        </form>
    </body>
</html>
