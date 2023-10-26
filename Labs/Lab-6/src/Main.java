import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main{


    public static void main(String[] args) throws FileNotFoundException {

        FileOutputStream pw = new FileOutputStream("Output.txt");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the File/Directory full path: ");
        File file = new File(input.nextLine());
        if (file.isDirectory()){
            Thread root = new Thread(new ThreadChecker(file));
            root.start();

        }



    }
}