package hr.ht.marin.zadatak.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.ht.marin.zadatak.entitiy.Delivery;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @GetMapping("/{id}")
    public Delivery getDelivery(@PathParam("id") Long id)
    {
        return null;
    }
}
