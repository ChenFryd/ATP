package Server;

import Server.Strategy.ServerStrategyArrayListHandler;
import Server.Strategy.ServerStrategyStringReverser;

public class MainServer {
    public static void main(String[] args){
        Server server = new Server(5400, 1000, new ServerStrategyStringReverser());
        server.start();
    }
}
