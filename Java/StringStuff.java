/*
* This program blows up a string into letters.
*
* @author Evan Beaudoin
* @version 1.0
* @since 2024-04-02
*/

import java.util.Scanner;

/**
* This is the program.
*/
final class StringStuff {
    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private StringStuff() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Checks if a character is a digit.
    *
    * @param character the character to check
    * @return true if the character is a digit, false otherwise
    */
    public static boolean isDigit(char character) {
        return Character.isDigit(character);
    }

    /**
    * Blows up the input string based on numeric multipliers.
    *
    * @param input the string to blow up
    * @return the blown-up string
    */
    public static String blowUp(String input) {
        final StringBuilder newString = new StringBuilder();

        String returnValue;

        if (input == null || input.isEmpty() || input.length() == 1
              || isDigit(input.charAt(input.length() - 1))) {
            returnValue = "Invalid String";
        }

        for (int i = 0; i < input.length(); i++) {
            if (isDigit(input.charAt(i))) {
                if (i < input.length() - 1 && isDigit(input.charAt(i + 1))) {
                    continue;
                } else {
                    final int multiplier =
                        Character.getNumericValue(input.charAt(i));
                    for (int j = 0; j < multiplier; j++) {
                        newString.append(input.charAt(i + 1));
                    }
                }
            }
        }
        returnValue = newString.toString();
        return returnValue;
    }

    /**
    * Main method to run the program.
    *
    * @param args command-line arguments (not used)
    */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String that you want to blow up: ");
        final String input = scanner.nextLine();
        final String result = blowUp(input);
        System.out.println(result);
        scanner.close();
    }
}
