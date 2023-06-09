package hr.ht.marin.zadatak.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hr.ht.marin.zadatak.entitiy.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    /**
     * Returns a phone from the specified manufacturer with the given model name.
     * @param manufacturer The name of the manufacturer.
     * @param modelName The name of the phone's model.
     * @return A Phone object.
     */
    @Query("SELECT p FROM Phone p WHERE p.manufacturer = :manufacturer AND p.modelName = :model")
    Optional<Phone> findByName(@Param("manufacturer") String manufacturer, @Param("model") String modelName);
}
