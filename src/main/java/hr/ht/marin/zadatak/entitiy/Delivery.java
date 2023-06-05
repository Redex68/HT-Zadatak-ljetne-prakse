package hr.ht.marin.zadatak.entitiy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull(message = "Delivery address cannot be empty")
    @ManyToOne
    private Address deliveryAddress;
    @NotNull(message = "Billing address cannot be empty")
    @ManyToOne
    private Address billingAddress;
    @ManyToOne
    private Address returnAddress;
    @NotBlank(message = "Client name cannot be empty")
    private String clientName;
    @NotBlank(message = "Client surname cannot be empty")
    private String clientSurname;
    @NotBlank(message = "Client phone number cannot be empty")
    private String clientPhoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "The order's time of creation cannot be null")
    private LocalDateTime orderCreationTime;
    @Enumerated
    @NotNull(message = "Delivery status cannot be empty")
    private DeliveryStatus status;
    @NotEmpty(message = "The list of delivery items cannot be empty")
    @ManyToMany
    private List<DeliveryItem> items;

    public Delivery(@NotNull(message = "Delivery address cannot be empty") Address deliveryAddress,
            @NotNull(message = "Billing address cannot be empty") Address billingAddress,
            @NotBlank(message = "Client name cannot be empty") String clientName,
            @NotBlank(message = "Client surname cannot be empty") String clientSurname,
            @NotBlank(message = "Client phone number cannot be empty") String clientPhoneNumber,
            @NotNull(message = "The order's time of creation cannot be null") LocalDateTime orderCreationTime,
            @NotNull(message = "Delivery status cannot be empty") DeliveryStatus status,
            @NotEmpty(message = "The list of delivery items cannot be empty") List<DeliveryItem> items) {
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientPhoneNumber = clientPhoneNumber;
        this.orderCreationTime = orderCreationTime;
        this.status = status;
        this.items = items;
    }

    public Delivery(@NotNull(message = "Delivery address cannot be empty") Address deliveryAddress,
            @NotNull(message = "Billing address cannot be empty") Address billingAddress, Address returnAddress,
            @NotBlank(message = "Client name cannot be empty") String clientName,
            @NotBlank(message = "Client surname cannot be empty") String clientSurname,
            @NotBlank(message = "Client phone number cannot be empty") String clientPhoneNumber,
            @NotNull(message = "The order's time of creation cannot be null") LocalDateTime orderCreationTime,
            @NotNull(message = "Delivery status cannot be empty") DeliveryStatus status,
            @NotEmpty(message = "The list of delivery items cannot be empty") List<DeliveryItem> items) {
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.returnAddress = returnAddress;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientPhoneNumber = clientPhoneNumber;
        this.orderCreationTime = orderCreationTime;
        this.status = status;
        this.items = items;
    }



    public Delivery() {
    }


    public UUID getId() {
        return id;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    public Address getReturnAddress() {
        return returnAddress;
    }
    public void setReturnAddress(Address returnAddress) {
        this.returnAddress = returnAddress;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }
    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }
    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }
    public LocalDateTime getOrderCreationTime() {
        return orderCreationTime;
    }
    public void setOrderCreationTime(LocalDateTime orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }
    public DeliveryStatus getStatus() {
        return status;
    }
    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
    public List<DeliveryItem> getItems() {
        return items;
    }
    public void setItems(List<DeliveryItem> items) {
        this.items = items;
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
        Delivery other = (Delivery) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
