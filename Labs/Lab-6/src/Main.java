import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;


public class Main{


    public static void main(String[] args) throws FileNotFoundException {

        //FileOutputStream pw = new FileOutputStream("Output.txt");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the File/Directory full path: ");
        File file = new File(input.nextLine());
        File output = new File("Output.txt");
        ReentrantLock reentrantLock = new ReentrantLock();
        //RandomAccessFile randomAccessFile = new RandomAccessFile(output, "rw");
        if (file.isDirectory()) {
            Thread root = new Thread(new ThreadChecker(file, reentrantLock, output));
            root.start();

        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Output.txt"))) {
            File[] ob = (File[]) in.readObject();
            //System.out.println(ob);
            for (File e : ob) {
                System.out.println(e);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
            //File file1 = new File("data.dat");

        /*try {
            // Create a RandomAccessFile and a FileChannel for the file

            FileChannel fileChannel = randomAccessFile.getChannel();

            // Acquire an exclusive lock on the file
            FileLock fileLock = fileChannel.lock();

            // Now, you can safely write objects to the file using ObjectOutputStream
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(randomAccessFile.getFD()));
            //MyObject obj = new MyObject(); // Replace with your object

            //outputStream.writeObject(obj);

            // Release the lock when done
            fileLock.release();

            // Close the file and file channel
            outputStream.close();
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/



    }}