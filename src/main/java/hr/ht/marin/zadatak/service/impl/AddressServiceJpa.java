package hr.ht.marin.zadatak.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hr.ht.marin.zadatak.dao.AddressRepository;
import hr.ht.marin.zadatak.entitiy.Address;
import hr.ht.marin.zadatak.service.AddressService;

@Service
public class AddressServiceJpa implements AddressService {
    @Autowired AddressRepository addressRepository;

    @Override
    public Address getAddress(long id) {
        Optional<Address> address =addressRepository.findById(id);
        if(address.isPresent()) return address.get();
        else return null;
    }

    @Override
    public Address addAddress(Address address) {
        Assert.notNull(address, "New address cannot be null");

        return addressRepository.save(address);
    }

    @Override
    public void removeAddress(long id) {
        addressRepository.deleteById(id);
    }
    
}
