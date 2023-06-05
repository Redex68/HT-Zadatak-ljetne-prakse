package hr.ht.marin.zadatak.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hr.ht.marin.zadatak.dao.AppUserRepository;
import hr.ht.marin.zadatak.entitiy.AppUser;
import hr.ht.marin.zadatak.service.AppUserService;

@Service
public class AppUserServiceJpa implements AppUserService {
    @Autowired AppUserRepository appUserRepository;
    
    @Override
    public AppUser getUser(String username) {
        Optional<AppUser> user = appUserRepository.findById(username);
        if(user.isPresent()) return user.get();
        else return null;
    }

    @Override
    public AppUser addUser(AppUser user) {
        Assert.notNull(user, "The new user cannot be null");

        return appUserRepository.save(user);
    }

    @Override
    public void removeUser(String username) {
        appUserRepository.deleteById(username);
    }
    
}
