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
    public boolean move(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (currentRow != destinationRow) {
            return attack(boardScanner, destinationColumn, destinationRow);
        }

        // 폰이 이동하는 경로에 기물이 존재하는지 체크
        if (!checkExceptionOfMovementOfPawn(boardScanner)) {
            return false;
        }

        if (currentRow == initialRow && currentColumn == initialColumn && moveTwoSpaceForward(boardScanner, destinationColumn, destinationRow))
            return true;

        return moveOneSpaceForward(destinationColumn, destinationRow);
    }

    private boolean moveOneSpaceForward(int destinationColumn, int destinationRow) {
        if (Objects.equals(color, "white")) {
            if (destinationColumn == currentColumn + 1) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        } else if (Objects.equals(color, "black")) {
            if (destinationColumn == currentColumn - 1) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        }

        return false;
    }

    private boolean moveTwoSpaceForward(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (Objects.equals(color, "white")) {
            if (destinationColumn == currentColumn + 2 && !boardScanner.checkExistenceOfPiece(currentColumn + 2, destinationRow)) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        } else if (Objects.equals(color, "black")) {
            if (destinationColumn == currentColumn - 2 && !boardScanner.checkExistenceOfPiece(currentColumn - 2, destinationRow)) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        }

        return false;
    }

    private boolean attack(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (boardScanner.checkExistenceOfEnemyOnDestination(color, destinationColumn, destinationRow) && ((destinationRow == currentRow - 1) || (destinationRow == currentRow + 1))) {

            if ((color.equals("white") && destinationColumn == currentColumn + 1) || (color.equals("black") && destinationColumn == currentColumn - 1)) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        }
        return false;
    }

    private boolean checkExceptionOfMovementOfPawn(BoardScanner boardScanner) {
        if (color.equals("white")) {
            if (boardScanner.checkExistenceOfPiece(currentColumn + 1, currentRow))
                return false;
        } else if (color.equals("black")) {
            if (boardScanner.checkExistenceOfPiece(currentColumn - 1, currentRow))
                return false;
        }
        return true;
    }
}
