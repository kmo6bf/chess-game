public abstract class Piece {
    private final String color;
    protected int currentColumn;
    protected int currentRow;

    public Piece(String color, int currentColumn, int currentRow) {
        this.color = color;
        this.currentColumn = currentColumn;
        this.currentRow = currentRow;
    }

    public abstract boolean move(int column, int row);

    @Override
    public String toString() {
        return String.format("Color : %s  Piece : %s", color, this.getClass().getSimpleName());
    }

    public String getKind() {
        return this.getClass().getSimpleName();
    }

    public String getColor() {
        return color;
    }


}
