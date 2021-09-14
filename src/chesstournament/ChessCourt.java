package chesstournament;

import java.util.ArrayList;
import java.util.Scanner;

public class ChessCourt {
    private static Scanner input=new Scanner(System.in);
    private static Helper helper=new Helper();
    public static void main(String[] args) {

    }
    public static void choice(){
        System.out.println(" Chess Tournament Started");
        System.out.println("Enter number of players");
        int number = input.nextInt();
        ArrayList<PlayerDetails> playerList = new ArrayList<>();
        System.out.println("Enter the players Name");
        for (int i = 1; i <= number; i++) {
            PlayerDetails info = new PlayerDetails();
            info.setPlayerId(i);
            info.setName(input.next());
            info.setPoints(0);
            playerList.add(info);
        }
        helper.playerDetailsToMap(playerList);
    }
}

