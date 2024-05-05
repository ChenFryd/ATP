package Exercice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class FileReader {
    /**
     * @param filePath path to the file
     * @return true if the file exists
     */
    public static boolean IsFile(String filePath){
        return Files.exists(Path.of(filePath));
    }

    /**
     * @param filePath path to the file
     * @return the content of the file
     * @throws IOException if the file doesn't exist
     */
    public static String ReadFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath), Charset.forName("ISO-8859-1"));
    }

    public static List<String> ReadFileLines(String filePath) throws IOException {
        return Files.readAllLines(Path.of(filePath), Charset.forName("ISO-8859-1"));
    }
    public static List<String> ReadFileLinesBufferedReader(String filePath) throws IOException {
        return (List<String>) Files.newBufferedReader(Path.of(filePath), Charset.forName("ISO-8859-1")).lines();
    }


}
