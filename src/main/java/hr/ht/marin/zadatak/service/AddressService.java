package hr.ht.marin.zadatak.service;

import hr.ht.marin.zadatak.entitiy.Address;

public interface AddressService {
    /**
     * Returns the address with the specified ID.
     * @param id The address' ID.
     * @return An address object.
     */
    Address getAddress(long id);

    /**
     * Add a new address to the database.
     * @param address The address being added.
     * @return The newly added address.
     */
    Address addAddress(Address address);

    /**
     * Removes the address with the specified ID from the database.
     * @param id The ID of the address.
     */
    void removeAddress(long id);
}
