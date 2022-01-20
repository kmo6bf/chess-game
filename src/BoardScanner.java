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

}
