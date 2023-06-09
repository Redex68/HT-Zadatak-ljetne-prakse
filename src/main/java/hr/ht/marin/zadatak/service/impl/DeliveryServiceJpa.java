package hr.ht.marin.zadatak.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hr.ht.marin.zadatak.dao.DeliveryRepository;
import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;
import hr.ht.marin.zadatak.service.DeliveryService;

@Service
public class DeliveryServiceJpa implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Delivery getDelivery(UUID id) {
        Assert.notNull(id, "Delivery ID cannot be null");
        Optional<Delivery> delivery = deliveryRepository.findById(id);

        if(delivery.isPresent()) return delivery.get();
        else return null;
    }

    @Override
    public Set<Delivery> getDeliveriesByStatus(DeliveryStatus status) {
        if(status == null) throw new IllegalArgumentException("Unknown delivery status");
        Set<Delivery> deliveries = deliveryRepository.findByStatus(status);
        return deliveries;
    }

    @Override
    public Set<Delivery> getDeliveriesInInterval(LocalDateTime start, LocalDateTime end) {
        if(start == null && end == null) throw new IllegalArgumentException("Start and end intervals cannot be both null");
        
        if(start == null) return deliveryRepository.findByIntervalEnd(end);
        else if(end == null) return deliveryRepository.findByIntervalStart(start);
        else return deliveryRepository.findByInterval(start, end);
    }

    @Override
    public Delivery addDelivery(Delivery delivery) {
        Assert.notNull(delivery, "Delivery cannot be null");
        Assert.isNull(delivery.getId(), "Cannot add a deliery with a predefined ID");

        return deliveryRepository.save(delivery);
    }

    @Override
    public void removeDelivery(UUID id) {
        Assert.notNull(id, "Delivery ID cannot be null");
        
        deliveryRepository.deleteById(id);
    }
}
