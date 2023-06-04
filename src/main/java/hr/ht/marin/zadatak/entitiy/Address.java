package hr.ht.marin.zadatak.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"country", "city", "zipCode", "streetAddress"})
)
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
