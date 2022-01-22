public class Rook extends Piece {
    public Rook(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (destinationRow == currentRow) {
            return moveForwardOrBack(boardScanner, destinationColumn, destinationRow);
        } else if (destinationColumn == currentColumn) {
            return moveRightOrLeft(boardScanner, destinationColumn, destinationRow);
        }
        return false;
    }

    private boolean moveForwardOrBack(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (!boardScanner.checkExistenceOfPieceOnNorthOrSouthPath(currentRow, currentColumn, destinationColumn)) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        }
        return false;
    }

    private boolean moveRightOrLeft(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (!boardScanner.checkExistenceOfPieceOnEastOrWestPath(currentColumn, currentRow, destinationRow)) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        }

        return false;
    }
}
