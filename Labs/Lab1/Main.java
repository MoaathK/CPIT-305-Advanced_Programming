import java.io.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void isDirectory(File file,PrintWriter pw){

        File [] s = file.listFiles();


        for (int i = 0 ; i< s.length ; i++){

            if (s[i].isDirectory()){
                java.util.Date myDate = new java.util.Date(file.lastModified());
                pw.printf("File Name: %-35s",s[i].getName());
                pw.printf("File is readable: %-25s",s[i].canRead());
                pw.printf("File is writeable: %-25s",s[i].canWrite());
                pw.printf("File is executable: %-25s",s[i].canExecute());
                pw.printf("Last Modified: %-10s",myDate);
                isDirectory(s[i],pw);
            }
            else {
                isFile(s[i],pw);
            }
        }
    }
    public static void isFile(File file,PrintWriter pw)  {
        java.util.Date myDate = new java.util.Date(file.lastModified());

        pw.printf("\nFile Name: %-35s",file.getName());
        pw.printf("File is readable: %-25s",file.canRead());
        pw.printf("File is writeable: %-25s",file.canWrite());
        pw.printf("File is executable: %-25s",file.canExecute());
        pw.printf("Last Modified: %-10s",myDate);


    }
    public static void main(String[] args) throws FileNotFoundException, IOException {

        PrintWriter pw = new PrintWriter("Test.txt");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the File/Directory full path: ");
        File file = new File(input.nextLine());
        if (file.isDirectory()){
            isDirectory(file,pw);
        }
        else
            isFile(file,pw);
           

        pw.close();
        pw.flush();


    }

}