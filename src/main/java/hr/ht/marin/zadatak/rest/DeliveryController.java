package hr.ht.marin.zadatak.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;
import hr.ht.marin.zadatak.rest.dto.IntervalDTO;
import hr.ht.marin.zadatak.service.AddressService;
import hr.ht.marin.zadatak.service.DeliveryService;
import hr.ht.marin.zadatak.service.PhoneService;

@RestController
public class DeliveryController {
    @Autowired DeliveryService deliveryService;
    @Autowired AddressService addressService;
    @Autowired PhoneService phoneService;
    
    @GetMapping("public/delivery/{id}")
    @Secured({})
    public Delivery getDelivery(@PathVariable("id") Long id)
    {
        return deliveryService.getDelivery(id);
    }

    @GetMapping("public/delivery/interval")
    @Secured({"ROLE_EMPLYEE"})
    public Set<Delivery> getDeliveriesFromInterval(@RequestBody IntervalDTO interval) {
        Assert.notNull(interval, "Intervall cannot be empty");
        if(interval.start() == null && interval.end() == null)
            throw new IllegalArgumentException("The start and end of the intervall cannot both be empty at the same time");
        
        return deliveryService.getDeliveriesInInterval(interval.start(), interval.end());
    }

    @GetMapping("public/delivery/status/{status}")
    @Secured({"ROLE_EMPLYEE"})
    public Set<Delivery> getDeliveriesByStatus(@PathVariable("status") DeliveryStatus status)
    {
        Assert.notNull(status, "Status cannot be empty");

        return deliveryService.getDeliveriesByStatus(status);
    }

    @PostMapping("/delivery")
    @Secured("ROLE_ADMIN")
    public void addDelivery(@RequestBody Delivery delivery)
    {
        Assert.notNull(delivery, "Cannot add an empty delivery");
        Assert.notNull(delivery.getDeliveryAddress(), "Cannot add a delivery with an empty delivery address");
        Assert.notNull(delivery.getBillingAddress(), "Cannot add a delivery with an empty billing address");
        Assert.notNull(delivery.getPhone(), "Cannot add a delivery with an empty phone");

        addressService.addAddress(delivery.getBillingAddress());
        addressService.addAddress(delivery.getDeliveryAddress());
        phoneService.addPhone(delivery.getPhone());

        deliveryService.addDelivery(delivery);
    }
}
