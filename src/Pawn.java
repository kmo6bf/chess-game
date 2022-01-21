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

        // 폰이 이동하는 경로에 기물이 존재하는지 체크
        if (!checkExceptionOfMovementOfPawn(boardScanner)) {
            return false;
        }

        if (currentRow == initialRow && currentColumn == initialColumn && moveTwoSpaceForward(boardScanner, column, row))
            return true;

        return moveOneSpaceForward(column, row);
    }

    private boolean moveOneSpaceForward(int column, int row) {
        if (Objects.equals(color, "white")) {
            if (column == currentColumn + 1) {
                applyChangeLocation(column, row);
                return true;
            }
        } else if (Objects.equals(color, "black")) {
            if (column == currentColumn - 1) {
                applyChangeLocation(column, row);
                return true;
            }
        }

        return false;
    }

    private boolean moveTwoSpaceForward(BoardScanner boardScanner, int column, int row) {
        if (Objects.equals(color, "white")) {
            if (column == currentColumn + 2 && !boardScanner.checkExistenceOfPiece(currentColumn + 2, row)) {
                applyChangeLocation(column, row);
                return true;
            }
        } else if (Objects.equals(color, "black")) {
            if (column == currentColumn - 2 && !boardScanner.checkExistenceOfPiece(currentColumn - 2, row)) {
                applyChangeLocation(column, row);
                return true;
            }
        }

        return false;
    }

    private boolean attack(BoardScanner boardScanner, int column, int row) {
        if (boardScanner.checkExistenceOfEnemyOnDestination(color, column, row) && ((row == currentRow - 1) || (row == currentRow + 1))) {

            if ((color.equals("white") && column == currentColumn + 1) || (color.equals("black") && column == currentColumn - 1)) {
                applyChangeLocation(column, row);
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
