import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Gameplay {
    public int calculatesNumberRounds(){
        Texts texts = new Texts();
        int numberRounds = 0;
        System.out.println(texts.getText("quantityRound"));
        System.out.println(texts.getText("askRound"));
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                numberRounds = Integer.parseInt(String.valueOf(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println(texts.getText("needNumber"));
            }
            if (numberRounds < 2 | numberRounds > 5) {
                System.out.println(texts.getText("rangeValues"));
            }
        } while (numberRounds < 2 | numberRounds > 5);
        return numberRounds;
    }
    public int calculatesNumberPlayers(){
        Texts texts = new Texts();
        int numberPlayers = 0;
        System.out.println(texts.getText("quantityPlayers"));
        System.out.println(texts.getText("askPlayers"));
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                numberPlayers = Integer.parseInt(String.valueOf(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println(texts.getText("needNumber"));
            }
            if (numberPlayers < 2 | numberPlayers > 5) {
                System.out.println(texts.getText("rangeValues"));
            }
        } while (numberPlayers < 2 | numberPlayers > 5);
        return numberPlayers;
    }
    public List<Player> returningResults() {
        Texts texts = new Texts();
        Authorization authorization = new Authorization();
        Player human = authorization.getHuman();
        int numberPlayers = calculatesNumberPlayers();
        int numberRounds = calculatesNumberRounds();
        Scanner scanner = new Scanner(System.in);
        List<Player> addResults = Player.createPlayers(numberPlayers);
        for (int i = 1; i <= numberRounds; i++) {
            System.out.println(texts.getText("round") + i);
            System.out.println(texts.getText("namesPlayer") + human.getName() + texts.getText("age") + human.getAge() + texts.getText("Gender") + human.getGender());
            int randomValueCubeHuman;
            do {
                randomValueCubeHuman = (int) (Math.random() * 100);
                System.out.println(texts.getText("diceRoll"));
                scanner.nextLine();
            } while (randomValueCubeHuman == 0);
            System.out.println(texts.getText("diceRollRound") + i + " = " + randomValueCubeHuman);
            int oldValueCubeHuman = human.getResultsPlayer();
            human.setResultsPlayer(oldValueCubeHuman + randomValueCubeHuman);
            System.out.println(texts.getText("resultDiceRoll") + human.getResultsPlayer());
            System.out.println("-------------------------------------------------------------");
            for (Player player : addResults) {
                int randomValueCubePlayers;
                do {
                    randomValueCubePlayers = (int) (Math.random() * 100);
                } while (randomValueCubePlayers == 0);
                int oldValueCubePlayers = player.getResultsPlayer();
                player.setResultsPlayer(oldValueCubePlayers + randomValueCubePlayers);
                System.out.println("\n");
                System.out.println(texts.getText("namesPlayer") + player.getName() + texts.getText("age") + player.getAge() + texts.getText("Gender") + player.getGender());
                System.out.println(texts.getText("diceRollRound") + i + " = " + randomValueCubePlayers);
                System.out.println(texts.getText("resultDiceRoll") + " " + player.getResultsPlayer());
                System.out.println("-------------------------------------------------------------");
            }
        }
        addResults.add(human);
        return addResults;
    }
    public void determiningWinner() {
        Texts texts = new Texts();
        Gameplay gameplay = new Gameplay();
        Player winner = Collections.max(gameplay.returningResults(), Comparator.comparing(Player::getResultsPlayer));
        System.out.println(texts.getText("win") + winner.getName() + texts.getText("age") + winner.getAge() + texts.getText("Gender") + winner.getGender());
    }
}
