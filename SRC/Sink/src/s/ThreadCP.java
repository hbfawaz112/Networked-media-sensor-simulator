/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fcss
 */
public class ThreadCP extends Thread{


    public void run(){
        try {
            ControlPanel cp = new ControlPanel();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

