import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyThread implements Runnable {
    private Socket incoming;
    public MyThread(Socket incoming){
        this.incoming = incoming;


    }

    @Override
    public void run() {
        try (
                InputStream in = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                Scanner sc = new Scanner(in);


                var out = new PrintWriter(outStream,true, StandardCharsets.UTF_8))
        {
            out.println("Enter your name:");
            String name = sc.nextLine();
            out.println("Enter your date of birth (yyyy-mm-dd): ");
            String dob = sc.nextLine();
            out.println("Enter your gender:");
            String Gender =sc.nextLine();
            out.println("Enter your nationality:");
            String nationality = sc.nextLine();
            User user = new User(name,dob,Gender,nationality);
            writeUserToFile(user);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static synchronized void writeUserToFile(User user) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Users.dat",true))) {
            out.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
