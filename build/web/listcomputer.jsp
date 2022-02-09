<%-- 
    Document   : listcomputer
    Created on : Feb 9, 2022, 10:08:55 AM
    Author     : LCCuong
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fu.ex.dtos.ComputerDTO" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Computer</title>
    </head>
    <body>
        <h1>Computer Management</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>CPU</th>
                    <th>VGA</th>
                    <th>HardDisk</th>
                    <th>RAM</th>
                    <th>Monitor</th>
                    <th>Room</th>
                    <!--<th>Tools</th>-->
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<ComputerDTO> lstComputers = new ArrayList<ComputerDTO>();
                    lstComputers = (ArrayList<ComputerDTO>) request.getAttribute("listComputers");
                    if (lstComputers != null) {
                        for (ComputerDTO dt : lstComputers) {%>
                            <tr>
                                <td><%=dt.getId()%></td>
                                <td><%=dt.getCpu()%></td>
                                <td><%=dt.getVga()%></td>
                                <td><%=dt.getHardDisk()%></td>
                                <td><%=dt.getRam()%></td>
                                <td><%=dt.getMonitor()%></td>

                                <td><%=dt.getRoom().getName()%> - <%=dt.getRoom().getBuilding()%></td>
                                <td> Edit </td>
                                <td>Delete</a></td>
                            </tr>
                    <% }
                    } else {

                    }%>
            </tbody>
        </table>
    </body>
</html>
