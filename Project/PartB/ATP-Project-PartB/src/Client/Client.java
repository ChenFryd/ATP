package Client;

import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private InetAddress serverIP;
    private int serverPort;
    private IClientStrategy clientStrategy;

    /**
     * client class
     *
     * @param serverIP       - ip address
     * @param serverPort     - port num
     * @param clientStrategy - type of server
     */
    public Client(InetAddress serverIP, int serverPort, IClientStrategy clientStrategy) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.clientStrategy = clientStrategy;
    }

    /**
     * communicate with server, creates strategy and close server at end
     */
    public void communicateWithServer() {
        try {
            Socket theServer = new Socket(serverIP, serverPort);
//            System.out.println(String.format("Client is connected to server (IP: %s, port: %s)", serverIP, serverPort));
            clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
