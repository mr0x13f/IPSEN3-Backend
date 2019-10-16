package com.ipsen2.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Service mainly for converting objects to JSON.
 *
 * @author TimvHal
 * @version 16/10/2019
 */
public class JacksonService {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String writeValueAsString(ArrayList<Object> oList) {
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(oList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static ArrayList<Object> readValue(String jsonString, Class model) {
        ArrayList<Object> oList  = new ArrayList<>();
        try {
            oList = mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(ArrayList.class, model));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return oList;
    }


}
