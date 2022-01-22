public class Bishop extends Piece {
    public Bishop(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(BoardScanner boardScanner, int destinationColumn, int destinationRow) {

        // 목적지가 현재위치를 기준으로 대각선을 나타내는지 체크
        if (!checkExceptionOfMovementOfBishop(destinationColumn, destinationRow))
            return false;

        if (destinationColumn > currentColumn) {
            return moveToForwardDiagonal(boardScanner, destinationColumn, destinationRow);
        } else if (destinationColumn < currentColumn) {
            return moveToBackDiagonal(boardScanner, destinationColumn, destinationRow);
        }

        return false;
    }

    private boolean moveToForwardDiagonal(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (destinationRow > currentRow && !boardScanner.checkExistenceOfPieceOnNortheastPath(currentColumn, currentRow, destinationColumn)) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        } else if (destinationRow < currentRow && !boardScanner.checkExistenceOfPieceOnNorthwestPath(currentColumn, currentRow, destinationColumn)) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        }
        return false;
    }

    private boolean moveToBackDiagonal(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (destinationRow > currentRow && !boardScanner.checkExistenceOfPieceOnSoutheastPath(currentColumn, currentRow, destinationColumn)) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        } else if (destinationRow < currentRow && !boardScanner.checkExistenceOfPieceOnSouthwestPath(currentColumn, currentRow, destinationColumn)) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        }
        return false;
    }

    private boolean checkExceptionOfMovementOfBishop(int destinationColumn, int destinationRow) {
        if (destinationColumn == currentColumn || destinationRow == currentRow) {
            return false;
        } else return Math.abs(destinationColumn - currentColumn) == Math.abs(destinationRow - currentRow);
    }
}
