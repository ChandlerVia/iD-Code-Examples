import java.util.Random;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args){

        Random generator = new Random();
        Scanner userInput = new Scanner(System.in);

        int tries = 0;
        int guess;
        int goal;
        goal = generator.nextInt(100);

        while(true) {
            tries++;
            System.out.println("What's your guess?");
            guess = userInput.nextInt();

            if(guess > goal){
                System.out.println("Too high!");
            }
            else if(guess < goal){
                System.out.println("Too low!");
            }
            else{
                System.out.println("You win!");
                System.out.println("It took you " + tries + " tries!");
                break;
            }

        }


    }
}
