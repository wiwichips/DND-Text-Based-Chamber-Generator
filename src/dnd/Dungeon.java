package dnd;

import java.util.Scanner;

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
        String tempInput;


        System.out.println("Welcome to Will's Dungeon Generator!\n"
        + "--------------------------------------------------");

        do {
            System.out.println("Do you want to randomly generate"
            + "the room");
            ////////////////////////////////////////////////////////
            tempInput = getUserInput("(\"y\" or \"n\")");


            System.out.print("Do you want to randomly generate the"
            + "size of the chamber?\n(\"y\" or \"n\"): ");



            System.out.println("Type in and enter \"q\" if you"
            + "would like to quit");
        } while (!getUserInput("q to quit").equals("q"));

    }


    private static String getUserInput(final String prompt) {
        // create scanner object to use for input
        Scanner inputReader = new Scanner(System.in);

        // print the prompt
        System.out.println(prompt);

        // return a string of the user's input
        return inputReader.nextLine();

    }

    private static int getUserInputYesOrNo() {
        // call the getUserInput method
        String userInput = getUserInput("(\"y\" or \"n\")");

        // returns the user's input as a 0 or a 1 
        if (userInput.equals("n") || userInput.equals("N")) {
            return 0;
        } else if (userInput.equals("y") || userInput.equals("Y")) {
            return 1;
        }

        return -1;
    }


}
