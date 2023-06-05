package hr.ht.marin.zadatak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.ht.marin.zadatak.entitiy.SimCard;

public interface SimCardRepository extends JpaRepository<SimCard, Long> {
    
}
