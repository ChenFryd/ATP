package Server;

import Server.Strategy.IServerStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;

public class Server {
    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private final  Logger LOG = LogManager.getLogger(); //Log4j2
    private ExecutorService threadPool; // Thread pool

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

                    threadPool.submit(()->handleClient(clientSocket));// Insert the new task into the thread pool:

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
