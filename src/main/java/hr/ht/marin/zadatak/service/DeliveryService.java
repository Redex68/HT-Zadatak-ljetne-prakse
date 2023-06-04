package hr.ht.marin.zadatak.service;

import java.time.LocalDateTime;
import java.util.List;

import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;

public interface DeliveryService {
    /**
     * Fetches the delivery with the specified ID.
     * @param id The delivery's ID.
     * @return A Delivery object.
     */
    Delivery getDelivery(Long id);

    /**
     * Fetches all deliveries with the specified delivery status.
     * @param status The requested status.
     * @return A list of deliveries.
     */
    List<Delivery> getDeliveriesByStatus(DeliveryStatus status);
    
    /**
     * Fetches every delivery created within the specified interval. If {@code start} is
     * {@code null} then the interval {@code <-inf, end]} is returned, else if {@code end} is
     * {@code null} then the interval {@code [start, +inf>} is returned. Only one of the two
     * arguments can be {@code null}.
     * @param start The start of the interval. 
     * @param end The end of the interval.
     * @return All events created within the specified interval.
     */
    List<Delivery> getDeliveriesInInterval(LocalDateTime start, LocalDateTime end);
}
