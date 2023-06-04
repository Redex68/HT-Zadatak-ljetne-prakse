package hr.ht.marin.zadatak.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.ht.marin.zadatak.entitiy.Phone;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    List<String> removedPhones = new ArrayList<>();

    @GetMapping("/{modelName}")
    @Secured("ROLE_USER")
    public Phone getPhone(@PathVariable("modelName") String modelName)
    {
        if(modelName == null) throw new IllegalArgumentException("Unknown phone model");
        if(removedPhones.contains(modelName)) throw new IllegalArgumentException("Phone was deleted");
        switch(modelName)
        {
            case "Galaxy S23":
                return new Phone("Samsung", "Galaxy S23", 1000.0);
            case "Galaxy Z Fold":
                return new Phone("Samsung", "Galaxy Z Fold", 2000.0);
            case "Fairphone 4":
                return new Phone("Fairphone", "Fairphone 4", 700.0);
            default:
                throw new IllegalArgumentException("Unknown phone model");
        }
    }

    @DeleteMapping("/{modelName}")
    @Secured("ROLE_ADMIN")
    public void removePhone(@PathVariable("modelName") String modelName)
    {
        removedPhones.add(modelName);
    }
}
