/*
Name: Suryadipta Das
Class Roll no: 24
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class RemoteCommandImpl extends UnicastRemoteObject implements RemoteCommandIntf {
    protected RemoteCommandImpl() throws RemoteException {
        super();
    }

    public String executeCommand(String command) throws RemoteException {
        StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
        return output.toString();
    }
}