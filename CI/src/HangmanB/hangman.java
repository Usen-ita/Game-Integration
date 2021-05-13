package HangmanB;
// Vivek Majithia
//Student NO: 2011409
//CS1701 Assignment 3/ CS1805
// Hangman Variation B
// This is the game which i have created for Hangman Variation B






import java.io.IOException;
import java.util.Scanner;




// As you can see this is the main method, so this is going to be running the main code, here i have added the start of the game, this is another class which i have created,
//where it is going to be showing the menu at the start and prompt the user to continue.
public class hangman {

    public static void main(String[] args) throws IOException  {

    	Startofthegame s1 = new Startofthegame();

    	Startofthegame.MainGame();
    	  // this is the another class i have created and i have called here in the main.
   	
    }
						

   
        
    

    


        

    
    
    // This is a method i have created, this is a code where it has many different functions running and i will explain each function differently in my comments.
    
    public static boolean mainHangman(String secretword) {
    	Scanner scan = new Scanner(System.in); // this is a scanner which i have created, this is for scanning the next line where we get the user input.
    	
    	String[] Word = new String[secretword.length()];   // this is the first string which i have created , this string is mainly the Word which will be used as a substring for the secretword, A part of string is called substring. A Substring is a subset of another string.
    	
    	String[] dasheswithword = new String[secretword.length()]; // this is the dashes with word, as the name you can see this is where the word will replace the dashes so that the dashes are according to the word.
    	
    	for (int i = 0; i < Word.length; i++) {        // this is a nested loop i have created where if word length is bigger than I then it keeps searching until the word has been found.         
    	    
    		Word[i] = secretword.substring(i,  i + 1);// as i said before the secret word is a substring of Word , where it will add 1 to i each time. without this the code would be saying that a exception has happened every single time
    	  
    		dasheswithword[i] = "_"; // this is the dashes with word which will be the length of the word and then it will replace the dash each time the user guesses it correctly.
    	}
    	
    	
    
    	int lives = 0, maxlives = 10, warnings = 1; // I have chosen Maxlives due to the fact that a user has so many categories to choose from so they will have to have a certain amount of lives.
    	
    	boolean won = false; // this is a boolean i have created so that if the user has won the game then it finishes, so i declared the variable here.
    	try {// this a try and catch statement i have done, this is to make sure that if a user presses enter by mistake then they get an error.
    	
    	while (lives < maxlives && !won) // this is where lives which is 0 is smaller than max lives and the user has not won.
    	{
    	    String displayWord = ""; // this is a empty string where the user will enter the guess.
    	   
    	    for (String Vivek: dasheswithword) displayWord += " " + Vivek ; // i have created an empty string so that it checks if the letter is in the word , if i were to remove this, the scanner would be asking for  input but it wouldnt be checking if the letter is in the word.
    	 
    	    System.out.println("\n Your Guess :" + displayWord); // this is where the user will be able to see their guess if it is correct and the code runs it then it should replace the dash with a word.
    	  
    	    System.out.println("\nTotal Number of Letters in Word: " + secretword.length()); // this is something extra i have added where the user is able to see how many letters there are in the word.
  
    	    System.out.print("\nEnter a letter: ");// this is where the user will enter their letter which they wish to guess.
    	    

    	    String Guess = scan.nextLine().toLowerCase(); //checks for valid input
    	    
    	    if (Guess.length() > 1 && Guess.equals(secretword)) { // checks if the word is in the guess, and if it is then the user has won the game
    	        won = true;
    	       
    	        } 
    	    else if (Character.isDigit(Guess.charAt(0))) { // this is what i have created where if the user input is a digit then it will give the user a warning and if they get 3 warnings then they will lose a life.
    	        
    	    	System.out.println("Please Enter a valid input!" + " You have received a warning: " + warnings); // this will print out the warnings
    	
    	    	warnings++; // this will increase the warnings each time
    	        
    	        if (warnings % 3 == 0) { // this is a if statement i created if the warnings are 3 then it resets it to 0 and then decreases a user life.
    	            
    	        lives =lives +1;// lives is decreased each time 
    	        }
    	       
    	    
    	        } else if (secretword.indexOf(Guess) != -1) { // The indexOf() method returns the position of the first occurrence of specified character(s) in a string
    	        	
    	        	
    	    	boolean dashes = false; // -  this is the "_" which will be replaced each time the user guesses the correct letter.
    	        
    	        for (int i = 0; i < Word.length; i++) { //this is another nested loop i have created so that if the user still needs to guess the word then it will keep asking them until they lose their lives.
    	           
    	        	if (Word[i].equals(Guess)) // if word is equal to Guess and dashes with word is equal to guess then the user has won.
    	        	
    	        	dasheswithword[i] = Guess; 
    	            
    	        	else if (dasheswithword[i].equals("_"))// otherwise if they are equal to "_" then it means user still needs to guess the word.
    	        		
    	        	dashes = true; // this means that the dashes are still there and the user still needs to guess the word
    	        	
    	        }
    	        
    	        won = !dashes; // If there are no dashes left, the whole word has been guessed and the user has won.
    	        } 
    	        
    	        else {
    	        
    	        HangmanFigure h1 = new HangmanFigure();
    	        h1.hangmanfigure(lives); // this is another class i have created where it extends to here, so when the user enters a guess then the figure will be printed if it is not a correct guess 
    	        
    	        System.out.println("\nWrong Guess, Please Enter a New Letter"); // this prompts the user to enter a correct letter so that they don't enter the same one again.
    	       
    	        System.out.println("You've used " + ++lives + " out of " + maxlives + " Lives.");// this prints out the amount of lives the user has when the figure is printed as the user has entered a wrong letter.
    	       
    	        {
    	        	

     	     
    	        	
    	        
    	    
    	    
    	    
    	    
    	        }}}}
    	        catch (Exception main) { // this is the second part of the try and catch statement where it will say that a exception has happened if a user has entered something wrong, instead of long red lines .
    	        	
    	        	
    	        	System.out.println("A Exception Happened");
    	        	System.out.println("Please Restart Game!");
    	        	System.exit(1);
    	        	
	
    	        
    	    
    	        
    	        }
		return won;} // this is going to be returning won so that we can use this for in our code further.
		
		



   


    	
    	
    	public static String[] wordstobeguessed() // this is a method which i had to create because i needed to add more classes to it so i created the method here and extended it so that we can use it.
    	{
    		wordstobeguessed w1 =  new wordstobeguessed();
    		
    		return wordstobeguessed.wordstobeguessed(); //this is the method which has been extended to another class.
    	}
    	
    	
    	
    	
    	
    
    			
    		
    		
    		
    		
    	}
    	

    	

    















	
    	
    
    

  

		

	
	


	
	
    
    
    

