package HangmanB;
import java.util.Scanner;

public class wordstobeguessed extends hangman{


// this is another class which i have created this is where we will get the words from 
	public static String[] wordstobeguessed(){ 
	 
		// i have created a string because i found it easier to do so in each string- which is a category there is words according to the category 
	 String[] countries = {
		        "india",
		        "argentina",
		        "australia",
		        "portugal",
		        "united kingdom",
		        "bangladesh",
		        "barbados",
		        "bulgaria",
		        "belgium",
		        "france",
		        "spain"
		    };
		    String[] Programminglanguages = {
		        "java",
		        "pascal",
		        "python",
		        "javascript",
		        "fortran",
		        "cobol",
		        "c++"
		    };
		    String[] Animals = {
		        "dog",
		        "cat",
		        "monkey",
		        "giraffe",
		        "bird",
		        "penguin",
		        "elephant",
		        "lion",
		        "tortoise",
		        "fox",
		        "bee ",
		        "alligator",
		        "dolphins",
		        "beetle"
		    };
		    String[] vegetables = {
		        "potato",
		        "carott",
		        "beetroot",
		        "onion",
		        "garlic",
		        "cucumber",
		        "eggplant",
		        "lettuce",
		        "okra",
		        "peppers",
		        "peas",
		        "chillies"
		    };
		    String[] fruits = {
		        "apples",
		        "apricot",
		        "blueberry",
		        "banana",
		        "oranges",
		        "peaches",
		        "cherries",
		        "pomegranate",
		        "grapes",
		        "lychee",
		        "mango",
		        "watermelon"
		    };
		    String[] languages = {
		        "french",
		        "chinese",
		        "spanish",
		        "hindi",
		        "english",
		        "portuguese",
		        "turkish",
		        "german",
		        "italian",
		        "mandarin",
		        "polish",
		        "romaninan"
		    };
		    String[] TvShows = {
		        "game of thrones",
		        "the walking dead",
		        "lucifer",
		        "riverdale",
		        "suits",
		        "the crown",
		        "downtown abbey",
		        "peaky blinders",
		        "sherlock",
		        "doctor who",
		        "killing eve",
		        "the bodyguard"
		    };
		    String[] cars = {
		        "bmw",
		        "mercedes",
		        "volkswagen",
		        "toyota",
		        "hyundai",
		        "vauxhall",
		        "nissan",
		        "lexus",
		        "citroen",
		        "bugatti",
		        "tesla",
		        "peugeot",
		        "ford",
		        "honda"
		    };
		    String[] Sports = {
		        "gymnastics",
		        "badminton",
		        "athletics",
		        "football",
		        "cricket",
		        "snooker",
		        "tennis",
		        "basketball",
		        "table tennis",
		        "darts",
		        "golf",
		        "baseball",
		        "running",
		        "Swimming",
		        "boxing",
		        "skiing",
		        "ice skating"
		    };
		    
		    //this is a empty string which i have created where i have got selection so that once i create the switch cases then it will return them.

		    String[] selection ={ "" };


		
		    boolean correctAnswer = false;//. i have created a boolean with correct answer and set it to false, so each time its true then it will run the code otherwise it will end.
		    String answer;// this is a string to get the user input so if they input between 1-9 then it will choose the category as per the selection of the user.
		    
		    // this is just a simple menu i have created so that it looks more professional
		    do {
		    	System.out.println("<><><><><><><><><><><><><>");
		 	      
		 		   System.out.println("Choose a category:\n");
	               System.out.print("1.) Countries.\n");
	               System.out.print("2.) Programming Languages.\n");
	               System.out.print("3.) Animals.\n");
	               System.out.print("4.) Vegetables.\n");
	               System.out.print("5.) Fruits.\n");
	               System.out.print("6.) Languages.\n");
	               System.out.print("7.) Famous TV Shows.\n");
	               System.out.print("8.) Sports.\n");
	               System.out.print("9.) Car Brands.\n");
	               System.out.println("<><><><><><><><><><><><><>");
	               System.out.print("\nEnter Your Category Choice: ");// asks user to enter a number between 1-9
		 	        Scanner scan = new Scanner(System.in);// scanner to get user input
	               
	
		 	      
		 	        answer = scan.nextLine().toLowerCase(); // this is going to be the user input it can and it will scan it.
		 	   
		 	   

		        
		        if (answer.matches("[1-9]"))
		        	correctAnswer = true; // if user selects 1-9 then it will run the code according to the selection.
		        
		        else System.out.println("Invalid input! Enter the number of the category you want.");// if they have entered something else then it will give an error message
		    } 
		    while (!correctAnswer);

		    int userselection = Integer.parseInt(answer); // this converts the string Answer to a integer 
		    // this is a switch case where it will get the user input
		    switch (userselection) {
		        
		    
		        case 1:
		            selection = randomisedOrder(countries);
		            System.out.println("You have Chosen Countries");
		            break;                                                // } These are going to be what the user is going to input when the select the category. I have also made sure that the user is able to know which category they have selected
		        
		        case 2:
		            selection = randomisedOrder(Programminglanguages);
		            System.out.println("You have Chosen Programming Languages");
		            break;
		        
		        case 3:
		            selection = randomisedOrder(Animals);
		            System.out.println("You have Chosen Animals");
		            break;
		        
		        case 4:
		            selection = randomisedOrder(vegetables);
		            System.out.println("You have Chosen Vegetables");
		            break;
		        
		        case 5:
		            selection = randomisedOrder(fruits);
		            System.out.println("You have Chosen Fruits");
		            break;
		        
		        case 6:
		            selection = randomisedOrder(languages);
		            System.out.println("You have Chosen Languages");
		            break;
		        
		        case 7:
		            selection = randomisedOrder(TvShows);
		            System.out.println("You have Chosen Famous TV Shows ");
		            break;
		       
		        case 8:
		            selection = randomisedOrder(Sports);
		            System.out.println("You have Chosen Sports");
		            break;
		        
		        case 9:
		            selection = randomisedOrder(cars);
		            System.out.println("You have Chosen Car Brands");
		            break;
		    }
		    return selection;
		    



// it will return selection once everything has been finished.

		

}
	
	// this is a method which i have created so it will randomise each time so that the user does not get the same word again.,
	public static String[] randomisedOrder(String[] array) {
	    
		int[] order = uniqueRandoms(array.length); // this is integer which is called order it will run based on the second method i have created below.
	   
		String[] selection = new String[array.length]; // this is a string where i have created which is according to the array lentgh
	    
		for (int i = 0; i < order.length; i++) { // this is a nested loop where i is 0 and i < order length, it increments the i each time.
	        
			selection[i] = array[order[i]]; // this is the selection string i created above where it will be based on the array and order.
	    }
	    return selection;// this is going to be returning the selection 
	}
	// Generates an array of n random numbers from 0 to n-1
	public static int[] uniqueRandoms(int v) {
	    
		int[] random1 = new int[v]; // this is the first integer i have created which is called random 1 
	    
		int random,Vivek; // random and Index
	   
		for (int i = 0; i < v;) { // nested loop where v the new integer
	        
			random = (int) (Math.random() * v); // this is where it would * the int v
	        
			random1[i] = random;//  random 1 is equal to random
	        
			for (Vivek = 0; random1[Vivek] != random; Vivek++); // the Vivek is =0 and if random1 Vivek is not equal to random then index increments
	        
			if (Vivek == i) i++;// we compare the integer Vivek to i, and increment i each time
	    }
	    return random1;// we return the random 1 after the whole process has been done.


	}
	

		
		
	}

	

