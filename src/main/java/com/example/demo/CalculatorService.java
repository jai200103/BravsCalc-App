package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public double calculate(double num1, double num2, String operation) throws IllegalArgumentException {
        return switch (operation) {
            case "add" -> num1 + num2;
            case "subtract" -> num1 - num2;
            case "multiply" -> num1 * num2;
            case "divide" -> {
                if (num2 == 0) throw new IllegalArgumentException("Cannot divide by zero");
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }

}
