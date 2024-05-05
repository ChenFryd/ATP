package IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MyDecompressorInputStream extends InputStream {

    private InputStream in;

    public MyDecompressorInputStream(InputStream IPS) {
        in = IPS;
    }


    // gets byte and transfers to 8 or less bits sequence
    private byte[] ByteToBits(int b) {
        int tmp = b;
        if (tmp < 0)
            tmp += 256;
        byte[] ans = new byte[8];
        for (int i = 7; i >= 0; i--) {
            ans[i] = (byte) (tmp % 2);
            tmp = tmp / 2;
        }
        return ans;
    }

    /**
     * read from input stream
     *
     * @param b - bye array
     * @return nothing
     */
    public int read(byte[] b) {
        try {
            int i;
            for (i = 0; i < 8; i++)
                b[i] = (byte)in.read();
            int row = b[0] * 256 + b[1]; //set size of row
            int col = b[2] * 256 + b[3]; // set size of column
            //if negative number
            row = row < 0 ? row + 256 : row;
            col = col < 0 ? col + 256 : col;
            int mazeSize = row * col;

            int overall = in.available();
            //byte[] byteArrayFinal = new byte[row * col + 8];
            while (in.available() > 1) {
                int toBinary = (byte)in.read();
                toBinary = toBinary < 0 ? toBinary + 256 : toBinary;
                byte[] binaryValues = ByteToBits(toBinary);
                for (int j = 0; j < 8; j++) {
                    b[8*(overall-in.available()) + j] = binaryValues[j];
                }
            }
            int toBinary = (byte)in.read();
            toBinary = toBinary < 0 ? toBinary + 256 : toBinary;
            byte[] binaryValues = ByteToBits(toBinary);
            if (mazeSize%8 == 0)
                for (int j = 0; j < 8; j++){
                    b[8*overall + j] = binaryValues[j];
                }
            else {
                for (int j = 0; j < mazeSize % 8; j++) {
                    b[8*overall +j] = binaryValues[(8-mazeSize%8)+j];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public int read() {

        return 0;
    }
}
