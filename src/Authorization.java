import java.util.Scanner;

public class Authorization {
    public  Player getHuman() {
        Texts texts = new Texts();
        Scanner scanner = new Scanner(System.in);
        Player human = new Player();
        System.out.println(texts.getText("askName"));
        human.setName(scanner.nextLine());
        int humanAge = 0;
        do {
        try {
            System.out.println(texts.getText("askAge"));
            humanAge = human.setAge(Integer.parseInt(scanner.nextLine()));
        } catch (Exception ex) {
            System.out.println(texts.getText("invalidValue"));
            continue;
        }
        } while (humanAge <= 0 | humanAge > 300);
        if (humanAge < 18) {
            System.out.println(texts.getText("tooYoung"));
            System.out.println (texts.getText("notAppropriate"));
            System.exit(0);
        } else if (humanAge > 90) {
            System.out.println(texts.getText("tooOld"));
            System.out.println (texts.getText("notAppropriate"));
            System.exit(0);
        }
        System.out.println(texts.getText("askGender"));
        human.setGender(scanner.nextLine());
        return human;
    }
}
