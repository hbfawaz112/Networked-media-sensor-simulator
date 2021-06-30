/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.util.ArrayList;

/**
 *
 * @author fcss
 */
public class Database {
    
  public static ArrayList<Temperature> Temps;
    public static ArrayList<Humidity> Hums;
    
    
    public Database(){
    
            Temps = new ArrayList<Temperature>();
            Temps.add(new Temperature(1,"ZoneA",30));
            Temps.add(new Temperature(2,"ZoneB",20));
            Temps.add(new Temperature(3,"ZoneC",17));
            Temps.add(new Temperature(4,"ZoneD",40));
            
            
            Hums = new ArrayList<Humidity>();
            Hums.add(new Humidity(1,"ZoneA",45));
            Hums.add(new Humidity(2,"ZoneB",80));
            Hums.add(new Humidity(3,"ZoneC",79));
            Hums.add(new Humidity(4,"ZoneD",15));
            
            
            
            
            
    }
    
    
    
    
}
