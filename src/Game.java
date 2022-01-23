public class Game {
    public void play() {
        System.out.println("================== Welcome To Chess Game!! ==================");
        Board board = new Board();
        Rule rule = new Rule();
        Player blackPlayer = new Player("black");
        Player whitePlayer = new Player("white");

        // 게임 진행 횟수는 20번으로 제한
        for (int i = 1; i <= 20; i++) {
            playingPhase((i % 2 != 0 ? whitePlayer : blackPlayer), board, rule);
        }

        System.out.println("Game Over!");
    }

    public void playingPhase(Player player, Board board, Rule rule) {
        // 체스판 상황을 가시화
        board.displayingBoard();
        System.out.println(player.getPlayerColor() + "의 차례입니다!");

        while (true) {
            // 플레이어로 부터 입력받기
            String playerInput = player.inputStrategyOfPlayer();

            // 플레이어의 입력 값이 유효한지 체크
            if (rule.checkPlayerInputIsValid(playerInput.split(" ")[0]) && rule.checkPlayerInputIsValid(playerInput.split(" ")[1])) {
                // 플레이어가 입력한 입력 값을 체스판에 반영
                if (board.changePieceLocationOnBoard(playerInput, player.getPlayerColor())) {
                    break;
                }
            }

            System.out.println("잘못된 수 입니다!!!");
        }
    }
}