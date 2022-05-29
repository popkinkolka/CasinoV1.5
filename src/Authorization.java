import java.util.Scanner;

public class Authorization {
    public  Player getHuman() {
        Scanner scanner = new Scanner(System.in);
        Player human = new Player();
        System.out.println("Логин свой запили");
        human.setName(scanner.nextLine());
        System.out.println("А годик тебе какой текёт");
        int humanAge = 0;
        try {
            humanAge = human.setAge(Integer.parseInt(scanner.nextLine()));
        } catch (Exception ex) {
            System.out.println("А я говорил нужна цифирка");
        }

        if (humanAge < 18) {
            System.out.println("Ты слишком молод ");
            System.out.println ("Ты нам не подходишь");
            System.exit(0);
        } else if (humanAge > 90) {
            System.out.println("Ты СУПЕРстар");
            System.out.println ("Ты нам не подходишь");
            System.exit(0);
        }
        System.out.println("Кто ты по гендору");
        human.setGender(scanner.nextLine());
        return human;
    }
}
