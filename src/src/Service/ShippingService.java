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
                System.out.printf("%dx %-13s%n", item.getValue(), item.getKey().getName());
            }
        }

        for (Map.Entry<Product, Integer> item : shippingProduct.entrySet()) {
            if (item.getKey() instanceof ShippableProduct) {
                int weight = (int) ((ShippableProduct) item.getKey()).getWeight();
                int quantity = item.getValue();
                System.out.printf("%dg%n", weight * quantity);
            }
        }

        int totalWeightGrams = shippingProduct.entrySet().stream()
                .filter(e -> e.getKey() instanceof ShippableProduct)
                .mapToInt(e -> (int) (((ShippableProduct) e.getKey()).getWeight() * e.getValue()))
                .sum();

        double totalWeightKg = totalWeightGrams / 1000.0;

        System.out.printf("Total package weight %.1fkg%n", totalWeightKg);

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
