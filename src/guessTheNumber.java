import java.util.Scanner;

public class guessTheNumber {

    public static void game() {
        short number, attempts, guess; // number = the random generated number to be guessed; attempts = counting how many tries the user uses; guess = user's input for each try
        boolean play = true; // variable that will keep the game going until the users chooses to stop
        byte again; // at the end of the game, this variable will store the user choice if to play the game again or not
        Scanner input = new Scanner(System.in); //Scanner Class

        System.out.println("Welcome to the \"Guess the number\" game!\nI will think about a number ranged between 1 and 20.\nYou will have 5 tries available to guess it.");

        while(play){
            
            System.out.println("I'm thinking...");wait(700); //Using the wait method to make the game a little bit more realistic
            number = (short) (Math.random()*(20-1)+1); //generatig a random number between 20 and 1 by the formula (dataType)(Math.random()*(Max-Min)+min);
            //System.out.println (number); //Uncomment this step if you want the PC's number displayed for functionality testing purposes etc.
            System.out.println ("Okay, I have a number in mind.");
            
            attempts=5;
            while (attempts!=0){

                System.out.print("Guess my number: ");
                guess = input.nextShort();
                attempts--;

                if (guess == number){
                    System.out.println("Congratulations, you guessed my number!");
                    System.out.print("Do you want to play again? Type 1 if yes and 0 if no. ");
                    again = input.nextByte();
                    if(again==1){
                        break;
                    }
                    else {
                        play=false;
                        break;
                    }
                }
                else{
                    System.out.println("Nope, this is not the number I am thinking about.");
                }

                if(attempts==0){
                    System.out.println("Looks like you have wasted all of your available tries, so you lost this time. \nI was thinking about number "+number+".");
                    System.out.print("Do you want to play again? Type 1 if yes and 0 if no. ");
                    again = input.nextByte();
                    if(again==1){
                        break;
                    }
                    else {
                        play=false;
                        break;
                    }
                }
            }
        }
    }

    //creating the wait method, used right after the PC generates a number, to make the game a little bit more realistic
    public static void wait(int ms){
        try {
                Thread.sleep(ms);
        }
        catch(InterruptedException ex){
                Thread.currentThread().interrupt();
        }
    }

    public static void main (String[] arg){
        game();
    }
}
