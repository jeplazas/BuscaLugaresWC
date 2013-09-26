<%-- 
    Document   : result
    Created on : 25/09/2013, 02:23:47 PM
    Author     : Julião
--%>

<%!    private String consulta = null;
    private String nombre = null;
    private String direccion = null;
    private String icono = null;
    private String numeroTelefonoF = null;
    private String numeroTelefonoI = null;
    private String vecindario = null;
    private String url = null;
    private String clasificacion = null;
    private String web = null;

%>

<%

    consulta = String.valueOf(session.getAttribute("query"));
    nombre = String.valueOf(session.getAttribute("name"));
    direccion = String.valueOf(session.getAttribute("formatted_Address"));
    icono = String.valueOf(session.getAttribute("icon"));
    numeroTelefonoF = String.valueOf(session.getAttribute("formatted_phone_number"));
    numeroTelefonoI = String.valueOf(session.getAttribute("international_phone_number"));
    vecindario = String.valueOf(session.getAttribute("vecinity"));
    url = String.valueOf(session.getAttribute("url"));
    clasificacion = String.valueOf(session.getAttribute("rating"));
    web = String.valueOf(session.getAttribute("webSite"));

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Place Details</title>
        <style type="text/css">
            html{
                background-image: url(resources/paradise3.jpg);
                font-family: cursive;
                font-style: italic;
                font-weight: bolder;
                font-size: larger;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Selected "<%= consulta%>"</h1>
        <table border="0" cellspacing="2" cellpadding="10" align="center">
            <tr>
                <td> Place's name: </td>
                <td> <%= nombre%> </td>
            </tr>
            <tr>
                <td> Place's formatted address: </td>
                <td> <%= direccion%> </td>
            </tr>
            <tr>
                <td> Place's icon: </td>
                <td> <img src="<%= icono%>" /> </td>
            </tr>
            <tr>
                <td> Place's formatted phone number: </td>
                <td> <%= numeroTelefonoF%> </td>
            </tr>
            <tr>
                <td> Place's international phone number: </td>
                <td> <%= numeroTelefonoI%> </td>
            </tr>
            <tr>
                <td> Place's vicinity: </td>
                <td> <%= vecindario%> </td>
            </tr>
            <tr>
                <td> Place's G+ url: </td>
                <% if (url != "~") {%>
                    <td> <a href="<%= url%>"> <%= nombre%> </a> </td>
                <% } else {%>
                    <td> <%= url%> </td>
                <% }%>
            </tr>
            <tr>
                <td> Place's rating: </td>
                <td> <%= clasificacion%> </td>
            </tr>
            <tr>
                <td> Place's webSite: </td>
                <% if (web != "~") {%>
                    <td> <a href="<%= web%>"> <%= nombre%> </a> </td>
                <% } else {%>
                    <td> <%= web%> </td>
                <% }%>
            </tr>
        </table>
    </center>
</body>
</html>
