package bullscows;

public class ValidationService {


    private static final int MAX_CODE_LENGTH = 36;


    public void validateCodeLength(int secretCodeLength, int nrOfSymbolsInCode) throws Exception {
        if (secretCodeLength == 0) {
            throw new Exception("Error: to play the game, the secret code length can't be 0.");
        }
        if (secretCodeLength > MAX_CODE_LENGTH ||nrOfSymbolsInCode > MAX_CODE_LENGTH) {
            throw new Exception("Error: can't generate a secret code with a length of "
                    + secretCodeLength + " because there aren't enough unique digits and characters.");
        }
        if (nrOfSymbolsInCode < secretCodeLength) {
            throw new Exception("Error: can't generate a secret code with " + nrOfSymbolsInCode +
                    " symbols, because it's less than the code length of " + secretCodeLength);
        }
    }
    public int getValidNumberFromInput(String inputNumber) throws Exception {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new Exception("Error: \"" + inputNumber + "\" isn't a valid number.");
        }
    }
}
