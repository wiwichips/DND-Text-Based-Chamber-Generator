package dnd;

import dnd.models.ChamberContents;
import dnd.models.ChamberShape;
import dnd.models.Trap;
import dnd.models.Treasure;
import dnd.exceptions.NotProtectedException;
import dnd.exceptions.UnusualShapeException;

// added a comment for the competency test

/**
@author Will Pringle
*/
public final class Dungeon {

    private Dungeon() {

    }

    /**
     * The main method for the program.
     *
     * @param args takes in a string
     */
    public static void main(final String[] args) {
        ChamberShape shape = new ChamberShape();
        ChamberContents contents = new ChamberContents();
        Trap trap = new Trap();
        Treasure treasure = new Treasure();
        int tempInput = 0;
        UserInputer inputer = new UserInputer();

        // Print welcome message and instructions
        printWelcome();

        // If the user wants to print out a random dungeon
        if (inputer.promptUserInputYesOrNo()) {
            shape.setShape();
            shape.setNumExits();
            contents.setDescription();
            trap.setDescription();
            treasure.setContainer();
            treasure.setDescription();

            printDungeon(shape, contents, trap, treasure);

        // if the user wants to pick each part of the dungeon
        } else {

            // prompt user for shape generation and print it
            System.out.println("Would you like to generate a shape?");
            if (inputer.promptUserInputYesOrNo()) {
                // surround in try catch because setShape(0) is bad
                try {
                    shape.setShape(inputer.promptD20Input("Set "
                    + "Shape: "));

                } catch (NullPointerException e) {
                    // random roll
                    shape.setShape();
                }

                // print the shape aspects of the room
                System.out.println("\nThe shape of the room is: "
                + shape.getShape());

                // surround in try ctch incase the room is unusual
                try {
                    System.out.print("The size of the room is: "
                    + shape.getWidth() + "x" + shape.getLength() + ".");
                } catch (UnusualShapeException e) {
                    // If the room is unusual, print that and not size
                    System.out.println(" The room is unusual");
                }
            }

            // prompt and print user for exits
            System.out.println("Would you like to generate "
            + "the exits?");
            if (inputer.promptUserInputYesOrNo()) {
                // ask for a roll
                tempInput = inputer.promptD20Input("Set Number of Exits: ");
                if (tempInput > 0) {
                    shape.setNumExits(tempInput);
                } else {
                    shape.setNumExits(); // random roll
                }

                // set the number of exits to the size of the array list
                int numExits = shape.getExits().size();

                // print the amount of exits
                System.out.println("This room has " + numExits + "exits.");

                // print the information of each exit
                for (int i = 0; i < numExits; i++) {
                    System.out.print("Exit #" + (i + 1) + " is located at ");
                    System.out.print(shape.getExits().get(i).getLocation());
                    System.out.print(" about ");
                    System.out.println(shape.getExits().get(i).getDirection());
                }
            }

            // prompt the user for contents generation and print it
            System.out.println("Would you like to generate the contents?");
            if (inputer.promptUserInputYesOrNo()) {
                // ask for roll
                tempInput = inputer.promptD20Input("Set Contents: ");
                if (tempInput > 0) {
                    contents.setDescription(tempInput);
                } else {
                    contents.setDescription(); // random roll
                }

                // print the contents of the room
                System.out.println("The contents of the room: "
                + contents.getDescription());
            }

            // prompt the user to generate the trap and print the trap
            System.out.println("Would you like to generate the trap?");
            if (inputer.promptUserInputYesOrNo()) {
                // ask for roll
                tempInput = inputer.promptD20Input("Set Trap: ");
                if (tempInput > 0) {
                    trap.setDescription(tempInput);
                } else {
                    trap.setDescription(); // random roll
                }

                // print the trap description
                System.out.println("The trap is: " + trap.getDescription());
            }

            // prompt the user to generate treasure container and print it
            System.out.println("Would you like to generate the treasure "
            + "container?");
            if (inputer.promptUserInputYesOrNo()) {
                // ask for roll
                tempInput = inputer.promptD20Input("Set Treasure container: ");
                if (tempInput > 0) {
                    treasure.setContainer(tempInput);
                } else {
                    treasure.setContainer(); // random roll
                }

                System.out.println("The treasure is contained in: "
                + treasure.getContainer());
            }

            System.out.println("Would you like to generate the Treasure?");
            if (inputer.promptUserInputYesOrNo()) {
                // ask for roll
                tempInput = inputer.promptD20Input("Set Treasure: ");
                if (tempInput > 0) {
                    treasure.setDescription(tempInput);
                } else {
                    treasure.setDescription(); // random roll
                }

                // print the treasure
                System.out.println("The treasure is: "
                + treasure.getDescription());

                try {
                    System.out.println("Treasure is protected by: "
                    + treasure.getProtection());
                } catch (NotProtectedException e) {
                    System.out.println("The treasure is not protected");
                }
            }
        }
    }

    /**
     * Prints the welcome message for the user.
     */
    private static void printWelcome() {
        System.out.println("Welcome to Will's Dungeon Generator!\n"
        + "Please refer to DND appendix a for the rolls.\nYou will"
        + " be prompted for rolls to enter for each option of the "
        + "dungeon. Enter a 0 for a random roll. Enjoy!\n\n"
        + "Do you want to randomly generate the entire dungeon?");
    }

    /**
     * Prints the dungeon if the user decides to
     * randomly generate the entire dungeon.
     * @param shape the Chamber shape.
     * @param contents the changer contents.
     * @param trap the trap.
     * @param treasure the treasure.
     */
    private static void printDungeon(final ChamberShape shape,
    final ChamberContents contents, final Trap trap,
    final Treasure treasure) {
        // get the number of exits
        int numExits = shape.getExits().size();


        //print the chamberShape
        System.out.print("\nThe shape of the room is: "
        + shape.getShape());

        try {
            System.out.print("The size of the room is: "
            + shape.getWidth() + "x" + shape.getLength() + ".");
        } catch (UnusualShapeException e) {
            System.out.println(" The room is unusual");
        }

        System.out.println("This room has " + numExits + "exits.");

        for (int i = 0; i < numExits; i++) {
            System.out.print("Exit #" + (i + 1) + " is located at ");
            System.out.print(shape.getExits().get(i).getLocation());
            System.out.print(" about ");
            System.out.println(shape.getExits().get(i).getDirection());
        }

        System.out.println("");

        System.out.println("The contents of the room: "
        + contents.getDescription());

        System.out.println("The trap is: " + trap.getDescription());

        System.out.println("The treasure is: "
        + treasure.getDescription());

        System.out.println("The treasure is contained in: "
        + treasure.getContainer());

        try {
            System.out.println("Treasure is protected by: "
            + treasure.getProtection());
        } catch (NotProtectedException e) {
            System.out.println("The treasure is not protected");
        }
    }
}
