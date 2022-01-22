import java.util.Objects;

public class BoardScanner {
    private Piece[][] board;

    public BoardScanner(Piece[][] board) {
        this.board = board;
    }

    public boolean checkExistenceOfAlliesOnDestination(String allianceColor, int column, int row) {
        Piece target = board[column][row];

        return !Objects.isNull(target) && target.getColor().equals(allianceColor);
    }

    public boolean checkExistenceOfEnemyOnDestination(String myColor, int column, int row) {
        Piece enemy = board[column][row];

        return !Objects.isNull(enemy) && !enemy.getColor().equals(myColor);
    }

    public boolean checkExistenceOfPieceOnForwardOrBackPath(int row, int sourceColumn, int destinationColumn) {
        int start = (sourceColumn < destinationColumn) ? sourceColumn + 1 : destinationColumn + 1;
        int end = Math.max(destinationColumn, sourceColumn);

        for (int i = start; i < end; i++) {
            if (checkExistenceOfPiece(i, row))
                return true;
        }
        return false;
    }

    public boolean checkExistenceOfPieceOnRightOrLeft(int column, int sourceRow, int destinationRow) {
        int start = (sourceRow < destinationRow) ? sourceRow + 1 : destinationRow + 1;
        int end = Math.max(destinationRow, sourceRow);

        for (int i = start; i < end; i++) {
            if (checkExistenceOfPiece(column, i))
                return true;
        }
        return false;
    }

    public boolean checkExistenceOfPiece(int column, int row) {
        return !Objects.isNull(board[column][row]);
    }

}
