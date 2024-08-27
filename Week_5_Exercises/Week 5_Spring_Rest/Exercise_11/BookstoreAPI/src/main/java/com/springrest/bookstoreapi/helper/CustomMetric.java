package com.springrest.bookstoreapi.helper;

import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CustomMetric {
    private final MeterRegistry meterRegistry;

    public CustomMetric(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }
    @PostConstruct
    public void init() {
        meterRegistry.counter("custom.books.sold", "store", "bookstore");

        meterRegistry.gauge("custom.books.available", this, CustomMetric::getAvailableBooks);
    }
    private double getAvailableBooks() {
        return 100.0;
    }
}
