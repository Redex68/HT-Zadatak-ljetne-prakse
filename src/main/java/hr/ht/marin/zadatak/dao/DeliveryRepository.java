package hr.ht.marin.zadatak.dao;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;

public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
    /**
     * Fetches a list of all the deliveries whose current status matches the provided {@code status}.
     * @param status The status of the deliveries.
     * @return A set of deliveries. If there are none, returns an empty set.
     */
    Set<Delivery> findByStatus(DeliveryStatus status);

    /**
     * Fetches all the deliveries created in the specified timeframe.
     * @param start The beginning of the timeframe. Inclusive.
     * @param end The end of the timeframe. Inclusive.
     * @return A set of deliveries. If there are none, returns an empty set.
     */
    @Query("SELECT d FROM Delivery d WHERE d.orderCreationTime >= :start AND d.orderCreationTime <= :end")
    Set<Delivery> findByInterval(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    /**
     * Fetches all the deliveries created after the specified date.
     * @param start The beginning of the timeframe. Inclusive.
     * @return A set of deliveries. If there are none, returns an empty set.
     */
    @Query("SELECT d FROM Delivery d WHERE d.orderCreationTime >= :start")
    Set<Delivery> findByIntervalStart(@Param("start") LocalDateTime start);

    /**
     * Fetches all the deliveries created before the specified date.
     * @param end The end of the timeframe. Inclusive.
     * @return A set of deliveries. If there are none, returns an empty set.
     */
    @Query("SELECT d FROM Delivery d WHERE d.orderCreationTime <= :end")
    Set<Delivery> findByIntervalEnd(@Param("end") LocalDateTime end);
}