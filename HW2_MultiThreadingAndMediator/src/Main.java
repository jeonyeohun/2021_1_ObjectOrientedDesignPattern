import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int initialSpeed;
        System.out.print("Car Speed between 60 and 100 : ");
        try{
            initialSpeed = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
            return;
        }

        if (initialSpeed > 100 || initialSpeed < 60){
            System.out.println("Invalid Input");
            return;
        }

        try {
            new BlackBoxMediator(initialSpeed);
        }
        catch (InterruptedException e){
            System.err.println(e);
        }

    }
}
