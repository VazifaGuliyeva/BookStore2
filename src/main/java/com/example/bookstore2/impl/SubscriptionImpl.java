package com.example.bookstore2.impl;

import com.example.bookstore2.entity.Subscription;
import com.example.bookstore2.repository.SubscriptionRepository;
import com.example.bookstore2.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SubscriptionImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getById(int id) {
        return subscriptionRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        subscriptionRepository.deleteById(id);

    }
}
