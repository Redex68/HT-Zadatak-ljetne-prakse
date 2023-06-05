package hr.ht.marin.zadatak.rest;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;
import hr.ht.marin.zadatak.rest.dto.DeliveryCreatorDTO;
import hr.ht.marin.zadatak.rest.dto.IntervalDTO;
import hr.ht.marin.zadatak.service.AddressService;
import hr.ht.marin.zadatak.service.DeliveryItemService;
import hr.ht.marin.zadatak.service.DeliveryService;
import hr.ht.marin.zadatak.service.PhoneService;

@RestController
public class DeliveryController {
    @Autowired DeliveryService deliveryService;
    @Autowired AddressService addressService;
    @Autowired PhoneService phoneService;
    @Autowired DeliveryItemService deliveryItemService;

    /**
     * Fetches the delivery specified by the UUID {@code id}. If no such delivery exists a NotFoundException
     * is thrown and 404 is returned.
     * Is publicly accessible without need for authentication.
     * @param id The ID of the delivery.
     * @return The Delivery if such exists.
     * @throws NotFoundException If no such delivery exists.
     */
    @GetMapping("/public/delivery/{id}")
    @Secured({})
    public Delivery getDelivery(@PathVariable("id") UUID id) throws NotFoundException
    {
        Assert.notNull(id, "Delivery ID cannot be null");

        Delivery delivery = deliveryService.getDelivery(id);
        if(delivery == null) throw new NotFoundException("No delivery with the specified ID was found");
        else return delivery;
    }

    /**
     * Fetches all deliveries created in the specified interval. One end of the interval can be ommited
     * to return all events occuring up to or after the remaining point.
     * Visible only to employees and requires authorization.
     * @param interval The interval.
     * @return A set containing all of the deliveries created in the specified interval.
     * @throws IllegalArgumentException If both ends of the interval are missing.
     */
    @GetMapping("/delivery/interval")
    @Secured({"ROLE_EMPLOYEE"})
    public Set<Delivery> getDeliveriesFromInterval(@RequestBody IntervalDTO interval) throws IllegalArgumentException {
        Assert.notNull(interval, "Intervall cannot be empty");
        if(interval.start() == null && interval.end() == null)
            throw new IllegalArgumentException("The start and end of the intervall cannot both be empty at the same time");
        
        return deliveryService.getDeliveriesInInterval(interval.start(), interval.end());
    }

    /**
     * Fetches all deliveries with the specified status.
     * Visible only to employees and requires authorization.
     * @param status The status of the deliveries.
     * @return A set of deliveries which have the specified status.
     * @throws IllegalArgumentException If the status is not a valid delivery status.
     */
    @GetMapping("/delivery/status/{status}")
    @Secured({"ROLE_EMPLOYEE"})
    public Set<Delivery> getDeliveriesByStatus(@PathVariable("status") DeliveryStatus status) throws IllegalArgumentException {
        Assert.notNull(status, "Status cannot be empty");

        return deliveryService.getDeliveriesByStatus(status);
    }

    /**
     * Adds a new delivery to the repository.
     * Visible only to admins and requires authorization.
     * @param delivery The delivery being added.
     * @throws IllegalArgumentException If one of the mandatory fields is missing.
     */
    @PostMapping("/delivery")
    @Secured("ROLE_ADMIN")
    public void addDelivery(@RequestBody DeliveryCreatorDTO delivery) throws IllegalArgumentException {
        Assert.notNull(delivery, "Cannot add an empty delivery");
        Assert.notNull(delivery.getDeliveryAddress(), "Cannot add a delivery with an empty delivery address");
        Assert.notNull(delivery.getBillingAddress(), "Cannot add a delivery with an empty billing address");
        Assert.notNull(delivery.getItems(), "Cannot add a delivery with an no items");

        addressService.addAddress(delivery.getBillingAddress());
        addressService.addAddress(delivery.getDeliveryAddress());
        if(delivery.getReturnAddress() != null) addressService.addAddress(delivery.getReturnAddress());

        deliveryService.addDelivery(delivery.toDelivery(deliveryItemService));
    }

    /**
     * Removes a delivery from the repository.
     * Visible only to admins and requires authorization.
     * @param id The ID of the delivery being removed.
     * @throws IllegalArgumentException If the ID is not defined.
     */
    @DeleteMapping("/delivery/{id}")
    @Secured("ROLE_ADMIN")
    public void removeDelivery(@PathVariable("id") UUID id) throws IllegalArgumentException {
        Assert.notNull(id, "Delivery ID cannot be empty");

        deliveryService.removeDelivery(id);
    }
}
