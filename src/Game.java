public class Game {
    public void play() {
        System.out.println("================== Welcome To Chess Game!! ==================");
        Board board = new Board();
        Rule rule = new Rule();
        Player blackPlayer = new Player("black");
        Player whitePlayer = new Player("white");

        for (int i = 1; i <= 20; i++) {
            playingPhase((i % 2 != 0 ? whitePlayer : blackPlayer), board, rule);
        }

        System.out.println("Game Over!");
    }

    public void playingPhase(Player player, Board board, Rule rule) {
        board.displayingBoard();
        System.out.println(player.getPlayerColor() + "의 차례입니다!");

        while (true) {
            String playerInput = player.inputStrategyOfPlayer();

            if (rule.checkPlayerInputIsValid(playerInput.split(" ")[0]) && rule.checkPlayerInputIsValid(playerInput.split(" ")[1])) {
                if (board.changePieceLocationOnBoard(playerInput, player.getPlayerColor())) {
                    break;
                }
            }

            System.out.println("잘못된 수 입니다!!!");
        }
    }
}