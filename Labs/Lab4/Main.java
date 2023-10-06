import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void isDirectory(File file,ArrayList<Metadata> arrayList){

        File [] s = file.listFiles();


        for (int i = 0 ; i< s.length ; i++){

            if (s[i].isDirectory()){

                Metadata m = new Metadata(s[i].getName(),s[i].canRead(),s[i].canWrite(),s[i].canExecute(),s[i].lastModified());
                arrayList.add(m);

                isDirectory(s[i],arrayList);
            }
            else {
                isFile(s[i],arrayList);
            }
        }
    }
    public static void isFile(File file,ArrayList<Metadata> arrayList)  {
        Metadata m = new Metadata(file.getName(),file.canRead(),file.canWrite(),file.canExecute(),file.lastModified());
        arrayList.add(m);





    }
    public static void main(String[] args) throws IOException {


        Scanner input = new Scanner(System.in);
        System.out.print("Enter the File/Directory full path: ");
        File file = new File(input.nextLine());
        FileOutputStream fos   = new FileOutputStream("Test.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);

        ArrayList<Metadata> arrayList = new ArrayList<>();
        if (file.isDirectory()){
            isDirectory(file,arrayList);
        }
        else
            isFile(file,arrayList);

        for (int i = 0 ; i < arrayList.size(); i++){
            out.writeObject(arrayList.get(i));
        }





    }

}