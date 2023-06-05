package hr.ht.marin.zadatak.entitiy;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class SimCard extends DeliveryItem {
    @NotBlank(message = "Sim card type cannot be empty")
    private String type;
    @NotNull(message = "Sim card weight cannot be empty")
    private Double weight;

    public SimCard(@NotBlank(message = "Sim card type cannot be empty") String type,
            @NotNull(message = "Sim card weight cannot be empty") Double weight) {
        this.type = type;
        this.weight = weight;
    }

    public SimCard() {
    }


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
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
