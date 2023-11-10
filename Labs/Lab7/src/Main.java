import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

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
