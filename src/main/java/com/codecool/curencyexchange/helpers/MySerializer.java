package com.codecool.curencyexchange.helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class MySerializer extends JsonSerializer<Double> {
    @Override
    public void serialize(Double value, JsonGenerator generator, SerializerProvider provider) {
        try {
            BigDecimal d = new BigDecimal(value);
            generator.writeNumber(d.toPlainString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
