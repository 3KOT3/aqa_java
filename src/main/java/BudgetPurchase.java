import java.util.List;

import static java.util.Arrays.asList;

public class BudgetPurchase {
    public static void main(String[] args) {

        double budget = 1700.00;
        List<Double> prices = asList(1199.99, 2030.86, 1067.23, 900.00, 185.92);

        double spent = 0.0;
        int bought = 0;

        for (int i = 0; i < prices.size(); i++) {
            if (spent + prices.get(i) > budget) {
                continue;
            }
            spent += prices.get(i);
            bought++;
        }

        int notBought = prices.size() - bought;
        double remainder = budget - spent;

        System.out.println("Куплено: " + bought + " товара на сумму " + spent);
        System.out.printf("Остаток бюджета: %.2f%n", remainder);
        System.out.println("Не куплено: " + notBought + " товара");
    }
}