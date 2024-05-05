package Client.Strategy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientStrategySendArrayList implements IClientStrategy {
    @Override
    public void applyStrategy(InputStream inFromServer, OutputStream outToServer) {
        try {
            ObjectOutputStream toServer = new ObjectOutputStream(outToServer);
            ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
            System.out.println("Sending ArrayList: " + al.toString());
            toServer.writeObject(al);
            toServer.flush();
            ObjectInputStream fromServer = new ObjectInputStream(inFromServer);
            ArrayList<Integer> serverResult = (ArrayList<Integer>) fromServer.readObject();
            System.out.println("Received ArrayList: " + serverResult.toString());

            fromServer.close();
            toServer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
