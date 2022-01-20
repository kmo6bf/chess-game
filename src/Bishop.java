public class Bishop extends Piece {
    public Bishop(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(int column, int row) {
        return false;
    }
}
