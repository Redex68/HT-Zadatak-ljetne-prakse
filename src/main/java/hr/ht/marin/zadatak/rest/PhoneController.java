package hr.ht.marin.zadatak.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hr.ht.marin.zadatak.entitiy.Phone;
import hr.ht.marin.zadatak.service.PhoneService;

@RestController
public class PhoneController {
    @Autowired PhoneService phoneService;

    /**
     * Fetches a phone from the specified manufacturer.
     * Publicly visible and doesn't require authentication.
     * @param manufacturer The name of the phone's manufacturer.
     * @param modelName The phone's model name.
     * @return A phone.
     * @throws IllegalArgumentException If the manufacturer of model name are not defined.
     * @throws NotFoundException If the phone doesn't exist in the repository.
     */
    @GetMapping("public/phone/{manufacturer}/{modelName}")
    @Secured({})
    public Phone getPhone(@PathVariable("manufacturer") String manufacturer, @PathVariable("modelName") String modelName) throws IllegalArgumentException, NotFoundException
    {
        Assert.notNull(manufacturer, "Unknown phone manufacturer");
        Assert.notNull(modelName, "Unknown phone model");
        
        Phone phone = phoneService.getPhone(manufacturer, modelName);
        if(phone == null) throw new NotFoundException("Phone doesn't exist in the database");
        else return phone;
    }

    /**
     * Removes a phone from the repository.
     * Visible only to admins and requires authorization.
     * @param id The ID of the phone being removed.
     * @throws IllegalArgumentException If the id isn't defined.
     */
    @DeleteMapping("phone/{id}")
    @Secured("ROLE_ADMIN")
    public void removePhone(@PathVariable("id") Long id) throws IllegalArgumentException
    {
        Assert.notNull(id, "No phone ID");

        phoneService.removePhone(id);
    }
}
