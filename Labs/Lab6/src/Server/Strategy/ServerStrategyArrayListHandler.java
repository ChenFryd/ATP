package Server.Strategy;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ServerStrategyArrayListHandler implements IServerStrategy{
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient){
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

            ArrayList<Integer> al = (ArrayList<Integer>) fromClient.readObject();
            al.add(al.size());
            toClient.writeObject(al);
            toClient.flush();

            fromClient.close();
            toClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
