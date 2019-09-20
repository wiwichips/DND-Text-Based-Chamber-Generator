package dnd;
import java.util.Scanner;

public class UserInputer {

    /**
     *  Contains the user's input as a string.
     */
    private String userInput;

    /**
     * Contains the user's input as an integer.
     */
    private int userInputAsInteger;

    /**
     * Contains the user's input as a boolean.
     */
    private boolean userInputAsBoolean;

    /**
     * Constructor.
     */
    public UserInputer() {

    }

    /**
     * Gives the user the string of the input.
     * @return userInput
     */
    public String getUserInput() {
        return userInput;
    }

    /**
     * Gives the user the integer of the input.
     * @return userInputAsInteger
     */
    public int getUserInputAsInteger() {
        return userInputAsInteger;
    }

    /**
     * Gives the user the integer of the input.
     * @return userInputAsInteger
     */
    public boolean getUserInputAsBoolean() {
        return userInputAsBoolean;
    }

    /**
     * Prompts the user for input and takes that in as
     * a string.
     * @param prompt the string the user sees when input
     * is taken.
     * @return userInput the string.
     */
    public String promptUserInput(final String prompt) {
        // create scanner object to use for input
        Scanner inputReader = new Scanner(System.in);

        // print the prompt
        System.out.print(prompt);

        // return a string of the user's input
        userInput = inputReader.nextLine();
        return userInput;

    }

    /**
     * Prompts the user for a new roll between 0 to 20.
     * @param prompt the string the user sees when input.
     * @return input an integer of the user input.
     */
    public int promptD20Input(final String prompt) {

        int input = promptInputAsInteger(prompt);
        boolean hasValidInput = false;
        int lower = 0;
        int upper = 20;

        do {

            if (input >= lower && input <= upper) {
                hasValidInput = true;
                userInputAsInteger = input;
                return input;
            }
            System.out.println("Please enter a number between 1"
                + "and 20 or 0 for a random D20 roll");
            input = promptInputAsInteger(prompt);

        } while (!hasValidInput);

        return input;
    }

    /**
     * Prompts the user for an integer.
     * @param prompt the string the user sees when input.
     * @return roll an integer number
     */
    public int promptInputAsInteger(final String prompt) {
        int roll = 0;
        String input;


        do {
            try {
                input = promptUserInput(prompt);
                roll = Integer.parseInt(input);
                userInputAsInteger = roll;
                return roll;

            } catch (Exception e) { // change to NumberFormatException
                System.out.println("Please enter a number");
            }

        } while (true);
    }

    /**
     * Prompts to answer a yes or no question with y or n.
     * @return yes a boolean that is true when user types y.
     */
    public boolean promptUserInputYesOrNo() {
        boolean yes = false;
        boolean hasDecided = false;

        // returns the user's input as a 0 or a 1
        do {
            String input = promptUserInput("(\"y\" or \"n\"): ");
            if (input.equals("n") || input.equals("N")) {
                yes = false;
                userInputAsBoolean = false;
                hasDecided = true;
            } else if (input.equals("y") || input.equals("Y")) {
                yes = true;
                userInputAsBoolean = true;
                hasDecided = true;
            }
        } while (!hasDecided);

        return yes;

    }
}
