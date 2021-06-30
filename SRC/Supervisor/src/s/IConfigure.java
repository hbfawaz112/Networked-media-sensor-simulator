/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author fcss
 */
public interface IConfigure extends Remote{
    
        public int add(int a,int b) throws RemoteException;
         public String getList() throws RemoteException;
         public void updateStatud(int id , String status) throws RemoteException;
        
}
