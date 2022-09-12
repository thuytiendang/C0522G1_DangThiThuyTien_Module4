package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculate(String num1, String num2, String calculator) {
        try {

            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double result = 0;
            switch (calculator) {
                case "addition":
                    result = number1 + number2;
                    break;
                case "subtraction":
                    result = number1 - number2;
                    break;
                case "multiplication":
                    result = number1 * number2;
                    break;
                case "division":
                    if (number2 == 0) {
                        return "can't not divide into 0!";
                    } else {
                        result = number1 / number2;
                    }
                    break;
            }

            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "not allow to input text!";
        }
    }
}
