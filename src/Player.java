import java.util.HashMap;
import java.util.Scanner;

public class Player {
    private final String playerColor;

    public Player(String playerColor) {
        this.playerColor = playerColor;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public HashMap<String, String> inputStrategyOfPlayer() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> locationOfMovement = new HashMap<>(2);
        String source;
        String destination;

        System.out.print("움직일 기물의 위치를 입력하세요 ex) a2 : ");
        source = sc.nextLine();
        System.out.print("이동할 위치를 입력하세요 ex) a3 : ");
        destination = sc.nextLine();

        locationOfMovement.put("source", source);
        locationOfMovement.put("destination", destination);

        return locationOfMovement;
    }
}
