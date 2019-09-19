package dnd;

import java.util.Scanner;
import dnd.models.*;

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
		
		if(getUserInputYesOrNo()) {
			shape.setShape();
			shape.setNumExits();
			contents.setDescription();
			trap.setDescription();
			treasure.setContainer();
			treasure.setDescription();
			
		} else {	
			shape.setShape(getInputAsInteger("Set Shape: "));
			shape.setNumExits(getInputAsInteger("Set Number of Exits: "));
			contents.setDescription(getInputAsInteger("Set Contents: "));
			trap.setDescription(getInputAsInteger("Set Trap: "));
			treasure.setContainer(getInputAsInteger("Set treasure container: "));
			treasure.setDescription(getInputAsInteger("Set treasure: "));
			
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
	
	private static int getInputAsInteger(final String prompt){
		return Integer.parseInt(getUserInput(prompt));
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
            } else if (userInput.equals("y") || userInput.equals("Y")) {
                yes = true;
                hasDecided = true;
            }
        } while (!hasDecided);

        return yes;

    }

	private static void printDungeon(ChamberShape shape,
	ChamberContents contents, Trap trap, Treasure treasure){
		
		
		
	}


}
