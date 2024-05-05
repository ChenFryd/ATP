package Server;

import Server.Strategy.ServerStrategyArrayListHandler;
import Server.Strategy.ServerStrategyStringReverser;

import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("This is the MainServer class");
        System.out.println("We will now start the operation of the Server class using the StringReverser strategy");
        System.out.println("In order to stop the server, please write 'exit' in the console");
        System.out.println();
        Server server = new Server(5400, 1000, new ServerStrategyStringReverser());
        new Thread(()->{
            server.start();
        }).start();

        String operation;
        Scanner scanner = new Scanner(System.in);
        do{
            operation = scanner.nextLine();
        } while (!operation.equalsIgnoreCase("exit"));
        server.stop();
    }
}
