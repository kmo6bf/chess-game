import java.util.Objects;

public class BoardScanner {
    private Piece[][] board;

    public BoardScanner(Piece[][] board) {
        this.board = board;
    }

    // 목적지에 아군 기물이 존재하는지 체크
    public boolean checkExistenceOfAlliesOnDestination(String allianceColor, int column, int row) {
        Piece target = board[column][row];

        return !Objects.isNull(target) && target.getColor().equals(allianceColor);
    }

    // 목적지에 적 기물이 존재하는지 체크 (폰 기물을 위해 제작)
    public boolean checkExistenceOfEnemyOnDestination(String myColor, int column, int row) {
        Piece enemy = board[column][row];

        return !Objects.isNull(enemy) && !enemy.getColor().equals(myColor);
    }

    // 상/하 이동 경로에 기물이 존재하는지 체크
    public boolean checkExistenceOfPieceOnNorthOrSouthPath(int row, int sourceColumn, int destinationColumn) {
        int start = (sourceColumn < destinationColumn) ? sourceColumn + 1 : destinationColumn + 1;
        int end = Math.max(destinationColumn, sourceColumn);

        for (int i = start; i < end; i++) {
            if (checkExistenceOfPiece(i, row))
                return true;
        }
        return false;
    }

    // 좌/우 이동 경로에 기물이 존재하는지 체크
    public boolean checkExistenceOfPieceOnEastOrWestPath(int column, int sourceRow, int destinationRow) {
        int start = (sourceRow < destinationRow) ? sourceRow + 1 : destinationRow + 1;
        int end = Math.max(destinationRow, sourceRow);

        for (int i = start; i < end; i++) {
            if (checkExistenceOfPiece(column, i))
                return true;
        }
        return false;
    }

    // 북동쪽(대각선) 경로에 기물이 존재하는지 체크
    public boolean checkExistenceOfPieceOnNortheastPath(int sourceColumn, int sourceRow, int destinationColumn) {
        for (int i = (sourceColumn + 1), j = (sourceRow + 1); i < destinationColumn; i++, j++) {
            if (checkExistenceOfPiece(i, j))
                return true;
        }
        return false;
    }

    // 북서쪽(대각선) 경로에 기물이 존재하는지 체크
    public boolean checkExistenceOfPieceOnNorthwestPath(int sourceColumn, int sourceRow, int destinationColumn) {
        for (int i = (sourceColumn + 1), j = (sourceRow - 1); i < destinationColumn; i++, j--) {
            if (checkExistenceOfPiece(i, j))
                return true;
        }
        return false;
    }

    // 남동쪽(대각선) 경로에 기물이 존재하는지 체크
    public boolean checkExistenceOfPieceOnSoutheastPath(int sourceColumn, int sourceRow, int destinationColumn) {
        for (int i = (sourceColumn - 1), j = (sourceRow + 1); i > destinationColumn; i--, j++) {
            if (checkExistenceOfPiece(i, j))
                return true;
        }
        return false;
    }

    // 남서쪽(대각선) 경로에 기물이 존재하는지 체크
    public boolean checkExistenceOfPieceOnSouthwestPath(int sourceColumn, int sourceRow, int destinationColumn) {
        for (int i = (sourceColumn - 1), j = (sourceRow - 1); i > destinationColumn; i--, j--) {
            if (checkExistenceOfPiece(i, j))
                return true;
        }
        return false;
    }

    // 특정 위치에 기물이 존재하는지 체크
    public boolean checkExistenceOfPiece(int column, int row) {
        return !Objects.isNull(board[column][row]);
    }

}
