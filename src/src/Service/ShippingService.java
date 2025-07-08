package Service;

import Products.Product;
import Products.ShippableProduct;

import java.util.HashMap;
import java.util.Map;

public class ShippingService {
    public ShippingService(double totalWeightKg) {
        this.totalWeightKg = totalWeightKg;
    }

    private double totalWeightKg;
    public void shippingRecipet(HashMap<Product ,Integer> shippingProduct){
        System.out.println("** Shipment notice **");

        for (Map.Entry<Product, Integer> item : shippingProduct.entrySet()) {
            if (item.getKey() instanceof ShippableProduct) {
                int quantity = item.getValue();
                System.out.printf("%dx %-13s", quantity, item.getKey().getName());
                int weight = (int) ((ShippableProduct) item.getKey()).getWeight();
                System.out.printf("%dg%n", weight * quantity);
            }
        }

        for (Map.Entry<Product, Integer> item : shippingProduct.entrySet()) {
            if (item.getKey() instanceof ShippableProduct) {

            }
        }

        int totalWeightGrams = shippingProduct.entrySet().stream()
                .filter(e -> e.getKey() instanceof ShippableProduct)
                .mapToInt(e -> (int) (((ShippableProduct) e.getKey()).getWeight() * e.getValue()))
                .sum();

        double totalWeightKg = totalWeightGrams / 1000.0;

        System.out.printf("Total package weight %.1fkg%n", totalWeightKg);
        System.out.println();

    }
    public double getShippingCost(){
        if(this.totalWeightKg > 2)
            return 60;
        else if (this.totalWeightKg >1) {
            return 40;
        }
        return 30;
    }
}
