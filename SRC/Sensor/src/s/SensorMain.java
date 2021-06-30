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
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author fcss
 */
public class SensorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, RemoteException, NotBoundException {

        int id = 0;
        int parentid = 0;
        String type = "", zone = "", status = "";
        String recive;
        Scanner inn = new Scanner(System.in);
        Scanner inn2 = new Scanner(System.in);
        Scanner inn3 = new Scanner(System.in);

        System.out.println("Sensor in on , waiting my information , go to supervisor and give me my descriptor  ...");
        System.out.println("If the control panel in sink is show , go there and enter the command 0 to continue registring sensors...");
        Socket s = new Socket("127.0.0.1", 1234); // port of the suppervisor.
        Scanner input = new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("Register Me");
        recive = input.nextLine().toString(); // enter the senor id
        if (recive.equals("enter the sensor id: ")) {
            System.out.println("The supervior ask you tn enter your own decriptor..:");
            System.out.println(recive);
            id = inn.nextInt();
            out.println("ok1");
        }
        recive = input.nextLine().toString();
        if (recive.equals("Enter your parentID")) {

            System.out.println(recive);
            parentid = inn.nextInt();
            out.println("ok2");
        }

        recive = input.nextLine().toString();
        if (recive.equals("enter the sensor request type:")) {

            System.out.println(recive);
            type = inn2.nextLine();
            out.println("ok3");
        }

        recive = input.nextLine().toString();

        if (recive.equals("enter the sensor coverage zone")) {

            System.out.println(recive);
            zone = inn3.nextLine();
            out.println("ok4");
        }

        status = input.nextLine().toString();

         Socket s1 = new Socket("127.0.0.1", 1111);
        Scanner input1 = new Scanner(s1.getInputStream());
        PrintWriter out1 = new PrintWriter(s1.getOutputStream(), true);

         System.out.println("Start communicate with data server to capture Data");
         out1.println("requested:" + type + ":" + zone);

        
        //send this sensor to sink to add it to a vector of sensor their.
        Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1098);
        ITakeSensor IT = (ITakeSensor) reg.lookup("TS");
        System.out.println("Talking to sink... To register their..");

        System.out.println("The Sensor now is registred.");
        // IT.ReceiveSensor(sen);
        //System.out.println("The sensor now is send to sink to stay their");

        //later with data server        
       
        // CaptureThread ch = new CaptureThread(s1,type,zone);

        String m = input1.nextLine();
        double required_data = Double.parseDouble(m.split(":")[2]);

        System.out.println("Replying to request: " + m);
        System.out.println(required_data);

        // ch.start();
        IT.TakeData("Message From Sensor To Sink :" + id + ":" + parentid + ":" + type + ":" + zone + ":" + status + ":" + required_data);
        System.out.println("Sensor still running");
        while (true) {

        }
    }

}
