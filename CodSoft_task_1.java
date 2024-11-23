import java.util.Random;
import java.util.Scanner;
 class NumberGame
{
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Random random=new Random();
	int score=0;
	String playAgain;
	System.out.println("WELCOME TO THE NUMBER GAME!");
	do
	{
		int attempts=0;
		int maxAttempts=6;
		int randomNumber=random.nextInt(100)+1;
		boolean guessedCorrectely=false;
		System.out.println("Random number between 1 to 100 is generated.");
		System.out.println("Total number of attempts is="+maxAttempts);
		while(attempts<maxAttempts)
		{
			System.out.println("Enter your guess number=");
			int userGuess=sc.nextInt();
			attempts++;
			if(userGuess==randomNumber)
			{
				System.out.println("CONGRATULATION! you guess the correct number.");
				score=+(maxAttempts-attempts+1);
				guessedCorrectely=true;
				break;
			}
			else if(userGuess<randomNumber)
			{
				System.out.println("too low.");
			}
			else

			{
           System.out.println("too high.");
			}
			System.out.println("Remaining Attempts="+(maxAttempts-attempts));

		}
		if(!guessedCorrectely)
		{
			System.out.println("well try! you have use all attempts.The correct number was"+randomNumber);
		}
		System.out.println("Your current score="+score);
		System.out.println("Do you want to play again?(yes/no)=");
		playAgain=sc.next();
		}
		while(playAgain.equalsIgnoreCase("yes"));
		System.out.println("your final score is="+score);
		System.out.println("THANK YOU!");
		sc.close();
}
}