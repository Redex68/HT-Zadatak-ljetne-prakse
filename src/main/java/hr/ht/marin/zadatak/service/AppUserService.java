package hr.ht.marin.zadatak.service;

import hr.ht.marin.zadatak.entitiy.AppUser;

public interface AppUserService {
    /**
     * Fetches the user with the specified username.
     * @param id The username of the user.
     * @return An AppUser object if a user is found, {@code null} otherwise.
     */
    AppUser getUser(String username);

    /**
     * Adds the user to the repository.
     * @param user The user being added.
     * @return The newly added user.
     */
    AppUser addUser(AppUser user);

    /**
     * Removes the user with the specified username
     * @param id The username of the user being removed.
     */
    void removeUser(String username);
}
