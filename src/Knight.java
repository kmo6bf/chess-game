public class Knight extends Piece {
    public Knight(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
    }

    @Override
    public boolean move(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (Math.abs(destinationColumn - currentColumn) == 2) {
            return moveForwardOrBack(destinationColumn, destinationRow);
        } else if (Math.abs(destinationRow - currentRow) == 2) {
            return moveRightOrLeft(destinationColumn, destinationRow);
        }

        return false;
    }

    // 전방으로 이동
    private boolean moveForwardOrBack(int destinationColumn, int destinationRow) {
        if (Math.abs(destinationRow - currentRow) == 1) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        }

        return false;
    }

    // 후방으로 이동
    private boolean moveRightOrLeft(int destinationColumn, int destinationRow) {
        if (Math.abs(destinationColumn - currentColumn) == 1) {
            applyChangeLocation(destinationColumn, destinationRow);
            return true;
        }

        return false;
    }
}
