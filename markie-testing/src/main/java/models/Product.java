package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private String name;
    private String category;
    private int quantity;
    private String brand;
    private float price;

    public Product(Map<String, String> data) {
        this.name = data.get("Name") != null ? data.get("Name") : "";
        this.category = data.get("Category") != null ? data.get("Category") : "";
        this.quantity = data.get("Quantity") != null ? Integer.parseInt(data.get("Quantity")) : 0;
        this.brand = data.get("Brand") != null ? data.get("Brand") : "";
        this.price = data.get("Price") != null ? Float.parseFloat(data.get("Price")) : 0;
    }
}
