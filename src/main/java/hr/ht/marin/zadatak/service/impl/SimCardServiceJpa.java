package hr.ht.marin.zadatak.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hr.ht.marin.zadatak.dao.SimCardRepository;
import hr.ht.marin.zadatak.entitiy.SimCard;
import hr.ht.marin.zadatak.service.SimCardService;

@Service
public class SimCardServiceJpa implements SimCardService {
    @Autowired SimCardRepository simCardRepository;

    @Override
    public SimCard addSimCard(SimCard card) {
        Assert.notNull(card, "Sim card cannot be null");
        
        return simCardRepository.save(card);
    }

    @Override
    public SimCard getSimCard(long id) {
        Optional<SimCard> card = simCardRepository.findById(id);
        
        if(card.isPresent()) return card.get();
        return null;
    }

    @Override
    public void removeSimCard(long id) {
        simCardRepository.deleteById(id);
    }
    
}
