package hr.ht.marin.zadatak.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a phone model. Individual instances of this class do not represent physical phones, only
 * phone models.
 */
@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"modelName", "manufacturer"})
)
public class Phone extends DeliveryItem {
    @NotBlank(message = "Manufacturer name cannot be empty")
    private String manufacturer;
    @NotBlank(message = "Model name cannot be empty")
    private String modelName;
    @NotNull(message = "Price cannot be undefined")
    private Double price;
    @NotNull(message = "Weight cannot be undefined")
    private Double weight;
    
    public Phone(@NotBlank(message = "Manufacturer name cannot be empty") String manufacturer,
            @NotBlank(message = "Model name cannot be empty") String modelName,
            @NotNull(message = "Price cannot be undefined") Double price,
            @NotNull(message = "Weight cannot be undefined") Double weight) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.price = price;
        this.weight = weight;
    }

    public Phone() {
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public Double getWeight() {
        return weight;
    }
    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
