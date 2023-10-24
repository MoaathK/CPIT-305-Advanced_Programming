import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ThreadChecker implements Runnable{
    private File directory;


    public ThreadChecker(File directory){
        this.directory = directory;

    }

    @Override
    public void run() {

        System.out.println("Thread Name: "+Thread.currentThread().getName());
        File[] files = directory.listFiles();
        if (files != null){
            for (int i = 0; i < files.length ; i++){
                if (files[i].isDirectory()){
                    Thread subDirectory = new Thread(new ThreadChecker(files[i]));
                    subDirectory.start();
                    printData(files[i]);
                }
                else {
                    printData(files[i]);
                }
            }
        }
    }
    public void printData(File file){
        System.out.println("File Name: "+ file.getName());
        System.out.println("File Can write: "+file.canWrite() );
        System.out.println("File can read: "+file.canRead() );
        System.out.println("File can execute: "+ file.canExecute());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastModified = new Date(file.lastModified());
        System.out.println("Last Modified: " + dateFormat.format(lastModified));

        System.out.println("-------------------------------------");
    }
}
