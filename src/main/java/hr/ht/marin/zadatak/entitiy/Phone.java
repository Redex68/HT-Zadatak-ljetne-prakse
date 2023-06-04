package hr.ht.marin.zadatak.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"modelName", "manufacturer"})
)
public class Phone {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Manufacturer name cannot be empty")
    private String manufacturer;
    @NotBlank(message = "Model name cannot be empty")
    private String modelName;
    @NotNull(message = "Price cannot be undefined")
    private Double price;
    
    public Phone(@NotBlank(message = "Manufacturer name cannot be empty") String manufacturer,
            @NotBlank(message = "Model name cannot be empty") String modelName,
            @NotNull(message = "Price cannot be undefined") Double price) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.price = price;
    }

    public Long getId() {
        return id;
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
}
