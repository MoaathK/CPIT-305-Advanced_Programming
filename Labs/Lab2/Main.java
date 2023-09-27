import java.util.InputMismatchException;
import java.util.Scanner;

/*
    * Name: Moath Alahmadi
    * ID: 2135524
    * Course: CPIT-305
 */
public class Main {
    public static int power(int Value) throws OutOfRangeException{
        if (Value < 0 || Value >=100){
            throw new OutOfRangeException(0,100);
        }
        return Value * Value;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Please Enter a number from 0 to 100 : ");
            int value = input.nextInt();
            System.out.println( value +" * "+ value +" = "+ power(value));


        }catch (OutOfRangeException e){
            System.out.println("Exception has Happened "+e.getClass().getName());
            System.out.println("msg of Exception: "+ e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Invalid input, entered value must be an integer");
        }

        
    }
}
