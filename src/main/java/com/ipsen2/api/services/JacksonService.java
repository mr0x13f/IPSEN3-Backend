package com.ipsen2.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Service mainly for converting objects to JSON.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class JacksonService {

    private static ObjectMapper mapper;

    public static String writeValueAsString(Object o) throws JsonProcessingException {
        String jsonString = "";
        jsonString = mapper.writeValueAsString(o);
        return jsonString;
    }


}
