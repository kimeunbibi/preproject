package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int a, int b){
        return a+b;
    }
    public int substract(int a, int b){
        return a-b;
    }
}
