import java.io.PrintStream;
import java.util.*;

public class Main {
    static final int MAX_PLAYERS = 10;
    static final int MIN_PLAYERS = 2;
    static final int OG_PLAYERS = 12;

    static boolean RNG () {
        Random rand = new Random();
        return rand.nextBoolean();
    }
    static int num_of_players_input(Scanner input, PrintStream prompt) {
        if (prompt != null)
            prompt.print("Enter the number of players that will be playing: ");
        int num_of_players = input.nextInt();
        input.nextLine();

        if (num_of_players == OG_PLAYERS){
            if (prompt != null)
                prompt.println("This is for OW2 bro go back to OW1 :p");
            num_of_players = num_of_players_input(input, prompt);
        }
        else if (num_of_players < MIN_PLAYERS||num_of_players > MAX_PLAYERS){
            if (prompt != null)
                prompt.println("Invalid number of players, try again.");
            num_of_players = num_of_players_input(input, prompt);
        }
        return num_of_players;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num_of_players = num_of_players_input(input, System.out);

        PlayerList list_of_players = new PlayerList();

        for (int i=0; i<num_of_players; i++){
            Player player = Player.scan(input, System.out, i+1);
            list_of_players.addPlayer(player);
        }

        list_of_players.assignTeams(new Random());
        list_of_players.organizeByTeam();
        list_of_players.printTeams(System.out);
    }
}