import java.util.HashMap;
import java.util.Map;

public class Texts {
    private final Map <String, String> textsMap = new HashMap<String, String>();
    public Texts() {
        //class Authorization
        textsMap.put("askName", "Введите имя");
        textsMap.put("askAge", "Сколько тебе лет");
        textsMap.put("invalidValue", "Некорректное значение");
        textsMap.put("tooYoung", "Ты слишком молод");
        textsMap.put("notAppropriate", "Ты нам не подходишь");
        textsMap.put("tooOld", "Ты слишком старый");
        textsMap.put("askGender","Введи свой гендер");
        //class Gameplay
        textsMap.put("quantityRound", "Раундов может быть от 2 до 5");
        textsMap.put("askRound", "Скалько раундов тебе надо?");
        textsMap.put("needNumber", "Нужна цифра!");
        textsMap.put("rangeValues", "Введи цифру от 2 до 5");
        textsMap.put("quantityPlayers", "Игроков может быть от 2 до 5");
        textsMap.put("askPlayers", "Скалько игроков тебе надо?");
        textsMap.put("round", "\nРаунд");
        textsMap.put("namesPlayer", "Игрок по имени: ");
        textsMap.put("age", " Возраст = ");
        textsMap.put("Gender", " Гендер = ");
        textsMap.put("diceRoll", "Нажмите Enter что бы бросить кубик");
        textsMap.put("diceRollRound", "Бросок кубика за раунд ");
        textsMap.put("resultDiceRoll", "Результат броска кубика  = ");
        textsMap.put("win", "\nВЫЙГРАЛ: ");
    }
    public  String getText (String textName) {
        return textsMap.get(textName);
    }
}
