package hr.ht.marin.zadatak;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import hr.ht.marin.zadatak.entitiy.Address;
import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;
import hr.ht.marin.zadatak.entitiy.Phone;
import hr.ht.marin.zadatak.service.AddressService;
import hr.ht.marin.zadatak.service.DeliveryService;
import hr.ht.marin.zadatak.service.PhoneService;

@Component
public class DataInitializer {

    @Autowired DeliveryService deliveryService;
    @Autowired PhoneService phoneService;
    @Autowired AddressService addressService;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        Phone phones[] = {
            new Phone("Samsung", "Galaxy Z Fold", 2000.0),
            new Phone("Samsung", "Galaxy S23", 1000.0),
            new Phone("Fairphone", "Fairphone 4", 700.0),
        };

        Address addresses[] = {
            new Address("Croatia", "Zagreb", 10000l, "Jagićeva 5"),
            new Address("Croatia", "Split", 21000l, "Mosećka 12"),
            new Address("Croatia", "Zadar", 23000l, "Splitska 20"),
            new Address("Gabon", "Libreville", 69000l, "Rue Ndona 42"),
        };

        for(int i = 0; i < phones.length; i++)
            phones[i] = phoneService.addPhone(phones[i]);

        for(int i = 0; i < addresses.length; i++)
            addresses[i] = addressService.addAddress(addresses[i]);

        Delivery deliveries[] = {
            new Delivery(addresses[0], addresses[1], "Marin", "Petric", "+385994652781", LocalDateTime.now(), DeliveryStatus.NEW, phones[0]),
            new Delivery(addresses[1], addresses[1], "Stipe", "Stipic", "+385991261281", LocalDateTime.now().plusDays(3), DeliveryStatus.NEW, phones[2]),
            new Delivery(addresses[2], addresses[2], "Pero", "Peric", "+385974151309", LocalDateTime.now().minusDays(5), DeliveryStatus.DELIVERED, phones[1]),
            new Delivery(addresses[3], addresses[3], "Andrej", "Andrejic", "+385941242780", LocalDateTime.now().minusHours(12), DeliveryStatus.SHIPPED, phones[2]),
        };

        for(int i = 0; i < deliveries.length; i++)
            deliveries[i] = deliveryService.addDelivery(deliveries[i]);
    }
}
