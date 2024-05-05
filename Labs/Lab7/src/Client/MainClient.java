package Client;

import Client.Strategy.ClientStrategySendArrayList;
import Client.Strategy.ClientStrategyStringReverser;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainClient {
    public static void main(String[] args) {
        try {
            Client client = new Client(InetAddress.getLocalHost(), 5400, new ClientStrategyStringReverser());
            client.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
