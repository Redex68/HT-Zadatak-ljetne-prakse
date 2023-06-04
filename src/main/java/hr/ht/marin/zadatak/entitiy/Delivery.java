package hr.ht.marin.zadatak.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Delivery address cannot be empty")
    @ManyToOne
    private Address deliveryAddress;
    @NotNull(message = "Billing address cannot be empty")
    @ManyToOne
    private Address billingAddress;
    @NotBlank(message = "Client name cannot be empty")
    private String clientName;
    @NotBlank(message = "Client surname cannot be empty")
    private String clientSurname;
    @NotBlank(message = "Client phone number cannot be empty")
    private String clientPhoneNumber;

    @Enumerated
    @NotNull(message = "Delivery status cannot be empty")
    private DeliveryStatus status;
    @NotNull(message = "The phone being delivered cannot be null")
    @ManyToOne
    private Phone phone;

    public Delivery(@NotNull(message = "Delivery address cannot be empty") Address deliveryAddress,
            @NotNull(message = "Billing address cannot be empty") Address billingAddress,
            @NotBlank(message = "Client name cannot be empty") String clientName,
            @NotBlank(message = "Client surname cannot be empty") String clientSurname,
            @NotBlank(message = "Client phone number cannot be empty") String clientPhoneNumber,
            @NotNull(message = "Delivery status cannot be empty") DeliveryStatus status,
            @NotNull(message = "The phone being delivered cannot be null") Phone phone) {
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientPhoneNumber = clientPhoneNumber;
        this.status = status;
        this.phone = phone;
    }

    public Long getId() {
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
    public DeliveryStatus getStatus() {
        return status;
    }
    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
    public Phone getPhone() {
        return phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
