package Server;

import Server.Strategy.IServerStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {
    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private final  Logger LOG = LogManager.getLogger(); //Log4j2


    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
    }

    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);
            LOG.info("Starting server at port = " + port);

            while (!stop) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    LOG.info("Client accepted: " + clientSocket.toString());

                    // This thread will handle the new Client
                    new Thread(() -> {
                        handleClient(clientSocket);
                    }).start();

                } catch (SocketTimeoutException e){
                    LOG.debug("Socket timeout");
                }
            }
        } catch (IOException e) {
            LOG.error("IOException", e);
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            strategy.applyStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            LOG.info("Done handling client: " + clientSocket.toString());
            clientSocket.close();
        } catch (IOException e){
            LOG.error("IOException", e);
        }
    }

    public void stop(){
        LOG.info("Stopping server...");
        stop = true;
    }
}
