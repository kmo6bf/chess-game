public class King extends Piece {
    public King(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(BoardScanner boardScanner, int destinationColumn, int destinationRow) {

        // 상/하/좌/우 일직선으로 이동하는 경우
        // 한칸만 이동하는지 체크
        if (destinationColumn == currentColumn && Math.abs(destinationRow - currentRow) == 1) {
            return moveRightOrLeft(boardScanner, destinationColumn, destinationRow);
        } else if (destinationRow == currentRow && Math.abs(destinationColumn - currentColumn) == 1) {
            return moveForwardOrBack(boardScanner, destinationColumn, destinationRow);
        }

        // 대각선 방향으로 이동하는 경우
        // 목적지가 현재위치에서 대각선 방향인지 체크
        // 한칸만 이동하는지 체크
        if ((Math.abs(destinationColumn - currentColumn) == 1 && Math.abs(destinationRow - currentRow) == 1)) {
            if (destinationColumn > currentColumn) {
                return moveToForwardDiagonal(boardScanner, destinationColumn, destinationRow);
            } else {
                return moveToBackDiagonal(boardScanner, destinationColumn, destinationRow);
            }
        }

        return false;
    }

    // 상/하 일직선으로 이동
    private boolean moveForwardOrBack(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (!boardScanner.checkExistenceOfPieceOnNorthOrSouthPath(currentRow, currentColumn, destinationColumn)) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        }
        return false;
    }

    // 좌/우 일직선으로 이동
    private boolean moveRightOrLeft(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (!boardScanner.checkExistenceOfPieceOnEastOrWestPath(currentColumn, currentRow, destinationRow)) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        }

        return false;
    }

    // 전방 대각선으로 이동
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

    // 후방 대각선으로 이동
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
}
