package com.example.demo;
import com.example.demo.Service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorServiceTest {
    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdd(){
        int result = calculatorService.add(1,2);
        assertEquals(3, result);
    }

    @Test
    public void testSubtract(){
        int result = calculatorService.substract(5,3);
        assertEquals(2, result);
    }
}
