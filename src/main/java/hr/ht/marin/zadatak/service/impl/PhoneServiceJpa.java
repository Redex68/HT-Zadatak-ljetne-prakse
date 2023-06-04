package hr.ht.marin.zadatak.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import hr.ht.marin.zadatak.dao.PhoneRepository;
import hr.ht.marin.zadatak.entitiy.Phone;
import hr.ht.marin.zadatak.service.PhoneService;

public class PhoneServiceJpa implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone getPhone(Long id) {
        Assert.notNull(id, "ID cannot be null");

        Optional<Phone> phone = phoneRepository.findById(id);
        if(phone.isPresent()) return phone.get();
        return null;
    }

    @Override
    public Phone getPhone(String manufacturer, String modelName) {
        Assert.notNull(manufacturer, "Manufacturer cannot be null");
        Assert.notNull(modelName, "Model name cannot be null");

        Optional<Phone> phone = phoneRepository.findByName(manufacturer, modelName);
        if(phone.isPresent()) return phone.get();
        return null;
    }

    @Override
    public Phone addPhone(Phone phone) {
        Assert.notNull(phone, "New phone cannot be null");

        return phoneRepository.save(phone);
    }
    
}
