package ro.iteahome.forVsStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ForVsStream {

    public static void main(String[] args) {
        Player player1 = new Player(1, "Ronaldo", 90);
        Player player2 = new Player(1, "Messi", 80);

        List<Player> players = Arrays.asList(player1, player2);

        getSkilledPlayersWithForEach(players);
        getSkilledPlayersWithStream(players);
    }

    public static void getSkilledPlayersWithForEach(List<Player> playerList) {
        List<Player> skilledPlayers = new ArrayList<Player>();
        for (Player player : playerList) {
            if (player.getSkill()>89)
                skilledPlayers.add(player);
        }

        for (Player player : skilledPlayers)
            System.out.println(player.toString());

    }

    public static void getSkilledPlayersWithStream(List<Player> playerList) {
        List<Player> skilledPlayers = playerList.stream().filter(sk -> (sk.getSkill()>89)).collect(Collectors.toList());
        skilledPlayers.forEach(System.out::println);
    }

    public static class Player {
        private int id;
        private String name;
        private int skill;

        public Player(int id, String name, int skill) {
            this.id = id;
            this.name = name;
            this.skill = skill;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSkill() {
            return skill;
        }

        public void setSkill(int skill) {
            this.skill = skill;
        }

        public String toString() {
            return this.id + " " + this.getName() + " " + this.getSkill();
        }


    }
}
