package hr.ht.marin.zadatak.rest.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hr.ht.marin.zadatak.entitiy.Address;
import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryItem;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;
import hr.ht.marin.zadatak.service.DeliveryItemService;

public class DeliveryCreatorDTO {
    private Address deliveryAddress;
    private Address billingAddress;
    private Address returnAddress;
    private String clientName;
    private String clientSurname;
    private String clientPhoneNumber;
    
    private LocalDateTime orderCreationTime;
    private DeliveryStatus status;
    private List<Long> items;

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public Address getReturnAddress() {
        return returnAddress;
    }
    public String getClientName() {
        return clientName;
    }
    public String getClientSurname() {
        return clientSurname;
    }
    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }
    public LocalDateTime getOrderCreationTime() {
        return orderCreationTime;
    }
    public DeliveryStatus getStatus() {
        return status;
    }
    public List<Long> getItems() {
        return items;
    }


    public Delivery toDelivery(DeliveryItemService deliveryItemService) {
        List<DeliveryItem> actualItems = new ArrayList<>();
        for(long id: items)
            actualItems.add(deliveryItemService.getItem(id));

        Delivery delivery = new Delivery(deliveryAddress, billingAddress, returnAddress, clientName, clientSurname, clientPhoneNumber, orderCreationTime, status, actualItems);

        return delivery;
    }
    
}
