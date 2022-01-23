import java.util.Objects;

public class Pawn extends Piece {
    // 폰의 초기 행/영
    int initialColumn;
    int initialRow;

    public Pawn(String color, int currentColumn, int currentRow) {
        super(color, currentColumn, currentRow);
        initialColumn = currentColumn;
        initialRow = currentRow;
    }

    @Override
    public boolean move(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        // 폰의 목적지 열이 현재 열과 다르면 공격 의도로 간주
        if (currentRow != destinationRow) {
            return attack(boardScanner, destinationColumn, destinationRow);
        }

        // 폰에서 발생하는 예외상황 체크
        if (!checkExceptionOfMovementOfPawn(boardScanner)) {
            return false;
        }

        // 폰이 초기위치이면서 두 칸 이동시
        if (currentRow == initialRow && currentColumn == initialColumn && moveTwoSpaceForward(boardScanner, destinationColumn, destinationRow))
            return true;

        // 폰이 한 칸 이동 할 경우
        return moveOneSpaceForward(destinationColumn, destinationRow);
    }

    private boolean moveOneSpaceForward(int destinationColumn, int destinationRow) {
        if (Objects.equals(color, "white")) {
            if (destinationColumn == currentColumn + 1) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        } else if (Objects.equals(color, "black")) {
            if (destinationColumn == currentColumn - 1) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        }

        return false;
    }

    private boolean moveTwoSpaceForward(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (Objects.equals(color, "white")) {
            if (destinationColumn == currentColumn + 2 && !boardScanner.checkExistenceOfPiece(currentColumn + 2, destinationRow)) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        } else if (Objects.equals(color, "black")) {
            if (destinationColumn == currentColumn - 2 && !boardScanner.checkExistenceOfPiece(currentColumn - 2, destinationRow)) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        }

        return false;
    }

    private boolean attack(BoardScanner boardScanner, int destinationColumn, int destinationRow) {
        if (boardScanner.checkExistenceOfEnemyOnDestination(color, destinationColumn, destinationRow) && ((destinationRow == currentRow - 1) || (destinationRow == currentRow + 1))) {

            if ((color.equals("white") && destinationColumn == currentColumn + 1) || (color.equals("black") && destinationColumn == currentColumn - 1)) {
                applyChangeLocation(destinationColumn, destinationRow);
                return true;
            }
        }
        return false;
    }


    private boolean checkExceptionOfMovementOfPawn(BoardScanner boardScanner) {
        // 색상별로 폰이 후진하지 못하도록 제한
        if (color.equals("white")) {
            if (boardScanner.checkExistenceOfPiece(currentColumn + 1, currentRow))
                return false;
        } else if (color.equals("black")) {
            if (boardScanner.checkExistenceOfPiece(currentColumn - 1, currentRow))
                return false;
        }
        return true;
    }
}
