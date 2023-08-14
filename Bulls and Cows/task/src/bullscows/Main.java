package bullscows;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidationService validationService = new ValidationService();
        String randomCode = "";
        try {
            System.out.println("Input the length of the secret code:");

            int secretCodeLength = validationService.getValidNumberFromInput(scanner.nextLine());
            System.out.println("Input the number of possible symbols in the code:");
            int nrOfPossibleSymbols = validationService.getValidNumberFromInput(scanner.nextLine());

            randomCode = RandomCodeGenerator.getRandomCode(secretCodeLength, nrOfPossibleSymbols);
            Printer printer = new Printer();
            printer.printStartGameInfo(secretCodeLength, nrOfPossibleSymbols);

            playGame(randomCode, scanner, printer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playGame(String randomNr, Scanner scanner, Printer printer) {
        int nrOfEndBulls = randomNr.length();
        int turn = 1;
        boolean gameIsOn = true;
        while (gameIsOn) {
            System.out.printf("Turn %d:%n", turn);
            String inputString = scanner.nextLine();
            String gradeResult = Grader.getGradeResult(inputString, randomNr);
            printer.printResult(gradeResult);
            if (Grader.getNrOfBulls() == nrOfEndBulls) {
                System.out.println("Congratulations! You guessed the secret code.");
                gameIsOn = false;
            }
            turn++;
        }
    }
}
