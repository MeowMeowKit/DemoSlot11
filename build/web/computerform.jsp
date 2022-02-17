<%-- 
    Document   : computerform
    Created on : Feb 9, 2022, 10:09:09 AM
    Author     : LCCuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fu.ex.dtos.RoomDTO" %>
<%@page import="fu.ex.dtos.ComputerDTO" %>
<%@page import="fu.ex.dtos.ComputerErrorObject" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a new computer</title>
    </head>
    <body>
        <h1>ADD NEW COMPUTER INFORMATION</h1>
        <%
            ComputerDTO computerObj = (ComputerDTO) request.getAttribute("computerObj");
            ComputerErrorObject errObj = (ComputerErrorObject) request.getAttribute("INVALID");
        %>
        <form action="CreateServlet" method="POST">
            <table width="600px" border="0px solid">
                <tr>
                    <td>ID</td>
                    <td>: <input type="text" name="txtID" 
                                 value="<% if (computerObj != null) {
                                         out.print(computerObj.getId());
                                     } %>"/>
                        <font color="red">
                        <% if (errObj != null) {
                                out.print(errObj.getIdError());
                            }%>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>CPU</td>
                    <td>: <input type="text" name="txtCPU" 
                                 value="<% if (computerObj != null) {
                                         out.print(computerObj.getCpu());
                                     } %>" />
                        <font color="red">
                        <% if (errObj != null) {
                                out.print(errObj.getCpuError());
                            }%>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>Hard Disk</td>
                    <td>: <input type="text" name="txtHardDisk" 
                                 value="<% if (computerObj != null) {
                                         out.print(computerObj.getHardDisk());
                                     } %>" />
                        <font color="red">
                        <% if (errObj != null) {
                                out.print(errObj.getHardDiskError());
                            }%>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>RAM</td>
                    <td>: <input type="text" name="txtRAM" 
                                 value="<% if (computerObj != null) {
                                         out.print(computerObj.getRam());
                                     } %>" />
                        <font color="red">
                        <% if (errObj != null) {
                                out.print(errObj.getRamError());
                            }%>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>VGA</td>
                    <td>: <input type="text" name="txtVGA" 
                                 value="<% if (computerObj != null) {
                                         out.print(computerObj.getVga());
                                     } %>" />
                        <font color="red">
                        <% if (errObj != null) {
                                out.print(errObj.getVgaError());
                            }%>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>Monitor</td>
                    <td>: <input type="text" name="txtMonitor" 
                                 value="<% if (computerObj != null) {
                                         out.print(computerObj.getMonitor());
                                     } %>" />
                        <font color="red">
                        <% if (errObj != null) {
                                out.print(errObj.getMonitorError());
                            }%>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>Room</td>
                    <td>: <select name="cboRoom">
                            <%
                                ArrayList<RoomDTO> lstRooms = new ArrayList<RoomDTO>();

                                lstRooms = (ArrayList<RoomDTO>) request.getAttribute("listRooms");
                                if (lstRooms != null) {
                                    for (RoomDTO dt : lstRooms) {%>
                            <option><%=dt.getId()%>-<%=dt.getName()%></option>
                            <%  }
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Create"></td>
                </tr>
            </table>
        </form>
        <br /> <a href="LoadListComputerServlet">Computer List</a>
    </body>
</html>
