import java.util.Collections;
import java.util.Comparator;

public class Final {
    public void determiningWinner() {
        Gameplay gameplay = new Gameplay();
        Player podebitel = Collections.max(gameplay.getResults(), Comparator.comparing(Player::getResultsBolvanchik));
        System.out.println("\nВЫЙГРАЛ: " + podebitel.getName() + " Возраст:" + podebitel.getAge() + " Гендер:" + podebitel.getGender());
    }
}
