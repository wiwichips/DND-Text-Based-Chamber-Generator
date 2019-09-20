package dnd;

import java.util.ArrayList;
import java.util.Scanner;
import dnd.models.ChamberContents;
import dnd.models.ChamberShape;
import dnd.models.Trap;
import dnd.models.Treasure;
import dnd.exceptions.NotProtectedException;
import dnd.exceptions.UnusualShapeException;


/**
@author Will Pringle
*/
public final class Dungeon {

    private Dungeon() {

    }

    /**
     * test test test.
     * test test test.
     *
     * @param args takes in a string
     */
    public static void main(final String[] args) {
        ChamberShape shape = new ChamberShape();
        ChamberContents contents = new ChamberContents();
        Trap trap = new Trap();
        Treasure treasure = new Treasure();

        System.out.println("Welcome to Will's Dungeon Generator!"
        + "Do you want to randomly generate"
        + "the entire dungeon?");

        if (getUserInputYesOrNo()) {
            shape.setShape();
            shape.setNumExits();
            contents.setDescription();
            trap.setDescription();
            treasure.setContainer();
            treasure.setDescription();

        } else {
			try {
				shape.setShape(getD20Input("Set Shape: "));
				
			} catch (NullPointerException e) {
				shape.setShape();
			}
            shape.setNumExits(getD20Input("Set Number of Exits: "));
            contents.setDescription(getD20Input("Set Contents: "));
            trap.setDescription(getD20Input("Set Trap: "));
            treasure.setContainer(getD20Input("Set treasure"
            + "container: "));
            treasure.setDescription(getD20Input("Set treasure: "));

        }

        printDungeon(shape, contents, trap, treasure);
    }

    private static String getUserInput(final String prompt) {
        // create scanner object to use for input
        Scanner inputReader = new Scanner(System.in);

        // print the prompt
        System.out.print(prompt);

        // return a string of the user's input
        return inputReader.nextLine();

    }

	private static int getD20Input(final String prompt) {
		
		int userInput = getInputAsInteger(prompt); 
		boolean hasValidInput = false;
		int lower = 0;
		int upper = 20;
		
		
		do {
			
			if(userInput >= lower && userInput <= upper) {
				hasValidInput = true;
				
				return userInput;
			}
			System.out.println("Please enter a number between 1"
				+ "and 20 or 0 for a random D20 roll");
			userInput = getInputAsInteger(prompt);
		
		} while(!hasValidInput);
		
		return userInput;
	}


    private static int getInputAsInteger(final String prompt) {
		int roll = 0;
		String userInput;
		
		
		do {
			try {
				userInput = getUserInput(prompt);
				roll = Integer.parseInt(userInput);
				
				return roll;
				
			} catch (Exception e) { // change to NumberFormatException
				System.out.println("Please enter a number");
			}
			
		} while (true);
		
        
    }

    private static boolean getUserInputYesOrNo() {
        // call the getUserInput method
        boolean yes = false;
        boolean hasDecided = false;

        // returns the user's input as a 0 or a 1
        do {
            String userInput = getUserInput("(\"y\" or \"n\"): ");
            if (userInput.equals("n") || userInput.equals("N")) {
                yes = false;
                hasDecided = true;
            } else if (userInput.equals("y")||userInput.equals("Y")) {
                yes = true;
                hasDecided = true;
            }
        } while (!hasDecided);

        return yes;

    }

    private static void printDungeon(final ChamberShape shape,
    final ChamberContents contents, final Trap trap,
    final Treasure treasure) {
		// get the number of exits
		int numExits = shape.getExits().size();


		//print the chamberShape
		System.out.print("\nThe shape of the room is: " 
		+ shape.getShape());
		
		try {
			System.out.print("The size is: " + shape.getWidth()
			+ "x" + shape.getLength());
		} catch (UnusualShapeException e) {	
			System.out.println("The room is unusual");
		}
		
		System.out.println("This room has " + numExits + "exits.");
		
		System.out.println("Contents: " + contents.getDescription());
		
		System.out.println("Trap: " + trap.getDescription());
		
		System.out.println("Treasure: " + treasure.getDescription());
		
		System.out.println("The treasure is contained in: "
			+ treasure.getContainer());
		
		try {
			System.out.println("Treasure is protected by: " +
			treasure.getProtection());
		} catch (NotProtectedException e) {
			System.out.println("The treasure is not protected");
		}
		
		
		

    }


}
