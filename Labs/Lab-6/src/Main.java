import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;


public class Main{


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.print("Enter the File/Directory full path: ");
        File file = new File(input.nextLine());
        File output = new File("Output.dat");
        ReentrantLock reentrantLock = new ReentrantLock();

        if (file.isDirectory()) {
            Thread root = new Thread(new ThreadChecker(file, reentrantLock, output));
            root.start();

            }

        }






    }