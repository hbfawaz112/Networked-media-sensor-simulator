/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fcss
 */
public class HandleRequestRegister extends Thread{
    Socket s;PrintWriter out;
  ArrayList<Integer> arr;
  
    Scanner input;
    
    boolean flag=false;
    String recive;
    
    Scanner in,in1;
    int id,parentid;
    String type,zone,status;
      OutputStream outputStream;
      ObjectOutputStream objectOutputStream;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
  
      
 public HandleRequestRegister(Socket s) throws IOException{
        
  this.s=s;
   in = new Scanner(s.getInputStream());
   out = new PrintWriter(s.getOutputStream(),true);
 
  // outputStream = s.getOutputStream();
  // objectOutputStream = new ObjectOutputStream(outputStream);

  }
    
  public void run(){
      String m = in.nextLine();
      if(m.equals("Register Me")){
         
              
          System.out.println("********************");
          System.out.println("A New Sensor want to Regsiter , enter his inpormation");
          System.out.println("Before start entring the information , ensure that the control panel in Sink is paused");
           System.out.println("");
          out.println("enter the sensor id: ");
          
          recive=in.nextLine().toString();
          System.out.println(recive);
          if(recive.equals("ok1")){
              out.println("Enter your parentID");
             
          }
          recive=in.nextLine().toString();
          if(recive.equals("ok2")){
           out.println("enter the sensor request type:");   
          }
           recive=in.nextLine().toString();
          if(recive.equals("ok3")){
           out.println("enter the sensor coverage zone");  
            System.out.println("the current status of this sensor is  : Registring.... ");
           
          }
           recive=in.nextLine().toString();
           if(recive.equals("ok4")){
            System.out.println("the current status of this sensor is  : Registring.... ");
           status = "Registring";
           out.println(status);
          }
           
          
          try {
              ControlPanel cpp = new ControlPanel();
          } catch (RemoteException ex) {
              Logger.getLogger(HandleRequestRegister.class.getName()).log(Level.SEVERE, null, ex);
          } catch (NotBoundException ex) {
              Logger.getLogger(HandleRequestRegister.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }
              }
}
