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
        if (boardScanner.checkExistenceOfAlliesOnDestination(color, column, row))
            return false;

        if (currentRow == initialRow && currentColumn == initialColumn) {
            if (moveTwoSpaceForward(column, row))
                return true;
        }

        return moveOneSpaceForward(column, row);
    }

    private boolean moveOneSpaceForward(int column, int row) {
        if (currentRow != row)
            return false;

        if ((this.color == "white" && column == currentColumn + 1) || (this.color == "black" && column == currentColumn - 1)) {
            applyChangeLocation(column, row);
            return true;
        }
        return false;
    }

    private boolean moveTwoSpaceForward(int column, int row) {
        if (currentRow != row)
            return false;

        if ((this.color == "white" && column == currentColumn + 2) || (this.color == "black" && column == currentColumn - 2)) {
            applyChangeLocation(column, row);
            return true;
        }
        return false;
    }

}
