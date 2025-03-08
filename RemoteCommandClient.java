/*
Name: Suryadipta Das
Class Roll no: 24
*/
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RemoteCommandClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java RemoteCommandClient <server-ip> <port>");
            return;
        }
        String serverIP = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            Registry registry = LocateRegistry.getRegistry(serverIP, port);
            RemoteCommandIntf remoteCommand = (RemoteCommandIntf) registry.lookup("command");

            Scanner scanner = new Scanner(System.in);
            String command;

            while (true) {
                System.out.print("> ");
                command = scanner.nextLine();
                if (command.equalsIgnoreCase("bye")) {
                    break;
                }
                String result = remoteCommand.executeCommand(command);
                System.out.println(result);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}