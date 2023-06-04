package hr.ht.marin.zadatak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.ht.marin.zadatak.entitiy.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
