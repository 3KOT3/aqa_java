import java.util.Arrays;
import java.util.List;

public class Fruits {
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Яблоко", "Банан", "Апельсин", "Киви", "Манго");
        for(int i = 0; i < fruits.size(); i++ ) {
            System.out.println((i + 1) + ". " + fruits.get(i));
        }
    }
}
