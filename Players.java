class Players {
    String name;
    boolean team;

    public Players(String player_name, boolean team_number) {
        name = player_name;
        team = team_number;
    }

    public void print_player() {
        if (team)
            System.out.println(String.format("%-10s", name));
        else
            System.out.printf(String.format("%-10s", name));
    }
}