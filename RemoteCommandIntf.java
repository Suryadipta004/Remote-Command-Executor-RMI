/*
Name: Suryadipta Das
Class Roll no: 24
*/

import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote Interface
public interface RemoteCommandIntf extends Remote {
    String executeCommand(String command) throws RemoteException;
}
