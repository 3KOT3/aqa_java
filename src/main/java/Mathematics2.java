import java.util.List;

import static java.util.Arrays.asList;

public class Mathematics2 {
    public static void main(String[] args) {

        double budget = 1000.00;
        List<Double> prices = asList(199.99, 203.86, 1067.23, 900.00);

        double spent = 0.0;
        int bought = 0;

        for (int i = 0; i < prices.size(); i++) {
            if (spent + prices.get(i) > budget) {
                break;
            }
            spent += prices.get(i);
            bought++;
        }

        int notBought = prices.size() - bought;
        double remainder = budget - spent;

        System.out.println("Куплено: " + bought + " товара на сумму " + spent);
        System.out.println("Остаток бюджета: " + remainder);
        System.out.println("Не куплено: " + notBought + " товара");
    }
}