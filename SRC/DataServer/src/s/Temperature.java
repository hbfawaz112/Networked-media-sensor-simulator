/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

/**
 *
 * @author fcss
 */
public class Temperature {
    
     private int id;
      private String zonename;
      private double temperature;

    public Temperature(int id, String zonename, double temperature) {
        this.id = id;
        this.zonename = zonename;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public String getZoneName() {
        return zonename;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZoneName(String zonename) {
        this.zonename = zonename;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Temperature{" + "id=" + id + ", zonename=" + zonename + ", temperature=" + temperature + '}';
    }

    
    
    
}
