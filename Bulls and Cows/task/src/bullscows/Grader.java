package bullscows;


public class Grader {

    private static int nrOfBulls;
    private static int nrOfCows;


    public static String getGradeResult(String inputString, String secretCode) {
        calculateBullNumber(inputString, secretCode);
        calculateCowNumber(inputString, secretCode);
        boolean isBull = getNrOfBulls() > 0;
        boolean isCow = getNrOfCows() > 0;
        if (isBull && isCow) {
            return nrOfBulls + " bull(s) and " + nrOfCows + " cow(s)\n";
        } else if (isBull) {
            return nrOfBulls + " bull(s)\n";
        } else if (isCow) {
            return nrOfCows + " cow(s)\n";
        } else {
            return "None\n";
        }
    }




    private static void calculateBullNumber(String inputString, String secretCode) {
        String[] inputSplit = inputString.split("");
        String[] secretCodeSplit = secretCode.split("");
        int bulls = 0;
        for (int i = 0; i < secretCodeSplit.length; i++) {
            if (secretCodeSplit[i].equals(inputSplit[i])) {
                bulls++;
            }
        }
        setNrOfBulls(bulls);
    }

    private static void calculateCowNumber(String inputString, String secretCode) {
        String[] inputSplit = inputString.split("");
        int cows = 0;
        for (int i = 0; i < inputSplit.length; i++) {
            if (secretCode.contains(inputSplit[i])) {
                cows++;
            }
        }
        setNrOfCows(cows - getNrOfBulls());
    }

    public static int getNrOfBulls() {
        return nrOfBulls;
    }

    private static void setNrOfBulls(int nrOfBulls) {
        Grader.nrOfBulls = nrOfBulls;
    }

    public static int getNrOfCows() {
        return nrOfCows;
    }

    private static void setNrOfCows(int nrOfCows) {
        Grader.nrOfCows = nrOfCows;
    }
}
