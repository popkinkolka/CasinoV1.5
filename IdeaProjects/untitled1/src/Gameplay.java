import java.util.List;
import java.util.Scanner;

public class Gameplay {
    public List<Player> getResults() {
        Authorization authorization = new Authorization();
        Player human = authorization.getHuman();
        int numberRounds = 0;
        System.out.println("Раундов может быть от 2 до 5");
        System.out.println("Скалько раундов тебе надо?");
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                numberRounds = Integer.parseInt(String.valueOf(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Ну ты блять совсем трижды тупой, Я Ж ТЕБЕ ПРЯМЫМ ТЕКСТОМ НАПИСАЛ, СЕРЫМ ПО ТЕМНО-СЕРОМУ, цифру не букву");
            }
            if (numberRounds < 2 | numberRounds > 5) {
                System.out.println("ЦИИИФРУУУ от 2 до 5");
            }
        } while (numberRounds < 2 | numberRounds > 5);
        int numberPlaers = 0;
        System.out.println("Болванчиков может быть от 2 до 5");
        System.out.println("Скалько болванчиков тебе надо?");
        do {
            try {
                numberPlaers = Integer.parseInt(String.valueOf(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Ну ты блять совсем трижды тупой, Я Ж ТЕБЕ ПРЯМЫМ ТЕКСТОМ НАПИСАЛ, СЕРЫМ ПО ТЕМНО-СЕРОМУ, циру не букву");
            }
            if (numberPlaers < 2 | numberPlaers > 5) {
                System.out.println("ЦИИИФРУУУ от 2 до 5");
            }

        } while (numberPlaers < 2 | numberPlaers > 5);
        List<Player> addResults = Player.createOpponents(numberPlaers);
        for (int i = 1; i <= numberRounds; i++) {
            System.out.println("\nРаунд " + i);
            System.out.println("Игрок по имени: " + human.getName() + " Возраст = " + human.getAge() + " Гендер = " + human.getGender());
            int randomValueCubeHumen;
            do {
                randomValueCubeHumen = (int) (Math.random() * 100);
                System.out.println("Нажмите Enter что бы бросить кубик");
                scanner.nextLine();
            } while (randomValueCubeHumen == 0);
            System.out.println("Бросок кубика за раунд " + i + " = " + randomValueCubeHumen);
            int oldResultHuman = human.getResultsBolvanchik();
            human.setResultsBolvanchik(oldResultHuman + randomValueCubeHumen);
            System.out.println("Результат броска кубика  = " + human.getResultsBolvanchik());
            for (Player player : addResults) {
                int randomValueCubePlayers;
                do {
                    randomValueCubePlayers = (int) (Math.random() * 100);
                } while (randomValueCubePlayers == 0);
                int oldResultBolvan = player.getResultsBolvanchik();
                player.setResultsBolvanchik(oldResultBolvan + randomValueCubePlayers);
                System.out.println("\n");
                System.out.println("Блованчик:" + player.getName() + " Возраст:" + player.getAge() + " Гендер:" + player.getGender());
                System.out.println("Бросок кубика за раунд " + i + " = " + randomValueCubePlayers);
                System.out.println("Результат броска кубика болванчика = " + player.getResultsBolvanchik());
            }
        }
        addResults.add(human);
        return addResults;
    }
}
