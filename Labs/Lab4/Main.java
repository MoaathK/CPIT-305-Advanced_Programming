import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void isDirectory(File file, ArrayList fileList){

        File [] s = file.listFiles();


        for (int i = 0 ; i< s.length ; i++){

            if (s[i].isDirectory()){

                System.out.println(s[i].getName());
                fileList.add( new Metadata(s[i].getName(),s[i].canRead(),s[i].canWrite(),s[i].canExecute(),s[i].lastModified()));

                isDirectory(s[i],fileList);
            }
            else {
                isFile(s[i],fileList);
            }
        }
    }
    public static void isFile(File file, ArrayList fileList)  {
        fileList.add( new Metadata(file.getName(),file.canRead(),file.canWrite(),file.canExecute(),file.lastModified()));


    }
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("Test.txt");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the File/Directory full path: ");
        File file = new File(input.nextLine());
        ArrayList<Metadata> fileList = new ArrayList<>();
        if (file.isDirectory()){
            isDirectory(file,fileList);
        }
        else
            isFile(file,fileList);

        for (Metadata value : fileList) {
            pw.println(value.toString());
        }

        pw.close();
        pw.flush();


    }
}