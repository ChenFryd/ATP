package Client.Strategy;

import java.io.InputStream;
import java.io.OutputStream;

public interface IClientStrategy {
    void applyStrategy(InputStream inFromServer, OutputStream outToServer);
}
