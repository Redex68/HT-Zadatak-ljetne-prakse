package hr.ht.marin.zadatak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.ht.marin.zadatak.entitiy.DeliveryItem;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long> {
    
}
