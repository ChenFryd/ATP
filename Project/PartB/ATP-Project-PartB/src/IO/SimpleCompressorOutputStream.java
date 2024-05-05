package IO;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleCompressorOutputStream extends OutputStream {
    private OutputStream out;
    public SimpleCompressorOutputStream(OutputStream OPS) {
        out = OPS;
    }

    /**
     * write int, do nothing
     *
     * @param b - int num
     */
    public void write(int b) {
    }

    /**
     * write to output stream
     *
     * @param b - write byte array
     */

    public void write(byte[] b) {
        try{
            int j;
            for (j = 0; j < 8; j++)
                out.write(b[j]);
            boolean one=false;
            while (j < b.length) {
                int count = 0;
                while (j<b.length && b[j] == (one ? 1 : 0) && count < 255) {
                    count++;
                    j++;
                }
                one = !one; //swap the flag. if we were at 1 we become 0, and vice versa
                out.write((byte)count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
