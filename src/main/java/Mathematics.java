import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Mathematics {
    public static void main(String[] args) {

        double budget = 6500.00;
        double totalPrices = 0.00;
        List<Double> prices = asList(1199.99, 2030.86, 1067.23, 900.00);

        for (int i = 0; i < prices.size(); i++) {
            totalPrices += prices.get(i);
        }

        if (budget >= totalPrices) {
            double remainderBudget = budget - totalPrices;
            System.out.println("Бюджета на покупку хватает, остаток: " + remainderBudget);
        } else {
            double shortageBudget = totalPrices - budget;
            System.out.println("Бюджета не хватает, пополни бюджет на сумму: " + shortageBudget);
        }
    }
}


