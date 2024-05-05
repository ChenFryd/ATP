package Server.Strategy;
import java.io.*;
public class ServerStrategyStringReverser implements IServerStrategy{
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) {
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(inFromClient));
        BufferedWriter toClient = new BufferedWriter(new PrintWriter(outToClient));
        System.out.println("In String reverser");

        String clientCommand;
        try {
            while (fromClient != null && !(clientCommand = fromClient.readLine()).toLowerCase().equals("exit")) {
                Thread.sleep(2000);
                String reversed = new StringBuilder(clientCommand).reverse().toString();
                toClient.write(reversed + "\n");
                toClient.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
