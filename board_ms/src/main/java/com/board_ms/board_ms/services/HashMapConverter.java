package com.board_ms.board_ms.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.TreeMap;

public class HashMapConverter implements AttributeConverter<TreeMap<Integer, String>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String convertToDatabaseColumn(TreeMap<Integer, String> customerInfo) {

        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(customerInfo);
        } catch (final JsonProcessingException e) {
//            logger.error("JSON writing error", e);
        }

        return customerInfoJson;
    }


    public TreeMap<Integer, String> convertToEntityAttribute(String customerInfoJSON) {

        TreeMap<Integer, String> customerInfo = null;
        try {
            customerInfo = objectMapper.readValue(customerInfoJSON, TreeMap.class);
        } catch (final IOException e) {
//            logger.error("JSON reading error", e);
        }

        return customerInfo;
    }

}