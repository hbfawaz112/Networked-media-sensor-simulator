/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author fcss
 */
public class Supervisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException, IOException {
                System.out.println("The Supervisor has lunch");
                
                System.out.println("The control panel will be show up when a new sensor is registred");
        ServerSocket welcome = new ServerSocket(1234);
       
        
       
           //ControlPanel CP = new ControlPanel();
           
       while(true){
           Socket ss = welcome.accept();
           System.out.println("Connectio accepted");
            //ControlPanel CP1 = new ControlPanel("stop");
        
           HandleRequestRegister HR = new HandleRequestRegister(ss);
           
           HR.start();
       }
      

    }
    
}
