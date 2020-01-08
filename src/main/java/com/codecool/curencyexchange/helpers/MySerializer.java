package com.codecool.curencyexchange.helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MySerializer extends JsonSerializer<Double> {
    @Override
    public void serialize(Double value, JsonGenerator generator, SerializerProvider provider) {
        try {
            double roundedValue = value * 10000;
            roundedValue = Math.round(roundedValue);
            roundedValue = roundedValue / 10000;
            generator.writeNumber(roundedValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
