import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class PlayerList {
    List<Player> players;

    PlayerList() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void assignTeams(Random rand) {
        int T1_num = 0, T2_num = 0;

        for (Player player : players) {
            boolean new_member = rand.nextBoolean();
            if (T1_num == players.size() / 2) {
                player.setTeam(true);
                continue;
            } else if (T2_num == players.size() / 2) {
                player.setTeam(false);
                continue;
            }
            if (new_member)
                T2_num++;
            else
                T1_num++;
            player.setTeam(new_member);
        }
    }

    // when you write code that shares a block of data structure:
    // like this: static void list_organize(ArrayList<Player> list_of_players, int team_size)
    // you should consider wrapping the data into a class and moving the function code into that class
    public void organizeByTeam() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getTeam()) {
                for (int j = players.size() / 2; j < players.size(); j++) {
                    if (!players.get(j).getTeam())
                        swap(players, i, j);
                }
            }
        }
    }

    public void printTeams(PrintStream out) {
        out.println(String.format("%-10s%-10s", "TEAM 1", "TEAM 2"));
        for (int i = 0; i < players.size() / 2; i++) {
            out.print(players.get(i));
            out.print(players.get(i + players.size() / 2));
            out.println();
        }
    }
}
