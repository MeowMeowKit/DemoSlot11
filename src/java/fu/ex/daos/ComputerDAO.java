/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.ex.daos;

import fu.ex.dtos.ComputerDTO;
import fu.ex.dtos.RoomDTO;
import fu.ex.utils.RepoConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author LCCuong
 */
public class ComputerDAO {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public ComputerDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<ComputerDTO> getAllComputers() throws Exception {
        List<ComputerDTO> result = null;
        try {
            String sql = "SELECT ComputerID, CPU, HardDisk, RAM, VGA, Monitor, RoomID\n"
                    + "FROM ComputerTBL\n";
            RepoConnector repo = new RepoConnector();
            conn = repo.connectDatabase();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("ComputerID");
                String cpu = rs.getString("CPU");
                String hardDisk = rs.getString("HardDisk");
                String ram = rs.getString("RAM");
                String vga = rs.getString("VGA");
                String monitor = rs.getString("Monitor");
                String roomID = rs.getString("RoomID");
                RoomDAO dao = new RoomDAO();
                RoomDTO room = dao.getRoomByID(roomID);
                ComputerDTO com = new ComputerDTO(id, cpu, hardDisk, ram, vga, monitor, room);
                result.add(com);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "DELETE FRORM ComputerTBL\n"
                    + "WHERE ComputerID=?";
            RepoConnector repo = new RepoConnector();
            conn = repo.connectDatabase();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(ComputerDTO computer) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into ComputerTBL(ComputerID, CPU, HardDisk, RAM, VGA, Monitor, RoomID)\n"
                    + "Values(?,?,?,?,?,?,?)";
            RepoConnector repo = new RepoConnector();
            conn = repo.connectDatabase();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, computer.getId());
            preStm.setString(2, computer.getCpu());
            preStm.setString(3, computer.getHardDisk());
            preStm.setString(4, computer.getRam());
            preStm.setString(5, computer.getVga());
            preStm.setString(6, computer.getMonitor());
            preStm.setString(7, computer.getRoom().getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public ComputerDTO getComputerByID(String id) throws Exception {
        ComputerDTO result = null;
        try {
            String sql = "SELECT ComputerID, CPU, HardDisk, RAM, VGA, Monitor, RoomID\n"
                    + "FROM ComputerTBL\n"
                    + "WHERE ComputerID=?\n";
            RepoConnector repo = new RepoConnector();
            conn = repo.connectDatabase();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String cpu = rs.getString("CPU");
                String hardDisk = rs.getString("HardDisk");
                String ram = rs.getString("RAM");
                String vga = rs.getString("VGA");
                String monitor = rs.getString("Monitor");
                String roomID = rs.getString("RoomID");
                RoomDAO dao = new RoomDAO();
                RoomDTO room = dao.getRoomByID(roomID);
                result = new ComputerDTO(id, cpu, hardDisk, ram, vga, monitor, room);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteComputer(String cid) throws Exception {
        try {
            String sql = "DELETE FROM ComputerTBL WHERE ComputerID=?";
            RepoConnector repo = new RepoConnector();
            conn = repo.connectDatabase();
            preStm = conn.prepareStatement(sql);
            System.out.println(cid);
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, cid);
                preStm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}
