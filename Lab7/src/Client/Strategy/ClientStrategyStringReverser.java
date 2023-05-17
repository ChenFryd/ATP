package Client.Strategy;

import java.io.*;

public class ClientStrategyStringReverser implements IClientStrategy{
    @Override
    public void applyStrategy(InputStream inFromServer, OutputStream outToServer) {
        try {
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(inFromServer));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter toServer = new BufferedWriter(new PrintWriter(outToServer));

            String userCommand;
            String serverResponse;
            do {
                System.out.print(">>");
                userCommand = userInput.readLine();

                toServer.write(userCommand + "\n");
                toServer.flush();

                serverResponse = fromServer.readLine();
                System.out.println("Server response = " + serverResponse);
            } while (!userCommand.toLowerCase().equals("exit"));

            fromServer.close();
            userInput.close();
            toServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
