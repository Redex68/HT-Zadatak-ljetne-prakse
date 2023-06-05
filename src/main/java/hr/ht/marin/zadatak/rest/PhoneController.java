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

    @GetMapping("public/phone/{manufacturer}/{modelName}")
    @Secured({})
    public Phone getPhone(@PathVariable("manufacturer") String manufacturer, @PathVariable("modelName") String modelName)
    {
        Assert.notNull(manufacturer, "Unknown phone manufacturer");
        Assert.notNull(modelName, "Unknown phone model");
        
        Phone phone = phoneService.getPhone(manufacturer, modelName);
        if(phone == null) throw new NotFoundException("Phone doesn't exist in the database");
        else return phone;
    }

    @DeleteMapping("phone/{id}")
    @Secured("ROLE_ADMIN")
    public void removePhone(@PathVariable("id") Long id)
    {
        Assert.notNull(id, "No phone ID");

        phoneService.removePhone(id);
    }
}
