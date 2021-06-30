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
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fcss
 */
public class ControlPanel {
    

    Scanner in,in1;Vector<Sensor> SV;
    int id,parentid;
    String type,zone,status;
    double required_data;
    String command;
  
    String ok;
    public ControlPanel() throws IOException{
        in = new Scanner(System.in);
        in1 = new Scanner(System.in);
        
        SV=new Vector<Sensor>();
     System.out.println("Control Panel");
        System.out.println("Enter 0 To pause the control panel and waiting for a new command ");
        
        System.out.println("Enter 1 List All Sensor");
         System.out.println("Enter 2 Get A Specific data (Temperature or humuidte) for a specific zone");
         System.out.println("Enter Q To Exit the sink");
         command = in.nextLine();
        if(command.equals("1")){
            
            getSens();
            System.out.println("");
            
            System.out.println("********************List of all regustred sensor*****************");
            for(int j=0;j<SV.size();j++){
                System.out.println(SV.get(j).toString());
            }
             System.out.println("*****************************************************************");
           
            ControlPanel CPP = new ControlPanel();
            System.out.println("");
            
            
            
        }
        else if(command.equals("0")){
            System.out.println("");
            
            System.out.println(" OK, the control panel will bew disable , for preparing for a new sensor to come");
            System.out.println("");
        
        }
        else if(command.equals("Q")){
            
           PrintWriter writer = new PrintWriter("sens.txt");
                    writer.print("");
                    writer.close();
                    System.exit(0);
           
        }
        
        else if(command.equals("2")){
            getSens();
            System.out.println("");
            
            System.out.println("A new Capture is Preparing.... ");
        
        System.out.println("Enter your request type : ");
        
       String intype = in.nextLine();
         System.out.println(intype);
         
        System.out.println("Enter your request coverage zone : ");
        
        String inzone = in1.nextLine();
        System.out.println(inzone);
         
           //System.out.println("In threadd : length of vector is" + this.SV.size());
             System.out.println("***Start searching with the midlle level sensors****");
            for(int i=0;i<SV.size();i++){
                if(SV.get(i).getParentid()==0 && SV.get(i).getZone().equals(inzone) 
                        && SV.get(i).getRequest_type().equals(intype) && !SV.get(i).getStatus().equals("Pause"))
                {
                    ok="ok";
                    System.out.println("The sensor  responsable to this capabilities is a sensor in a midlle level: ");
                    System.out.println(SV.get(i).toString());//get data
                    System.out.println("*********Required Data is :" + intype + ":" + inzone + ":" + SV.get(i).getRequired_data()+" *********");
                    System.out.println("");
                break;
                }
                else if(i==SV.size()-1){
                    System.out.println("Any of the sensor of middle level(parent is sink) has these capabilities");
                    ok="not ok";
                }
               
            }
            if(!ok.equals("ok")){
                System.out.println("Start searching on the base level");
                for(int i=0;i<SV.size();i++){
                if(SV.get(i).getParentid()!=0 && SV.get(i).getZone().equals(inzone) 
                        && SV.get(i).getRequest_type().equals(intype) && !SV.get(i).getStatus().equals("Pause"))
                {
                    
                    System.out.println("The sensor  responsable to this capabilities is a sensor in a midlle level: ");
                    System.out.println(SV.get(i).toString());////get data
                    System.out.println("*********Required Data is : **********" + intype + ":" + inzone + ":" + SV.get(i).getRequired_data()+" *********");
                    
                break;
                }
                else if(i==SV.size()-1){
                    System.out.println("Any of the sensor of middle level or base level has these capabilities");
                }
                
                
            }
            }
      
              System.out.println("*************");
              
           ControlPanel CPP = new ControlPanel(); 
        }
        
        else{
        System.out.println("");
            
            System.out.println("Wrong Command, enter w correct one");
            ControlPanel CPP = new ControlPanel();
            System.out.println("");
            
        }
    }
    
    public void getSens() throws FileNotFoundException, IOException{
        
      File file=new File("sens.txt");    //creates a new file instance  
      System.out.println("GETTING SENOSRS....");
      FileReader fr=new FileReader(file);   //reads the file  
        
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
        StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
        String line;  
        while((line=br.readLine())!=null)  
        {  
        sb.append(line);      //appends line to string buffer  
        sb.append("\n");     //line feed   
        //System.out.println("Sens : " + line);
                   id = Integer.parseInt(line.split(":")[0]);
                 parentid = Integer.parseInt(line.split(":")[1]);
                 required_data = Double.parseDouble(line.split(":")[5]);
                 type=line.split(":")[2];
                 zone = line.split(":")[3];
                 status = line.split(":")[4];
                 Sensor Sen = new Sensor(id,parentid,type,zone,status,required_data);
                 SV.add(Sen);
          //System.out.println(line);
        }  
        fr.close(); 
    }
     
}
