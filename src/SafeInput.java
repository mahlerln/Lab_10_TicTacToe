import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String input = "";
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
        } while (input.length() == 0);
        return input;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int number = 0;
        boolean isValid = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next();
            }
        } while (!isValid);
        pipe.nextLine();
        return number;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double number = 0.0;
        boolean isValid = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next();
            }
        } while (!isValid);
        pipe.nextLine();
        return number;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int number = 0;
        boolean isValid = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                if (number >= low && number <= high) {
                    isValid = true;
                } else {
                    System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next();
            }
        } while (!isValid);
        pipe.nextLine();
        return number;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double number = 0.0;
        boolean isValid = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                if (number >= low && number <= high) {
                    isValid = true;
                } else {
                    System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next();
            }
        } while (!isValid);
        pipe.nextLine();
        return number;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input = "";
        boolean isValid = false;
        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine();
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!isValid);
        return input.equalsIgnoreCase("Y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input = "";
        boolean isValid = false;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a value that matches the pattern: " + regEx);
            }
        } while (!isValid);
        return input;
    }

    public static void prettyHeader(String msg) {
        int width = 60;
        int stars = 3;
        int msgLength = msg.length();
        int padding = (width - msgLength - (2 * stars)) / 2;

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        if ((msgLength + (2 * stars)) % 2 != 0) {
            System.out.print(" ");
        }
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}