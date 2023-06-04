package hr.ht.marin.zadatak.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Country name cannot be empty")
    private String country;
    @NotBlank(message = "City name cannot be empty")
    private String city;
    @NotNull(message = "Zip code cannot be null")
    private Long zipCode;
    @NotBlank(message = "Street address cannot be empty")
    private String streetAddress;    

    public Address(@NotBlank(message = "Country name cannot be empty") String country,
            @NotBlank(message = "City name cannot be empty") String city,
            @NotNull(message = "Zip code cannot be null") Long zipCode,
            @NotBlank(message = "Street address cannot be empty") String streetAddress) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
    }
    
    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Long getZipCode() {
        return zipCode;
    }
    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
