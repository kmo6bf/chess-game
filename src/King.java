public class King extends Piece {
    public King(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(BoardScanner boardScanner, int column, int row) {
        return false;
    }
}