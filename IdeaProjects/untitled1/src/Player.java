import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private int age;
    private String gender;
    private int resultsBolvanchik;

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


    public int getResultsBolvanchik() {
        return resultsBolvanchik;
    }

    public void setResultsBolvanchik(int resultsBolvanchik) {
        this.resultsBolvanchik = resultsBolvanchik;
    }

    public Player(String name, String age, String gender) {
        this.name = name;
        this.age = Integer.parseInt(age);
        this.gender = gender;
    }

    public Player() {
    }

    public static List<Player> createOpponents(int number) {
        File file = new File();
        Random random = new Random();
        List<Player> bots = new ArrayList<>();
        List<String> names = file.readFile("Name.txt");
        List<String> ages = file.readFile("Age.txt");
        List<String> genders = file.readFile("Gender.txt");
        for (int i = 0; i < number; i++){
            Player player = new Player(
                    names.get(random.nextInt(names.size())),
                    ages.get(random.nextInt(ages.size())),
                    genders.get(random.nextInt(genders.size()))
            );
            bots.add(player);
        }
        return bots;
    }
}
