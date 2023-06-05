package hr.ht.marin.zadatak.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.service.AddressService;
import hr.ht.marin.zadatak.service.DeliveryService;
import hr.ht.marin.zadatak.service.PhoneService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired DeliveryService deliveryService;
    @Autowired AddressService addressService;
    @Autowired PhoneService phoneService;
    
    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable("id") Long id)
    {
        return deliveryService.getDelivery(id);
    }

    @PostMapping("")
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
