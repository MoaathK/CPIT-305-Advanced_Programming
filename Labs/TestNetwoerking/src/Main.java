import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        try (var s = new Socket("time-a.nist.gov",13);
             var in  = new Scanner(s.getInputStream(), StandardCharsets.UTF_8))   {
            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}