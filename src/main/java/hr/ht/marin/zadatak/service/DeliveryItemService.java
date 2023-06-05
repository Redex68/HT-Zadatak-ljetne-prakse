package hr.ht.marin.zadatak.service;

import hr.ht.marin.zadatak.entitiy.DeliveryItem;

public interface DeliveryItemService {
    /**
     * Fetches the item with the specified ID from the repository.
     * @param id The ID of the item.
     * @return The item.
     */
    public DeliveryItem getItem(long id);

    /**
     * Adds an item to the repository.
     * @param item The item that's being added.
     * @return The newly created item.
     */
    public DeliveryItem addItem(DeliveryItem item);

    /**
     * Removes the item with the specified ID from the repository.
     * @param id The ID of the item.
     */
    public void removeItem(long id);
}
