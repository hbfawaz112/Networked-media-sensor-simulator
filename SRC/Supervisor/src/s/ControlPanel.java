/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author fcss
 */
public class ControlPanel {
    String command;
      IConfigure IT,IT2;
    Vector<Sensor>SV;
    Vector<Sensor>SV1;String ok="ok";
    String[] sens;
    Scanner in;
    int sensid;
    ArrayList<Integer> arr ;
    int updateid;
    String updatestatus;
    Scanner in2,in3;
    boolean successupdate;
    String up;
    public ControlPanel(String s){
       
            in.close();
       
    }
    
    public ControlPanel() throws RemoteException, NotBoundException{
        
        in = new Scanner(System.in);
        in2 = new Scanner(System.in);
        in3 = new Scanner(System.in);
        
         Registry reg = LocateRegistry.getRegistry("127.0.0.1",1097);
        try{
         IT = (IConfigure)reg.lookup("CONF");}catch(Exception e){
             System.out.println("**********Registery not exist yet.. , Lunch Sink before*****");
             ok="not ok";
         }
        if(!ok.equals("not ok")){
            System.out.println("****************Lookup success ...********************");
        }
       
        
                
        
        System.out.println("SUPERVISOR CONTROL PANNEL :");
        
        System.out.println("ENTER YOUR COMMAND :");
        System.out.println(" 0 to prepare the supervisor for a new sensor..");
        System.out.println(" 1 to List all sensors registred in the sink ");
        System.out.println(" 2 to pause a sensor (ensure that the control panel in sink is disable)");
        System.out.println(" 3 to ready a sensor (ensure that the control panel in sink is disable)");
        
        System.out.println(" R to Reload panel for try lookup...");
       
        System.out.println(" Q to Quit ");
       command = in.nextLine();
       
       if(command.equals("0")){
            System.out.println("");
            
            System.out.println(" OK the control panel will bew disable , for preparing for a new command from a sensor or supervisor..");
            System.out.println("");
        
       }
       else if(command.equals("R")){
            System.out.println("Contro panel reloaded");
        
            ControlPanel cp = new ControlPanel();
       }
       else if(command.equals("Q")){
           System.exit(0);
       }
       else if(command.equals("1")){
           arr = new ArrayList<Integer>();
           System.out.println("*****************List Of Registred Sensor***************");
          String s = IT.getList();
         sens = s.split("Done");
         for(int i=0;i<sens.length;i++){
             System.out.println(sens[i]);
             
             sensid = Integer.parseInt(sens[i].split(":")[0]);
             System.out.println("sens id is " + sensid);
             
            
             
         }
         
         System.out.println("*****************************************");
         ControlPanel cc = new ControlPanel();
                 
       }
       else if(command.equals("2")){
           
           System.out.println("***********Updating a sensor status***********");
           System.out.println("Enter the sensor id your want to upate : ");
           updateid = in2.nextInt();
           System.out.println("Do you wanit to make the status of the sensor " + updateid +  " Pause ? ");
          System.out.println("yes/no");
           updatestatus = in3.nextLine();
           //call a methode take id and status
            if(updatestatus.equals("yes")){
                 IT2 = (IConfigure)reg.lookup("CONF");
         
                 System.out.println("....Updating....");
           
                System.out.println("Updating the status to Pause");
                  up="ok";
                IT2.updateStatud(updateid, "Pause");
                // System.out.println("PASSS2");
                 
                 //System.out.println("PASSS");
                 
                 ControlPanel CPPP =new ControlPanel();
                
                 
            }
            else if(updatestatus.equals("no")){
                 System.out.println("The current status of this sensor still Ready");
                
            }else{
                 System.out.println("wrong comand.....");
                ControlPanel Cp1 = new ControlPanel();
                
            }
           
       }
       
       else if(command.equals("3")){
           
           System.out.println("***********Updating a sensor status***********");
           System.out.println("Enter the sensor id your want to upate : ");
           updateid = in2.nextInt();
           System.out.println("Do you wanit to make the status of the sensor " + updateid +  " Registred And Ready ? ");
          System.out.println("yes/no");
           updatestatus = in3.nextLine();
           //call a methode take id and status
            if(updatestatus.equals("yes")){
                 IT2 = (IConfigure)reg.lookup("CONF");
         
                 System.out.println("....Updating....");
           
                System.out.println("Updating the status to register and ready");
                  up="ok";
                
                 // ControlPanel Cp1 = new ControlPanel();
                //System.out.println("PASSS 1");
                IT2.updateStatud(updateid, "Registred And Ready");
                 //System.out.println("PASSS2");
                 ControlPanel CPPP =new ControlPanel();
                 
                 
            }
            else if(updatestatus.equals("no")){
                 System.out.println("The current status of this sensor still Ready");
            ControlPanel Cp1 = new ControlPanel();
                    
            
            }else{
                 System.out.println("wrong comand.....");
                ControlPanel Cp1 = new ControlPanel();
                
            }
             
             
            
              

              
       
              
           
          
       }
       else{
           System.out.println("Wrong command");
           ControlPanel cp = new ControlPanel();
       }
        
    }
    
    
}
