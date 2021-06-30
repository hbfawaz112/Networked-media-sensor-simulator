/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class Configure extends UnicastRemoteObject implements IConfigure{
      Vector<Sensor> SV;
      
      int idd;int parentid;
      String type,zone;
      String statuss;
      double required_data;
      String stowrite;
      
    public Configure()throws RemoteException {
        
    }
    @Override
    public int add(int a, int b) throws RemoteException {
    return a+b;
    
    }

    @Override
    public String getList() throws RemoteException {
        String s="";
       
        
        FileReader fr=null;
        try {
            File file=new File("sens.txt");    //creates a new file instance  
            fr = new FileReader(file); //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
                s+=line+"Done";
            }
    }     catch (FileNotFoundException ex) {
              Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
          }
        return s;}

    public void emptyfile() throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("sens.txt");
                    writer.print("");
                    writer.close();
    }
    @Override
    public void updateStatud(int id, String status) throws RemoteException {
        FileReader fr=null;
        FileWriter frrr = null;
         File file=new File("sens.txt");
          try {
              frrr = new FileWriter(file, true);
          } catch (IOException ex) {
              Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              SV = new Vector<Sensor>();
              System.out.println("***************UPDATING A SENSOR (COMMAND FROM SUPERVISOR)");
              System.out.println("Update a status of " + id + " new is " + status);
              
                 //creates a new file instance  
              fr = new FileReader(file); //reads the file
              BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
              StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
              String line;
              while((line=br.readLine())!=null)
              {
                  sb.append(line);      //appends line to string buffer
                  sb.append("\n");     //line feed
                  //System.out.println("Sens : " + line);
                  idd = Integer.parseInt(line.split(":")[0]);
                  parentid = Integer.parseInt(line.split(":")[1]);
                  required_data = Double.parseDouble(line.split(":")[5]);
                  type=line.split(":")[2];
                  zone = line.split(":")[3];
                  statuss = line.split(":")[4];
                  
                  Sensor Sen = new Sensor(idd,parentid,type,zone,statuss,required_data);
                  SV.add(Sen);
                  
                  System.out.println("Calling this method rmi size : " +SV.size());
              }    
            //emptyfile();
            for(int j=0;j<SV.size();j++){
                if(SV.get(j).getId()==id){
                    System.out.println("Updating Sensor : " +SV.get(j).toString() );
                    SV.get(j).setStatus(status);
                    System.out.println("Updating Sensor new status : " +SV.get(j).toString() );
                    
                }
            }
            emptyfile();
           
            for(int k=0;k<SV.size();k++){
               // System.out.println("SV UPDATEDDD ");
               // System.out.println(SV.get(k).toString());
                int iddd = SV.get(k).getId();
                int parentiddd= SV.get(k).getParentid();
                String typeee=SV.get(k).getRequest_type();
                String zoneee= SV.get(k).getZone();
                String statusss = SV.get(k).getStatus();
                double dataaa = SV.get(k).getRequired_data();
                
               stowrite=iddd+":"+parentiddd+":"+typeee+":"+zoneee+":"+statusss+":"+dataaa+"\n";
              System.out.println("To write " +stowrite);
               
              frrr.write(stowrite);
                frrr.flush();
              
            }
            
            
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
              try {
                  
                  frrr.close();
                  // return 1;
              } catch (IOException ex) {
                  Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
         ThreadCP thcp = new ThreadCP(); 
          thcp.start();
    }

    
}
