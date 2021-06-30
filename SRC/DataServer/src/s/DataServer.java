/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import static s.Database.Hums;
import static s.Database.Temps;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fcss
 */
public class DataServer {

    
     
    public static void main(String[] args) throws IOException {
                
        System.out.println("Data server is lucnching");
        System.out.println("Waiting for a request from a sensor");
        
            Database db = new Database();
        
       ArrayList<Temperature> Temps=db.Temps;

       
       ArrayList<Humidity> Hums = db.Hums;
           
           
        
        
       ServerSocket welcome = new ServerSocket(1111);
       while(true){
           Socket ss = welcome.accept();
           HandleRequestThread HQT = new HandleRequestThread(ss,Temps,Hums);
           HQT.start();
           
       }
       
    }
    
}
