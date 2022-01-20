import java.util.HashMap;

public class Board {
    BoardScanner boardScanner;
    private Piece[][] board;

    public Board() {
        this.board = BoardSetting.initialBoard();
        boardScanner = new BoardScanner(this.board);
    }

    public boolean changePieceLocationOnBoard(HashMap<String, String> location) {
        HashMap<String, Integer> sourceLocation = BoardSetting.convertLocationToIndex(location.get("source"));
        HashMap<String, Integer> destinationLocation = BoardSetting.convertLocationToIndex(location.get("destination"));
        Piece piece = board[sourceLocation.get("column")][sourceLocation.get("row")];

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
