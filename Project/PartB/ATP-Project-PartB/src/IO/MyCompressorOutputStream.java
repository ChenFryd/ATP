package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class MyCompressorOutputStream extends OutputStream {
    private OutputStream out;


    public MyCompressorOutputStream(OutputStream OPS) {

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
     * convert from byte array to byte
     *
     * @param ArryToConvert - array to convert
     *                      @unfinishedSize - size of how much unfinished bytes
     * @return byte after conversion
     */

    private byte convertByteArr(byte[] ArryToConvert,int unfinishedSize) {
        int intNum = 0, power = 0;
        for (int i = ArryToConvert.length -unfinishedSize - 1; i >= 0; i--)
            intNum += ArryToConvert[i] * (int) Math.pow(2, power++);
        return (byte) intNum;
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
            byte[] bitSend = new byte[8];
            while (j < b.length) {
                int count = 0;
                while (count < 8 && j < b.length) //send first 8 details
                    bitSend[count++] = b[j++];
                out.write(convertByteArr(bitSend,8-count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
