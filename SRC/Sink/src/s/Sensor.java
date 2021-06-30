/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author fcss
 */
public class Sensor implements Serializable{
    
    int id;
    int parentid;
    String request_type;
    String zone;
    String status;
    double required_data;
    public Sensor(int id, int parentid, String request_type, String zone, String status) {
        this.id = id;
        this.parentid = parentid;
        this.request_type = request_type;
        this.zone = zone;
        this.status = status;
        
    }
    
    public Sensor(int id, int parentid, String request_type, String zone, String status , double required_data) {
        this.id = id;
        this.parentid = parentid;
        this.request_type = request_type;
        this.zone = zone;
        this.status = status;
        this.required_data=required_data;
        
    }

    public void setRequired_data(double required_data) {
        this.required_data = required_data;
    }

    public double getRequired_data() {
        return required_data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getParentid() {
        return parentid;
    }

    public String getRequest_type() {
        return request_type;
    }

    public String getZone() {
        return zone;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Sensor{" + "id=" + id + ", parentid=" + parentid + ", request_type=" + request_type + ", zone=" + zone + ", status=" + status + '}';
    }
    
    
    
}
