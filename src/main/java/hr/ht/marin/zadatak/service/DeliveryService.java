package hr.ht.marin.zadatak.service;

import java.time.LocalDateTime;
import java.util.Set;

import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;

public interface DeliveryService {
    /**
     * Fetches the delivery with the specified ID.
     * @param id The delivery's ID.
     * @return A Delivery object or {@code null} if no such delivery exists.
     */
    Delivery getDelivery(long id);

    /**
     * Fetches all deliveries with the specified delivery status.
     * @param status The requested status.
     * @return A set of deliveries.
     */
    Set<Delivery> getDeliveriesByStatus(DeliveryStatus status);
    
    /**
     * Fetches every delivery created within the specified interval. If {@code start} is
     * {@code null} then the interval {@code <-inf, end]} is returned, else if {@code end} is
     * {@code null} then the interval {@code [start, +inf>} is returned. Only one of the two
     * arguments can be {@code null}.
     * @param start The start of the interval. 
     * @param end The end of the interval.
     * @return All events created within the specified interval.
     */
    Set<Delivery> getDeliveriesInInterval(LocalDateTime start, LocalDateTime end);

    /**
     * Adds a delivery to the database.
     * @param delivery The delivery that's being added.
     * @return The added delivery.
     */
    Delivery addDelivery(Delivery delivery);

    /**
     * Removes the delivery with the specified ID from the database.
     * @param id The ID of the delivery.
     */
    void removeDelivery(long id);
}
