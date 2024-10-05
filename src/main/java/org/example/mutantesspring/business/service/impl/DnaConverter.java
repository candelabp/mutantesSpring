package org.example.mutantesspring.business.service.impl;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DnaConverter implements AttributeConverter<String[], String> {

    @Override
    public String convertToDatabaseColumn(String[] dnaArray) {
        if (dnaArray == null || dnaArray.length == 0) {
            return null;
        }
        return String.join(",", dnaArray);
    }

    @Override
    public String[] convertToEntityAttribute(String dnaString) {
        if (dnaString == null || dnaString.isEmpty()) {
            return new String[0];
        }
        return dnaString.split(",");
    }
}
