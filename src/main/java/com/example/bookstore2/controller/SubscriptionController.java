package com.example.bookstore2.controller;

import com.example.bookstore2.entity.Subscription;
import com.example.bookstore2.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@AllArgsConstructor
public class SubscriptionController {

    private final SubscriptionService service;
    @GetMapping
    public List<Subscription> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Subscription getById(int id){
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(int id){
        service.delete(id);
    }
}
