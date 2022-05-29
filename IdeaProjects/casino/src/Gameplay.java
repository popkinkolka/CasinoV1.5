import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Gameplay {
    public int calculatesNumberRounds(){
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
        return numberRounds;
    }
    public int calculatesNumberPlayers(){
        int numberPlayers = 0;
        System.out.println("Игроков может быть от 2 до 5");
        System.out.println("Скалько игроков тебе надо?");
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                numberPlayers = Integer.parseInt(String.valueOf(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Ну ты блять совсем трижды тупой, Я Ж ТЕБЕ ПРЯМЫМ ТЕКСТОМ НАПИСАЛ, СЕРЫМ ПО ТЕМНО-СЕРОМУ, цифру не букву");
            }
            if (numberPlayers < 2 | numberPlayers > 5) {
                System.out.println("ЦИИИФРУУУ от 2 до 5");
            }
        } while (numberPlayers < 2 | numberPlayers > 5);
        return numberPlayers;
    }
    public List<Player> returningResults() {
        Authorization authorization = new Authorization();
        Player human = authorization.getHuman();
        int numberPlayers = calculatesNumberPlayers();
        int numberRounds = calculatesNumberRounds();
        Scanner scanner = new Scanner(System.in);
        List<Player> addResults = Player.createPlayers(numberPlayers);
        for (int i = 1; i <= numberRounds; i++) {
            System.out.println("\nРаунд " + i);
            System.out.println("Игрок по имени: " + human.getName() + " Возраст = " + human.getAge() + " Гендер = " + human.getGender());
            int randomValueCubeHuman;
            do {
                randomValueCubeHuman = (int) (Math.random() * 100);
                System.out.println("Нажмите Enter что бы бросить кубик");
                scanner.nextLine();
            } while (randomValueCubeHuman == 0);
            System.out.println("Бросок кубика за раунд " + i + " = " + randomValueCubeHuman);
            int oldValueCubeHuman = human.getResultsPlayer();
            human.setResultsPlayer(oldValueCubeHuman + randomValueCubeHuman);
            System.out.println("Результат броска кубика  = " + human.getResultsPlayer());
            for (Player player : addResults) {
                int randomValueCubePlayers;
                do {
                    randomValueCubePlayers = (int) (Math.random() * 100);
                } while (randomValueCubePlayers == 0);
                int oldValueCubePlayers = player.getResultsPlayer();
                player.setResultsPlayer(oldValueCubePlayers + randomValueCubePlayers);
                System.out.println("\n");
                System.out.println("Игрок:" + player.getName() + " Возраст:" + player.getAge() + " Гендер:" + player.getGender());
                System.out.println("Бросок кубика за раунд " + i + " = " + randomValueCubePlayers);
                System.out.println("Результат броска кубика игрока = " + player.getResultsPlayer());
            }
        }
        addResults.add(human);
        return addResults;
    }
    public void determiningWinner() {
        Gameplay gameplay = new Gameplay();
        Player winner = Collections.max(gameplay.returningResults(), Comparator.comparing(Player::getResultsPlayer));
        System.out.println("\nВЫЙГРАЛ: " + winner.getName() + " Возраст:" + winner.getAge() + " Гендер:" + winner.getGender());
    }
}
