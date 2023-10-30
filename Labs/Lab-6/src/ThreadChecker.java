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
    private File file;

    public ThreadChecker(File directory, ReentrantLock reentrantLock,File file){
        this.directory = directory;
        this.file = file;
        this.reentrantLock = reentrantLock;

    }

    @Override
    public void run() {



        //System.out.println("Thread: "+Thread.currentThread().toString());
        File[] files = directory.listFiles();
        if (files != null){
            for (int i = 0; i < files.length ; i++){


                if (files[i].isDirectory()){
                    Thread subDirectory = new Thread(new ThreadChecker(files[i],reentrantLock,file));
                    subDirectory.start();
                    try {
                        subDirectory.join();
                    }catch (InterruptedException e){
                        System.out.println("In the directory we got the error");
                    }
                    //printData(files[i]);
                    reentrantLock.lock();
                    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file,false))){
                        os.writeObject(files[i]);
                        os.flush();
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());;
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    finally {

                        reentrantLock.unlock();
                    }
                }
                /*else {
                    printData(files[i]);
                }*/

            }
        }
    }

    public void printData(File file1) {

        reentrantLock.lock();
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file,false))){
            os.writeObject(file1);
            os.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {

            reentrantLock.unlock();
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