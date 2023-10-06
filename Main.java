import java.util.*;

public class Main {
    static final int MAX_PLAYERS = 10;
    static final int MIN_PLAYERS = 2;
    static final int OG_PLAYERS = 12;

    static void result(ArrayList<Player> list_of_players, int team_size) {
        System.out.println(String.format("%-10s%-10s", "TEAM 1", "TEAM 2"));
        for(int i=0; i<team_size; i++) {
            list_of_players.get(i).print_player();
            list_of_players.get(i+team_size).print_player();
        }
    }
    static void list_organize(ArrayList<Player> list_of_players, int team_size) {
        for(int i=0; i<team_size; i++) {
            if(list_of_players.get(i).team) {
                for(int j=team_size; j<team_size*2; j++) {
                    if(!list_of_players.get(j).team)
                        Collections.swap(list_of_players, i, j);
                }
            }
        }
    }
    static boolean RNG () {
        Random rand = new Random();
        return rand.nextBoolean();
    }
    static int num_of_players_input() {
        System.out.print("Enter the number of players that will be playing: ");
        Scanner input_num_of_player = new Scanner(System.in);
        int num_of_players = input_num_of_player.nextInt();

        if (num_of_players == OG_PLAYERS){
            System.out.println("This is for OW2 bro go back to OW1 :p");
            num_of_players = num_of_players_input();
        }
        else if (num_of_players < MIN_PLAYERS||num_of_players > MAX_PLAYERS){
            System.out.println("Invalid number of players, try again.");
            num_of_players = num_of_players_input();
        }
        return num_of_players;
    }
    public static void main(String[] args) {
        int num_of_players = num_of_players_input();
        int T1_num = 0, T2_num = 0;
        ArrayList<Player> list_of_players = new ArrayList<Player>();
        Scanner name_input = new Scanner(System.in);
        String player_name;

        for (int i=0; i<num_of_players; i++){
            Player player = Player.scan(name_input, System.out, i+1);
            boolean new_member = RNG();

            if(T1_num == num_of_players/2){
                player.team = true;
                list_of_players.add(player);
                continue;
            }
            else if(T2_num == num_of_players/2){
                player.team = false;
                list_of_players.add(player);
                continue;
            }
            if(new_member)
                T2_num++;
            else
                T1_num++;
            player.team = new_member;
            list_of_players.add(player);
        }

        list_organize(list_of_players, num_of_players/2);
        result(list_of_players, num_of_players/2);
    }
}