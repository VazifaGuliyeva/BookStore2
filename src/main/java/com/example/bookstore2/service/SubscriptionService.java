package com.example.bookstore2.service;

import com.example.bookstore2.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    List<Subscription> getAll();

    Subscription getById(int id);

    void delete(int id);

}
