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
        String locationInput, source, destination;

        System.out.print("움직일 기물의 위치/도착지를 입력하세요 ex) a2 a3 : ");
        locationInput = sc.nextLine();

        source = locationInput.split(" ")[0];
        destination = locationInput.split(" ")[1];

        locationOfMovement.put("source", source);
        locationOfMovement.put("destination", destination);

        return locationOfMovement;
    }
}
