import java.util.Scanner;

public abstract class ConsoleManagement {
    static Scanner consoleInput = new Scanner(System.in);

    public static void ClearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Templates should come in handy at one point
    public static int GetSafeInteger() {
        while (consoleInput.hasNext()) {
            if (consoleInput.hasNextInt())
                return consoleInput.nextInt();
            else
                consoleInput.next();
        }
        return 0;
    }

    public static double GetSafeDouble() {
        while (consoleInput.hasNext()) {
            if (consoleInput.hasNextDouble())
                return consoleInput.nextDouble();
            else
                consoleInput.next();
        }
        return 0;
    }

    public static char GetSafeChar() {
        while (consoleInput.hasNext()) {
            if (consoleInput.hasNextLine()){
                consoleInput.nextLine();
                return consoleInput.nextLine().charAt(0);
            }else
                consoleInput.next();
        }
        return 0;
    }
    // ---------------------------------------

    public static void WaitForUserInput() {
        System.out.println("\nVeuillez appuyer sur Entrée:");
        consoleInput.nextLine();
        while (!consoleInput.hasNextLine());
    }

    public static boolean YesNo() {
        System.out.println("(Y/N)");
        char userInput = 0;
        do {
            userInput = Character.toLowerCase(GetSafeChar());
        } while ((userInput != 'y') && (userInput != 'n'));

        return (userInput == 'y');
    }
}