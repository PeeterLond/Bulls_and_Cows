package bullscows;

import java.util.ArrayList;
import java.util.Random;

public class RandomCodeGenerator {

    public static String getRandomCode(int secretCodeLength, int nrOfSymbolsInCode) throws Exception {
        ValidationService validationService = new ValidationService();
        validationService.validateCodeLength(secretCodeLength, nrOfSymbolsInCode);
        return generateRandomCode(secretCodeLength, nrOfSymbolsInCode);
    }

    private static String generateRandomCode(int secretCodeLength, int nrOfSymbolsInCode) {
        String availableList = getAvailableList(nrOfSymbolsInCode);
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Character> randomCharList = new ArrayList<>();
        while (secretCodeLength > 0) {
            char nextRandomChar = availableList.charAt(random.nextInt(nrOfSymbolsInCode));
            if (randomCharList.contains(nextRandomChar)) {
                continue;
            }
            randomCharList.add(nextRandomChar);
            secretCodeLength--;
        }

        for (Character character : randomCharList) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    public static String getAvailableList(int nrOfSymbolsInCode) {
        StringBuilder stringBuilder = new StringBuilder();
        int beginningOfNrAscii = 48;
        for (int i = beginningOfNrAscii; nrOfSymbolsInCode > 0; i++) {
            if (i == 58) {
                i = 97;
            }
            stringBuilder.append((char) i);
            nrOfSymbolsInCode--;
        }
        return stringBuilder.toString();
    }
}
