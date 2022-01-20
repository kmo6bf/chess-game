public class Pawn extends Piece {
    public Pawn(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(int column, int row) {
        if (row == currentRow && column - 1 == currentColumn) {
            currentColumn = column;
            return true;
        }
        return false;
    }
}
