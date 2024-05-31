package com.example.demo.Service;

import jakarta.persistence.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    @Cacheable("users")
    public String getUerById(String userId) {
        simulateSlowService();
        return "User" + userId;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
