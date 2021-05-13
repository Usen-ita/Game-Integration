package HangmanB;
import java.util.Scanner;

public class HangmanFigure extends hangman {


	public void hangmanfigure(int lives)
	{
		if (lives == 0)
			System.out.println("\t+--+\n\t|  |\n\t|\n\t|\n\t|\n\t|\n\t|\n\t|\n\t+--");  // I have used escaped characters to ensure that the java program does not think that it is the end of the program and it runs the hangman figure.
		else if (lives == 1)  //If i used only a normal double quote "" then it would not run and the figure would not be printed but as we have added the escape characters/ backslash then it will make sure it runs it.
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t|\n\t|\n\t|\n\t|\n\t|\n\t+--");
		else if (lives == 2)
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t| /\n\t|\n\t|\n\t|\n\t|\n\t+--");
		else if (lives == 3)
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t| / \\\n\t|\n\t|\n\t|\n\t|\n\t+--");
		else if (lives == 4)
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t| /|\\\n\t|  |\n\t|\n\t|\n\t|\n\t+--");
		else if (lives == 5)
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t| /|\\\n\t|  |\n\t|\n\t|\n\t|\n\t+--");
		else if (lives == 6)
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t| /|\\\n\t|  |\n\t|\n\t|\n\t|\n\t+--");	
		else if (lives == 7)
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t| /|\\\n\t|  |\n\t| /\n\t|\n\t|\n\t+--");
		else if (lives == 8)
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t| /|\\\n\t|  |\n\t| /\n\t|\n\t|\n\t+--");
		else if (lives == 9)
			System.out.println("\t+--+\n\t|  |\n\t|  0\n\t| /|\\\n\t|  |\n\t| / \\\n\t|\n\t|\n\t+--");




}

}