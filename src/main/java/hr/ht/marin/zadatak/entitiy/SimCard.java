package hr.ht.marin.zadatak.entitiy;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents sim card with a type of subscription. Individual instances of this class do not represent physical sim cards, only
 * types of sim cards.
 */
@Entity
public class SimCard extends DeliveryItem {
    @NotBlank(message = "Sim card type cannot be empty")
    private String type;
    @NotNull(message = "Sim card weight cannot be empty")
    private Double weight;
    @Size(max = 20)
    @NotBlank(message = "Sim card number cannot be empty")
    private String ICCID;

    public SimCard(@NotBlank(message = "Sim card type cannot be empty") String type,
            @NotNull(message = "Sim card weight cannot be empty") Double weight,
            @Size(max = 20) @NotBlank(message = "Sim card number cannot be empty") String iCCID) {
        this.type = type;
        this.weight = weight;
        ICCID = iCCID;
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
    public String getICCID() {
        return ICCID;
    }
    public void setICCID(String iCCID) {
        ICCID = iCCID;
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
