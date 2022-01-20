public class Rule {
    public boolean checkPlayerInputIsValid(String playerInput) {
        char rowValue = playerInput.charAt(0);
        String columnValue = playerInput.substring(1);

        return checkPlayerInputColumnIsValid(columnValue) && checkPlayerInputRowIsValid(rowValue);
    }

    private boolean checkPlayerInputRowIsValid(char rowValue) {
        return (65 <= (int) rowValue && (int) rowValue <= 72) || (97 <= (int) rowValue && (int) rowValue <= 104);
    }

    private boolean checkPlayerInputColumnIsValid(String columnValue) {
        try {
            return (1 <= Integer.valueOf(columnValue) && Integer.valueOf(columnValue) <= 8);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
