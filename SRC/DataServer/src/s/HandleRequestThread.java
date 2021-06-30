/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fcss
 */
public class HandleRequestThread extends Thread{
    
    Socket s;
    
      Scanner input;
      PrintWriter out;
    ArrayList<Temperature> Temps;

       
       ArrayList<Humidity> Hums;
    
    
    
    public HandleRequestThread(Socket s , ArrayList<Temperature> Temps, ArrayList<Humidity> Hums) throws IOException {
        this.s = s;
        this.Temps=Temps;
        this.Hums=Hums;
         input = new Scanner(s.getInputStream());
         out = new PrintWriter(s.getOutputStream(),true);
        
    }
    
    
    public void run(){
        System.out.println("A New Sensor request data : Accepted Connection...");
            
        try {
                input = new Scanner(s.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(HandleRequestThread.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        try {
            out = new PrintWriter(s.getOutputStream(),true);
        } catch (IOException ex) {
            Logger.getLogger(HandleRequestThread.class.getName()).log(Level.SEVERE, null, ex);
        }
           String replied;
           String m = input.nextLine();
           String type = m.split(":")[1];
           String zone = m.split(":")[2];
           double tempss;double humss;
           double replidtemp=0.0;double repliedhum=0.0;
           
           if(type.equals("Temperature")){
               
               for(int i=0;i<Temps.size();i++){
                   String zonee=Temps.get(i).getZoneName();
                   
                   if(zonee.equals(zone)){
                       System.out.println("enter");
           
                       tempss = Temps.get(i).getTemperature();
                       replidtemp = tempss;
                       System.out.println("okiii"+replidtemp);
                       break;
                   }
                   else{
                    replidtemp=1.0;
                    
                   }
               }
               replied= "Temprature:"+zone+":"+replidtemp;
               
           }
           else if(type.equals("Humidity")){
               for(int i=0;i<Hums.size();i++){
                   String zonee=Hums.get(i).getZoneName();
                   
                   if(zonee.equals(zone)){
                       humss = Hums.get(i).getHumidity();
                       repliedhum = humss;
                       break;
                              
                   }
                   else{
                    repliedhum=0.0;
                    
                   }
               }
               replied= "Hummidity:"+zone+":"+repliedhum;
               
           }
           else{
               replied="You entred an invalied type of request";
           }
           
           
           out.println(replied);
        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(HandleRequestThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
