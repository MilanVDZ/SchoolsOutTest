package service;

import java.util.Scanner;

public class SharedServices {

    private Scanner scanner;

    public SharedServices(){
        scanner = new Scanner(System.in);
    }

    public boolean yesNo() {
        String input;
        boolean keepOnGoing = true;
        do {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes"))
                keepOnGoing = true;
            else if (input.equalsIgnoreCase("no"))
                keepOnGoing = false;
        } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
        return keepOnGoing;
    }

    public long rightInput() {
        boolean rightInput;
        long id = 0;
        do {
            System.out.println("Insert Id");
            try {
                id = Integer.parseInt(scanner.next());
                scanner.nextLine();
                rightInput = true;
            } catch (NumberFormatException e) {
                rightInput = false;
                System.out.println("Id is not correct");
            }
        } while (!rightInput);
        return id;
    }

}