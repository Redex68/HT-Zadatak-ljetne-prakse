package hr.ht.marin.zadatak.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hr.ht.marin.zadatak.dao.DeliveryItemRepository;
import hr.ht.marin.zadatak.entitiy.DeliveryItem;
import hr.ht.marin.zadatak.service.DeliveryItemService;

@Service
public class DeliveryItemServiceJpa implements DeliveryItemService {
    @Autowired DeliveryItemRepository deliveryItemRepository;

    @Override
    public DeliveryItem addItem(DeliveryItem item) {
        Assert.notNull(item, "Cannot add an empty item to the repository");

        return deliveryItemRepository.save(item);
    }

    @Override
    public DeliveryItem getItem(long id) {
        Optional<DeliveryItem> item = deliveryItemRepository.findById(id);

        if(item.isPresent()) return item.get();
        else return null;
    }

    @Override
    public void removeItem(long id) {
        deliveryItemRepository.deleteById(id);
    }
    
}
