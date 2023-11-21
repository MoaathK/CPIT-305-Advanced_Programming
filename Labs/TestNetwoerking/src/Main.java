import com.sun.source.tree.Scope;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {



        /*System.out.println(list.get(0));
        System.out.println(list.get(1));

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add("10");*/

    }
}
/*
  try(var s = new ServerSocket(8189) ;
            Socket incoming = s.accept();
            InputStream inStream  = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();
            var in = new Scanner(inStream, StandardCharsets.UTF_8);
            var out = new PrintWriter(outStream, true,StandardCharsets.UTF_8);
        ){
            out.println("hello! Enter Bye to exit");
            var done = false;
            while (!done){
                String line = in.nextLine();
                out.println("Echo: " +line);
                if (line.trim().equals("BYE"))
                    done = true;

            }
        }catch (IOException e){
            System.out.println("Exception: "+e);
        }
 */

/*
    try (var s = new Socket("time-a.nist.gov",13);
             var in  = new Scanner(s.getInputStream(), StandardCharsets.UTF_8))   {
            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }


        ----------------------------------------------------
        try {
            var s = new Socket("time-a.nist.gov",13);
            try {
                var in = new Scanner(s.getInputStream(),StandardCharsets.UTF_8);
                while (in.hasNextLine()){
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }finally {
                s.close();
            }

        }catch (IOException e) {
            System.out.println("We have the following exception " + e);
        }
        -----------------------------------------------------------
        try(var s = new Socket("time-a.nist.gov",13);
           var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8) ){
            System.out.println("The Address to which the socket is connected: "+s.getInetAddress());
            System.out.println("The remote port number to which this socket is connected: "+s.getPort());
            System.out.println("the local address to which the socket is bound: "+s.getLocalAddress());
            System.out.println("The local port number to which this socket is bound: " +s.getLocalPort());
            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }

        -----------------------------------------------------------
        try(var s = new ServerSocket(8189) ;
            Socket incoming = s.accept();
            InputStream inStream  = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();
            var in = new Scanner(inStream, StandardCharsets.UTF_8);
            var out = new PrintWriter(outStream, true,StandardCharsets.UTF_8);
        ){
            out.println("hello! Enter Bye to exit");
            var done = false;
            while (!done){
                String line = in.nextLine();
                out.println("Echo: " +line);
                if (line.trim().equals("BYE"))
                    done = true;

            }
        }catch (IOException e){
            System.out.println("Exception: "+e);
        }
 */