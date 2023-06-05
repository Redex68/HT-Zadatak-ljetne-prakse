package hr.ht.marin.zadatak.service;

import hr.ht.marin.zadatak.entitiy.Phone;

public interface PhoneService {
    /**
     * Fetches the phone with the specified ID.
     * @param id The ID of the phone.
     * @return A Phone object.
     */
    public Phone getPhone(long id);

    /**
     * Fetches the phone from the specified manufacturer.
     * @param manufacturer The name of the manufacturer.
     * @param modelName The phone's model name.
     * @return The Phone.
     */
    public Phone getPhone(String manufacturer, String modelName);

    /**
     * Adds a new phone to the database.
     * @param phone The phone being added.
     * @return The added phone.
     */
    public Phone addPhone(Phone phone);

    /**
     * Removes the phone from the database.
     * @param id The ID of the phone that's being removed.
     */
    public void removePhone(long id);
}
