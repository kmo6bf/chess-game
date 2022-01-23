import java.util.HashMap;

public class BoardSetting {
    private static Piece[][] board = new Piece[8][8];

    // 체스판 기물 초기 위치 세팅
    public static Piece[][] initialBoard() {
        board[0][0] = new Rook("white", 0, 0);
        board[0][7] = new Rook("white", 0, 7);

        board[0][1] = new Knight("white", 0, 1);
        board[0][6] = new Knight("white", 0, 6);

        board[0][2] = new Bishop("white", 0, 2);
        board[0][5] = new Bishop("white", 0, 5);

        board[0][3] = new Queen("white", 0, 3);

        board[0][4] = new King("white", 0, 4);

        board[7][0] = new Rook("black", 7, 0);
        board[7][7] = new Rook("black", 7, 7);

        board[7][1] = new Knight("black", 7, 1);
        board[7][6] = new Knight("black", 7, 6);

        board[7][2] = new Bishop("black", 7, 2);
        board[7][5] = new Bishop("black", 7, 5);

        board[7][3] = new Queen("black", 7, 3);

        board[7][4] = new King("black", 7, 4);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("white", 1, i);
            board[6][i] = new Pawn("black", 6, i);
        }

        return board;
    }

    // 사용자가 입력한 체스판 위치를 배열 인덱스로 변환
    public static HashMap<String, Integer> convertLocationToIndex(String location) {
        HashMap<String, Integer> index = new HashMap<>(2);
        int row = Integer.valueOf(location.charAt(0)) - 97;
        int column = Character.getNumericValue(location.charAt(1)) - 1;
        index.put("column", column);
        index.put("row", row);

        return index;
    }
}
