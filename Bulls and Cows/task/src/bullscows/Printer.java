package bullscows;

public class Printer {

    void printStartGameInfo(int secretCodeLength, int nrOfPossibleSymbols) {
        String stringAsStars = getStringAsStars(secretCodeLength);
        String usedCharsString = getUsedCharsString(nrOfPossibleSymbols);

        System.out.println("The secret is prepared: " + stringAsStars + " " + usedCharsString);
        System.out.println("Okay, let's start a game!");
    }

    private String getUsedCharsString(int nrOfPossibleSymbols) {
        String availableList = RandomCodeGenerator.getAvailableList(nrOfPossibleSymbols);
        String usedCharString = "";
        if (availableList.length() == 1) {
            usedCharString = "(" + availableList.charAt(0) + ").";
        } else if (availableList.length() > 1 && availableList.length() < 11) {
            usedCharString = "(0-" + availableList.charAt(availableList.length() - 1) + ").";
        } else if (availableList.length() == 11) {
            usedCharString = "(0-9, " + availableList.charAt(availableList.length() - 1) + ").";
        } else {
            usedCharString = "(0-9, a-" + availableList.charAt(availableList.length() - 1) + ").";
        }
        return usedCharString;
    }

    private String getStringAsStars(int secretCodeLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < secretCodeLength; i++) {
            stringBuilder.append("*");
        }
        return stringBuilder.toString();
    }


    void printResult(String gradeResult) {
        System.out.printf("Grade: %s",gradeResult);
    }
}
