import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Name: Moath Khalid Alahmadi
 * ID: 2135524
 * Course: CPIT-305
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value = 0;
        try{
            System.out.print("Enter a number from 0 to 100 :");
            value = input.nextInt();
            if(value < 0 || value >100 ){
                throw new RuntimeException();
            }
            System.out.println(Math.pow(value,2));

        }
        catch(InputMismatchException e){
            System.out.println("Invalid input");
        }
        catch(RuntimeException e){
            System.out.println("input out of range");
        }

    }
}


