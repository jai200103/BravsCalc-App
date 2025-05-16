package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
	

	    @Autowired
	    private CalculatorService calculatorService;

	    @GetMapping("/")
	    public String welcome() {
	        return "welcome"; // welcome.html
	    }

	    @GetMapping("/calculator")
	    public String showCalculator() {
	        return "calculator"; // calculator.html (form)
	    }

	    @PostMapping("/calculate")
	    public String calculateResult(
	            @RequestParam double num1,
	            @RequestParam double num2,
	            @RequestParam String operation,
	            Model model) {

	        try {
	            double result = calculatorService.calculate(num1, num2, operation);
	            model.addAttribute("result", result);
	            model.addAttribute("num1", num1);
	            model.addAttribute("num2", num2);
	            model.addAttribute("operation", operation);
	        } catch (IllegalArgumentException e) {
	            model.addAttribute("error", e.getMessage());
	        }

	        return "calculator";  // Return same page with result or error shown
	    }
	}


