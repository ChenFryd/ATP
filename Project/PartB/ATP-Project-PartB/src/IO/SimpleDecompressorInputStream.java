package IO;

import java.io.IOException;
import java.io.InputStream;

public class SimpleDecompressorInputStream extends InputStream {
    private InputStream in;

    public SimpleDecompressorInputStream(InputStream IPS) {
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
    public int read(byte[] b) {
        try {
            int i;
            for (i = 0; i < 8; i++)
                b[i] = (byte)in.read();
            boolean one =false;
            while (in.available() > 0){
                int num = (byte)in.read(); //read the number
                for (int j = 0; j < num; j++) {
                    b[i++] = (byte)(one?1:0); //create as many bytes as the number read
                }
                one = !one; //swap the flag. if we were at 1 we become 0, and vice versa
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
