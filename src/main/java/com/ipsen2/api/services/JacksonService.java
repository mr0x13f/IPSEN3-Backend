package com.ipsen2.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipsen2.api.models.Project;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service mainly for converting objects to JSON.
 *
 * @author TimvHal
 * @version 31/10/2019
 */
public class JacksonService {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String writeValueAsString(ArrayList<Object> list) {
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static Object readValue(String jsonString, Class model) {
        Object o = null;
        try {
            o = mapper.readValue(jsonString, model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return o;
    }


}
