package com.example.demo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;
    public Computer() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> comList = new ArrayList<>();
        SecureRandom random = new SecureRandom();
        while(comList.size() < 3) {
            int ball = random.nextInt(9) + 1;
            if (!comList.contains(ball)) {
               comList.add(ball);
            }
        }
        return comList;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
