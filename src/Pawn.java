import java.util.Objects;

public class Pawn extends Piece {
    int initialColumn;
    int initialRow;

    public Pawn(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
        initialColumn = currentColumn;
        initialRow = currentRow;
    }

    @Override
    public boolean move(BoardScanner boardScanner, int column, int row) {
        if (currentRow != row) {
            return attack(boardScanner, column, row);
        }

        if (!checkForMovementExceptions(boardScanner, column, row))
            return false;

        if (currentRow == initialRow && currentColumn == initialColumn && moveTwoSpaceForward(column, row))
            return true;

        return moveOneSpaceForward(column, row);
    }

    private boolean moveOneSpaceForward(int column, int row) {
        if ((Objects.equals(this.color, "white") && column == currentColumn + 1) || (Objects.equals(this.color, "black") && column == currentColumn - 1)) {
            applyChangeLocation(column, row);
            return true;
        }
        return false;
    }

    private boolean moveTwoSpaceForward(int column, int row) {
        if (currentRow != row)
            return false;

        if ((Objects.equals(this.color, "white") && column == currentColumn + 2) || (Objects.equals(this.color, "black") && column == currentColumn - 2)) {
            applyChangeLocation(column, row);
            return true;
        }
        return false;
    }

    private boolean checkForMovementExceptions(BoardScanner boardScanner, int column, int row) {
        return !boardScanner.checkExistenceOfAlliesOnDestination(color, column, row);
    }

    private boolean attack(BoardScanner boardScanner, int column, int row) {
        if (boardScanner.checkExistenceOfEnemyOnDestination(color, column, row) && (row == currentRow - 1 || row == currentRow + 1)) {
            return (color.equals("white") && column == currentColumn + 1) || (color.equals("black") && column == currentColumn - 1);
        }
        return false;
    }
}
