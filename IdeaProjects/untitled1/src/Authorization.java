import java.util.List;
import java.util.Scanner;

public class Authorization {
    public Player getHuman() {
        System.out.println("Добро пожаловать в казино Яблочко дъявола");
        Scanner scanner = new Scanner(System.in);
        Player human = new Player();
        System.out.println("Логин мне запили");
        human.setName(scanner.nextLine());
        System.out.println("Год нужен в формате цифирки");
        int bolvanchikiAge = 0;
        try {
            bolvanchikiAge = human.setAge(Integer.parseInt(scanner.nextLine()));
        } catch (Exception ex) {
            System.out.println("А я говорил нужна цифирка");
        }

        if (bolvanchikiAge < 18 | bolvanchikiAge > 90) {
            System.out.println("Ты нам не подходишь иди нахуй");
            System.exit(0);
        }
        System.out.println("Кто ты по гендору");
        human.setGender(scanner.nextLine());
        return human;
    }
}
