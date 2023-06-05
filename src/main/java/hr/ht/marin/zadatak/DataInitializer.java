package hr.ht.marin.zadatak;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import hr.ht.marin.zadatak.entitiy.Address;
import hr.ht.marin.zadatak.entitiy.AppUser;
import hr.ht.marin.zadatak.entitiy.AuthLevel;
import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;
import hr.ht.marin.zadatak.entitiy.Phone;
import hr.ht.marin.zadatak.entitiy.SimCard;
import hr.ht.marin.zadatak.service.AddressService;
import hr.ht.marin.zadatak.service.AppUserService;
import hr.ht.marin.zadatak.service.DeliveryService;
import hr.ht.marin.zadatak.service.PhoneService;
import hr.ht.marin.zadatak.service.SimCardService;

@Component
public class DataInitializer {

    @Autowired DeliveryService deliveryService;
    @Autowired PhoneService phoneService;
    @Autowired AddressService addressService;
    @Autowired AppUserService appUserService;
    @Autowired SimCardService simCardService;

    @Autowired PasswordEncoder pEncoder;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        Phone phones[] = {
            new Phone("Samsung",   "Galaxy Z Fold4", 2000.0, 0.263),
            new Phone("Samsung",   "Galaxy S23",    1000.0, 0.234),
            new Phone("Fairphone", "Fairphone 4",   700.0,  0.225),
            new Phone("Apple",     "iPhone 14",     5000.0, 0.172),
        };

        SimCard simCards[] = {
            new SimCard("Internet+", 0.01),
            new SimCard("Neogranicena", 0.01),
        };

        Address addresses[] = {
            new Address("Croatia", "Zagreb", 10000l, "Jagićeva 5"),
            new Address("Croatia", "Split", 21000l, "Mosećka 12"),
            new Address("Croatia", "Zadar", 23000l, "Splitska 20"),
            new Address("Gabon", "Libreville", 69000l, "Rue Ndona 42"),
        };

        for(int i = 0; i < phones.length; i++)
            phones[i] = phoneService.addPhone(phones[i]);
            
        for(int i = 0; i < simCards.length; i++)
            simCards[i] = simCardService.addSimCard(simCards[i]);

        for(int i = 0; i < addresses.length; i++)
            addresses[i] = addressService.addAddress(addresses[i]);


        Delivery deliveries[] = {
            new Delivery(addresses[0], addresses[1], "Marin",   "Petric",   "+385994652781", LocalDateTime.now(),                DeliveryStatus.NEW,       List.of(phones[0], simCards[0])),
            new Delivery(addresses[1], addresses[1], "Stipe",   "Stipic",   "+385991261281", LocalDateTime.now().plusDays(3),    DeliveryStatus.NEW,       List.of(phones[2])),
            new Delivery(addresses[2], addresses[2], "Pero",    "Peric",    "+385974151309", LocalDateTime.now().minusDays(5),   DeliveryStatus.DELIVERED, List.of(phones[1], phones[2], simCards[1])),
            new Delivery(addresses[3], addresses[3], "Andrej",  "Andrejic", "+385941242780", LocalDateTime.now().minusHours(12), DeliveryStatus.SHIPPED,   List.of(phones[2])),
        };

        for(int i = 0; i < deliveries.length; i++)
            deliveries[i] = deliveryService.addDelivery(deliveries[i]);

        AppUser users[] = {
            new AppUser("admin",  pEncoder.encode("admin lozinka"),       List.of(AuthLevel.ROLE_ADMIN, AuthLevel.ROLE_EMPLOYEE)),
            new AppUser("admin2", pEncoder.encode("admin tajna lozinka"), List.of(AuthLevel.ROLE_ADMIN, AuthLevel.ROLE_EMPLOYEE)),
            new AppUser("ana",    pEncoder.encode("ana123"),              List.of(AuthLevel.ROLE_EMPLOYEE)),
            new AppUser("jurica", pEncoder.encode("jurica123"),           List.of(AuthLevel.ROLE_EMPLOYEE)),
            new AppUser("stipe",  pEncoder.encode("stipe123"),            List.of(AuthLevel.ROLE_EMPLOYEE)),
        };

        for(AppUser user: users)
            appUserService.addUser(user);
    }
}
