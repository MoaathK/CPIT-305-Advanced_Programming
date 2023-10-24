import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main{


    public static void main(String[] args) throws FileNotFoundException {


        Scanner input = new Scanner(System.in);
        System.out.print("Enter the File/Directory full path: ");
        File file = new File(input.nextLine());
        if (file.isDirectory()){
            Thread root = new Thread(new ThreadChecker(file));
            root.start();

        }


    }
}