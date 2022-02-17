/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.ex.servlets;

import fu.ex.daos.ComputerDAO;
import fu.ex.dtos.ComputerDTO;
import fu.ex.dtos.ComputerErrorObject;
import fu.ex.dtos.RoomDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LCCuong
 */
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {

    private static final String SUCCESS = "LoadListComputerServlet";
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "CreateFormServlet";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = ERROR;       
        try {
            String id = request.getParameter("txtID");
            String cpu = request.getParameter("txtCPU");
            String hardDisk = request.getParameter("txtHardDisk");
            String ram = request.getParameter("txtRAM");
            String vga = request.getParameter("txtVGA");
            String monitor = request.getParameter("txtMonitor");
            String room = request.getParameter("cboRoom");
            
            boolean valid = true;
            ComputerErrorObject errorObj = new ComputerErrorObject();
            if(id.trim().isEmpty()){
                errorObj.setIdError("ID is not suppose to be empty");
                valid = false;
            }
            if(!id.trim().isEmpty() && !id.matches("[0-9]{2}")){
                errorObj.setIdError("Computer ID must be numerical, 2digits");
                valid = false;
            }
            if(cpu.trim().isEmpty()){
                errorObj.setCpuError("CPU is not suppose to be empty");
                valid = false;
            }
            if(!cpu.trim().isEmpty() && cpu.length() < 6){
                errorObj.setCpuError("CPU information of computer is greater than 6 characters");
                valid = false;
            }
            if(vga.trim().isEmpty()){
                errorObj.setVgaError("VGA is not suppose to be empty");
                valid = false;
            }
            if(ram.trim().isEmpty()){
                errorObj.setRamError("Ram is not suppose to be empty");
                valid = false;
            }
            if(hardDisk.trim().isEmpty()){
                errorObj.setHardDiskError("Hard disk is not suppose to be empty");
                valid = false;
            }
            if(monitor.trim().isEmpty()){
                errorObj.setMonitorError("Monitor is not suppose to be empty");
                valid = false;
            }
            ComputerDAO dao = new ComputerDAO();
            if(dao.getComputerByID(id) != null){
                errorObj.setIdError("ID is existed");
                valid = false;
            }
            RoomDTO roomToDB = new RoomDTO(room.split("-")[0].trim(), room.split("-")[1].trim(), "", 0);
            
            ComputerDTO computerObj = new ComputerDTO(id, cpu, hardDisk, ram, vga, monitor, roomToDB);
            
            if(valid){
                if(dao.insert(computerObj)){
                    url = SUCCESS;
                }else{
                    request.setAttribute("errMessage", "Insert failed");
                }
            }else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
                request.setAttribute("computerObj", computerObj);
            }
        } catch (Exception e) {
            log("ERROR at CreateServlet: " + e.getMessage());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
