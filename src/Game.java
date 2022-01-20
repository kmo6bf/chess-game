public class Game {
    public void play() {
        System.out.println("================== Welcome To Chess Game!! ==================");
        Board board = new Board();
        Player blackPlayer = new Player("black");
        Player whitePlayer = new Player("white");

        for (int i = 1; i <= 20; i++) {
            playingPhase((i % 2 != 0 ? whitePlayer : blackPlayer), board);
        }

        System.out.println("Game Over!");
    }

    public void playingPhase(Player player, Board board) {
        board.displayingBoard();
        System.out.println(player.getPlayerColor() + "의 차례입니다!");

        while (!board.changePieceLocationOnBoard(player.inputStrategyOfPlayer())) {
            System.out.println("잘못된 수입니다!!!");
        }
    }
}
