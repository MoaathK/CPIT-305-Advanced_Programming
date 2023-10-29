import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadChecker implements Runnable{
    private File directory;
    private ReentrantLock reentrantLock;
    File

    public ThreadChecker(File directory, ReentrantLock reentrantLock){
        this.directory = directory;

        this.reentrantLock = reentrantLock;

    }

    @Override
    public void run() {



        System.out.println("Thread: "+Thread.currentThread().toString());
        File[] files = directory.listFiles();
        if (files != null){
            for (int i = 0; i < files.length ; i++){


                if (files[i].isDirectory()){
                    Thread subDirectory = new Thread(new ThreadChecker(files[i],reentrantLock));
                    subDirectory.start();
                    try {
                        subDirectory.join();
                    }catch (InterruptedException e){

                    }
                    printData(files[i]);
                }
                else {
                    printData(files[i]);
                }

            }
        }
    }

    public void printData(File file) {
        reentrantLock.lock();
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Output.txt"))){
            os.writeObject(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
/*
        try (FileChannel channel1 = FileChannel.open(path, StandardOpenOption.APPEND)){
            FileLock lock = channel1.tryLock();
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()));
            outputStream.writeObject(file);
            lock.release();
            channel1.close();
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        /*System.out.println("File Name: "+ file.getName());
        System.out.println("File Can write: "+file.canWrite());
        System.out.println("File can read: "+file.canRead());
        System.out.println("File can execute: "+ file.canExecute());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastModified = new Date(file.lastModified());
        System.out.println("Last Modified: " + dateFormat.format(lastModified));
        System.out.println("--------------------------");*/

    }
}