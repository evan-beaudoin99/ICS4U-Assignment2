import java.util.Scanner;

public class Main {

    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    public static String blowUp(String input) {
        StringBuilder newString = new StringBuilder();

        for (int counter1 = 0; counter1 < input.length(); counter1++) {
            if (isDigit(input.charAt(counter1))) {
                if (counter1 < input.length() - 1 && isDigit(input.charAt(counter1 + 1))) {
                    continue;
                } else {
                    int multiplier = Character.getNumericValue(input.charAt(counter1));
                    for (int counter2 = 0; counter2 < multiplier; counter2++) {
                        newString.append(input.charAt(counter1 + 1));
                    }
                }
            }
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String that you want to blow up: ");
        String input = scanner.nextLine();
        String newString = blowUp(input);
        System.out.println(newString);
    }
}
