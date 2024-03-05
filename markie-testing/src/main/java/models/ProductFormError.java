package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ProductFormError {
    private String fieldName;
    private String fieldCategory;
    private String fieldQuantity;
    private String fieldBrand;
    private String fieldPrice;

    public ProductFormError(Map<String, String> data) {
        this.fieldName = data.get("Field Name") != null ? data.get("Field Name") : "";
        this.fieldCategory = data.get("Field Category") != null ? data.get("Field Category") : "";
        this.fieldQuantity = data.get("Field Quantity") != null ? data.get("Field Quantity") : "";
        this.fieldBrand = data.get("Field Brand") != null ? data.get("Field Brand") : "";
        this.fieldPrice = data.get("Field Price") != null ? data.get("Field Price") : "";
    }
}
