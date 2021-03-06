/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.ex.dtos;

/**
 *
 * @author LCCuong
 */
public class ComputerDTO {
    private String id, cpu, hardDisk, ram, vga, monitor;
    private RoomDTO room;

    public ComputerDTO() {
    }

    public ComputerDTO(String id, String cpu, String hardDisk, String ram, String vga, String monitor, RoomDTO room) {
        this.id = id;
        this.cpu = cpu;
        this.hardDisk = hardDisk;
        this.ram = ram;
        this.vga = vga;
        this.monitor = monitor;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }
    
    
}
