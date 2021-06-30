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
public class Humidity {
    
   private int id;
   private String ZoneName;
   private double humidity;

    public Humidity(int id, String ZoneName, double humidity) {
        this.id = id;
        this.ZoneName = ZoneName;
        this.humidity = humidity;
    }

    public int getId() {
        return id;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZoneName(String ZoneName) {
        this.ZoneName = ZoneName;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "Humidity{" + "id=" + id + ", ZoneName=" + ZoneName + ", humidity=" + humidity + '}';
    }
    
    
    
}
