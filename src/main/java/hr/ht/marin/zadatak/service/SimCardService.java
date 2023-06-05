package hr.ht.marin.zadatak.service;

import hr.ht.marin.zadatak.entitiy.SimCard;

public interface SimCardService {
    /**
     * Fetch the sim card with the specified ID.
     * @param id The ID of the sim card.
     * @return The sim card or {@code null} if no such sim card exists.
     */
    SimCard getSimCard(long id);

    /**
     * Adds the sim card to the repository.
     * @param card The sim card being added.
     * @return The newly created sim card.
     */
    SimCard addSimCard(SimCard card);

    /**
     * Remove the sim card from the repository.
     * @param card The card's ID.
     */
    void removeSimCard(long id);
}
