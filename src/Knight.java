public class Knight extends Piece {
    public Knight(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(BoardScanner boardScanner, int column, int row) {
        return false;
    }
}