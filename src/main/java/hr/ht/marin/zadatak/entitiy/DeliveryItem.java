package hr.ht.marin.zadatak.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * An abstract representation of an item in a delivery/shipment.
 */
@Entity
public abstract class DeliveryItem {
    @Id
    @GeneratedValue
    Long id;

    public abstract Double getWeight();
    public abstract void setWeight(double weight);

    public Long getId() {
        return id;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeliveryItem other = (DeliveryItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
