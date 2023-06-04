package hr.ht.marin.zadatak.dao;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Set<Delivery> findByStatus(DeliveryStatus status);

    @Query("SELECT d FROM Delivery d WHERE d.orderCreationTime >= :start AND d.orderCreationTime <= :end")
    Set<Delivery> findByInterval(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("SELECT d FROM Delivery d WHERE d.orderCreationTime >= :start")
    Set<Delivery> findByIntervalStart(@Param("start") LocalDateTime start);

    @Query("SELECT d FROM Delivery d WHERE d.orderCreationTime <= :end")
    Set<Delivery> findByIntervalEnd(@Param("end") LocalDateTime end);
}