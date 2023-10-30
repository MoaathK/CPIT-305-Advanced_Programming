import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadChecker implements Runnable, Serializable{
    private File directory;
    private ReentrantLock reentrantLock;
    private File file;

    public ThreadChecker(File directory, ReentrantLock reentrantLock,File file){
        this.directory = directory;
        this.file = file;
        this.reentrantLock = reentrantLock;

    }

    @Override
    public void run() {




        File[] files = directory.listFiles();
        if (files != null){
            for (int i = 0; i < files.length ; i++){


                if (files[i].isDirectory()){
                    ThreadChecker th = new  ThreadChecker(files[i],reentrantLock,file);
                    Thread subDirectory = new Thread(th);
                    subDirectory.start();
                    try {
                        subDirectory.join();
                    }catch (InterruptedException e){
                        System.out.println("In the directory we got the error");
                    }
                    printData(this);

                }


            }
        }
    }

    public void printData(ThreadChecker th)  {

        reentrantLock.lock();
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file,true)))
        {
            os.writeObject(th);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
        finally {

            reentrantLock.unlock();
        }


    }
}