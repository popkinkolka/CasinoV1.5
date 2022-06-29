import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private int age;
    private String gender;
    private int resultsPlayer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public int setAge(int age) {

        this.age = age;
        return age;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }


    public int getResultsPlayer() {
        return resultsPlayer;
    }

    public void setResultsPlayer(int resultsPlayer) {
        this.resultsPlayer = resultsPlayer;
    }

    public Player() {
    }

    public static List<Player> createPlayers(int number) {
        File file = new File();
        Random random = new Random();
        List<Player> players = new ArrayList<>();
        List<String> names = file.readFile("Name.txt");
        List<String> genders = file.readFile("Gender.txt");
        List<Integer> usedNumbersOfNames = new ArrayList<>();
        List<Integer> usedNumbersOfGenders = new ArrayList<>();
        int randomIndex;
        for (int i = 0; i < number; i++){
            Player player = new Player();
            do{
                randomIndex = random.nextInt(names.size());
                player.setName(names.get(randomIndex));
            } while (usedNumbersOfNames.contains(randomIndex));
            usedNumbersOfNames.add(randomIndex);
            do{
                randomIndex = random.nextInt(names.size());
                player.setGender(genders.get(randomIndex));
            } while (usedNumbersOfGenders.contains(randomIndex));
            player.setAge(new Random().nextInt(71)+18);
            usedNumbersOfGenders.add(randomIndex);
            players.add(player);
        }
        return players;
    }
}
