import java.io.FileReader;
import java.util.*;

public class File {
    public List<String> readFile(String fileName) {
        String[] PlayersData;
        StringBuilder playerString = new StringBuilder("");
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                playerString.append((char) c);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        PlayersData = playerString.toString().split("\r\n");
        List<String> list = Arrays.asList(PlayersData);
        return list;
    }
}




