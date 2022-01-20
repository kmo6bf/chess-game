public class Rook extends Piece {
    public Rook(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(BoardScanner boardScanner, int column, int row) {

        return false;
    }
}
