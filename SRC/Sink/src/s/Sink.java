/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author fcss
 */
public class Sink {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, IOException, NotBoundException {
       
        Registry reg1 = LocateRegistry.createRegistry(1097);
       Configure C = new Configure();
       reg1.rebind("CONF", C);
       Registry reg = LocateRegistry.createRegistry(1098);
       
       TakeSensor TS  = new TakeSensor();
       reg.rebind("TS", TS);

        System.out.println("Sink is lunching ,waiting to get sensors.....");
        System.out.println("The control panel will shows when a new sensor is registred");
       
        
      
    
       //ControlPanel Cp = new ControlPanel();
    }
    
}
