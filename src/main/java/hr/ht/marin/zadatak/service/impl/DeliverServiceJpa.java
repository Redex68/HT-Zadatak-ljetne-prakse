package hr.ht.marin.zadatak.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import hr.ht.marin.zadatak.dao.DeliveryRepository;
import hr.ht.marin.zadatak.entitiy.Delivery;
import hr.ht.marin.zadatak.entitiy.DeliveryStatus;
import hr.ht.marin.zadatak.service.DeliveryService;

public class DeliverServiceJpa implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Delivery getDelivery(Long id) {
        if(id == null) throw new IllegalArgumentException("Delivery ID is null");
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
}
