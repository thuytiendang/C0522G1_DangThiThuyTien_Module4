package com.conversion.service.impl;

import com.conversion.service.ICurrencyConversionService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {

    @Override
    public Double calculate(Double money) {
        return money*23000;
    }
}
