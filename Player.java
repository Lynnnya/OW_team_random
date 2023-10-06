import java.io.PrintStream;
import java.util.Scanner;

class Player {
    String name;
    boolean team;

    public Player(String player_name, boolean team_number) {
        name = player_name;
        team = team_number;
    }

    // reading player information is related to the Player class
    // so we hoist that part into the Player class
    public static Player scan(Scanner input, PrintStream prompt, int player_number) {
        if (prompt != null)
            prompt.printf("Enter name for player " + player_number + ": ");
        String name = input.nextLine();
        return new Player(name, false);
    }

    public void print_player() {
        if (team)
            System.out.println(String.format("%-10s", name));
        else
            System.out.printf(String.format("%-10s", name));
    }
}