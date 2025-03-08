
/*
Name: Suryadipta Das
Class Roll no: 24
*/
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteCommandServer {
    public static void main(String[] args) {
        try {
            RemoteCommandImpl commandExecutor = new RemoteCommandImpl();
            Registry registry = LocateRegistry.createRegistry(1097);
            registry.rebind("command", commandExecutor);
            System.out.println("Remote Command Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}