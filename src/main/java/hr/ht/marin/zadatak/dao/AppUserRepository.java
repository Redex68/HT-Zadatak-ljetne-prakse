package hr.ht.marin.zadatak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.ht.marin.zadatak.entitiy.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    
}
