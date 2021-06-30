/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fcss
 */
public interface ITakeSensor extends Remote {
    
    public void ReceiveSensor(Sensor S) throws RemoteException;
    public int add(int a , int b)throws RemoteException;
    public void TakeData(String s)throws RemoteException;
}
