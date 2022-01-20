import java.util.Scanner;

public class Player {
    private final String playerColor;

    public Player(String playerColor) {
        this.playerColor = playerColor;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public String inputStrategyOfPlayer() {
        Scanner sc = new Scanner(System.in);
        String location;

        System.out.print("움직일 기물의 위치/도착지를 입력하세요 ex) a2 a3 : ");
        location = sc.nextLine();

        return location;
    }
}
