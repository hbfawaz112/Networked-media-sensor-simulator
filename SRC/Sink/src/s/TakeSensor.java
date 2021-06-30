/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fcss
 */
public class TakeSensor extends UnicastRemoteObject implements ITakeSensor {
    
      File Sens;
    public TakeSensor() throws RemoteException { 
         Sens= new File("sens.txt");
         
    }
    
    @Override
    public void ReceiveSensor(Sensor S) throws RemoteException {
         System.out.println("Called from sensor to here in hte sink");
                System.out.println(S.toString());
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        System.out.println("This method is in the sink and called by a sensor");
        return a+b+a+b;
     }

    //s= id:pid:....
    @Override
    public void TakeData(String s) throws RemoteException {
                 System.out.println("Receving data from a sensor to sink : ");
                //System.out.println(s);
               
                int id = Integer.parseInt(s.split(":")[1]);
                int parentid = Integer.parseInt(s.split(":")[2]);
                String type=s.split(":")[3];
                String zone = s.split(":")[4];
                String status = s.split(":")[5];
                status="Registred-Ready";
                double required_data=Double.parseDouble(s.split(":")[6]);
         
              String savetotext=id+":"+parentid+":"+type+":"+zone+":"+status+":"+required_data+"\n";
              System.out.println("" + savetotext);
              File file = new File("sens.txt");
              FileWriter fr;
          try {
              fr = new FileWriter(file, true);
              fr.write(savetotext);
              fr.close();
          } catch (IOException ex) {
              Logger.getLogger(TakeSensor.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              ControlPanel cp = new ControlPanel();
          } catch (IOException ex) {
              Logger.getLogger(TakeSensor.class.getName()).log(Level.SEVERE, null, ex);
          }
         
                
           }
    
   
    
    
    
    
    
}
