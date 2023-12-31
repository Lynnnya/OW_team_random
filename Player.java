import java.io.PrintStream;
import java.util.Scanner;

public class Player {
    // private fields + getters and setters instead of public fields are good OOP practice
    // this is a good practice because it allows you to change the implementation
    // of the class without changing the interface
    private String name;
    private boolean team;

    public Player(String player_name, boolean team_number) {
        name = player_name;
        team = team_number;
    }

    public String getName() {
        return name;
    }

    public boolean getTeam() {
        return team;
    }

    boolean setTeam(boolean team_number) {
        team = team_number;
        return team;
    }

    // reading player information is related to the Player class
    // so we hoist that part into the Player class
    public static Player scan(Scanner input, PrintStream prompt, int player_number) {
        if (prompt != null)
            prompt.printf("Enter name for player " + player_number + ": ");
        String name = input.nextLine();
        return new Player(name, false);
    }

    // use generic methods like toString() to implement data printing
    @Override
    public String toString() {
        return String.format("%-10s", name);
    }
}