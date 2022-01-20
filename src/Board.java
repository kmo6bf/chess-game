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
                sb.append(" " + presentationPiece(board[i][j]) + " |");
            }
            sb.append("\n  ---------------------------------\n");
        }
        sb.append("    A   B   C   D   E   F   G   H\n");
        System.out.println(sb);
    }

    private String presentationPiece(Piece p) {
        if (p == null)
            return " ";

        switch (p.getKind()) {
            case "King":
                return (p.getColor().equals("white")) ? "♔" : "♚";
            case "Queen":
                return (p.getColor().equals("white")) ? "♕" : "♛";
            case "Bishop":
                return (p.getColor().equals("white")) ? "♗" : "♝";
            case "Knight":
                return (p.getColor().equals("white")) ? "♘" : "♞";
            case "Rook":
                return (p.getColor().equals("white")) ? "♖" : "♜";
            case "Pawn":
                return (p.getColor().equals("white")) ? "♙" : "♟";
        }
        return " ";
    }
}
