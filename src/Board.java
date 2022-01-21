import java.util.HashMap;

public class Board {
    BoardScanner boardScanner;
    private Piece[][] board;

    public Board() {
        this.board = BoardSetting.initialBoard();
        boardScanner = new BoardScanner(this.board);
    }

    public boolean changePieceLocationOnBoard(String location) {
        Piece piece;
        // 출발지 위치
        HashMap<String, Integer> sourceLocation = BoardSetting.convertLocationToIndex(location.split(" ")[0]);
        // 도착지 위치
        HashMap<String, Integer> destinationLocation = BoardSetting.convertLocationToIndex(location.split(" ")[1]);

        piece = board[sourceLocation.get("column")][sourceLocation.get("row")];

        // 목적지에 아군 기물이 존재하는지 체크
        if (boardScanner.checkExistenceOfAlliesOnDestination(piece.getColor(), destinationLocation.get("column"), destinationLocation.get("row")))
            return false;

        // 출발지에 기물이 존재하는지 체크
        if (!boardScanner.checkExistenceOfPiece(sourceLocation.get("column"), sourceLocation.get("row")))
            return false;


        // 기물의 이동이 유효한지 체크
        if (!piece.move(boardScanner, destinationLocation.get("column"), destinationLocation.get("row"))) {
            return false;
        }

        board[destinationLocation.get("column")][destinationLocation.get("row")] = piece;
        board[sourceLocation.get("column")][sourceLocation.get("row")] = null;

        return true;
    }

    public void displayingBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ---------------------------------\n");
        for (int i = 7; i >= 0; i--) {
            sb.append(i + 1 + " |");
            for (int j = 0; j < 8; j++) {
                sb.append(" " + presentationPieceAsIcon(board[i][j]) + " |");
            }
            sb.append("\n  ---------------------------------\n");
        }
        sb.append("    A   B   C   D   E   F   G   H\n");
        System.out.println(sb);
    }

    private String presentationPieceAsIcon(Piece p) {
        if (p == null)
            return " ";

        return switch (p.getKind()) {
            case "King" -> (p.getColor().equals("white")) ? "♔" : "♚";
            case "Queen" -> (p.getColor().equals("white")) ? "♕" : "♛";
            case "Bishop" -> (p.getColor().equals("white")) ? "♗" : "♝";
            case "Knight" -> (p.getColor().equals("white")) ? "♘" : "♞";
            case "Rook" -> (p.getColor().equals("white")) ? "♖" : "♜";
            case "Pawn" -> (p.getColor().equals("white")) ? "♙" : "♟";
            default -> " ";
        };
    }
}
