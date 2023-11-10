import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {


    public static void main(String[] args)  {

        try (var s  = new ServerSocket(8189)){
            System.out.println("Server started. Waiting for clients...");
            while (true){
                Socket incoming = s.accept();

                Runnable r = new MyThread(incoming);
                var t = new Thread(r);
                t.start();



            }
        }catch (IOException e){
            e.printStackTrace();
        }



    }




}
