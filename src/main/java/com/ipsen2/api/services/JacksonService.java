package com.ipsen2.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Service mainly for converting objects to JSON.
 *
 * @author TimvHal
 */
public class JacksonService {

    private static JacksonService jService;
    private ObjectMapper mapper;

    static {
        jService = new JacksonService();
    }

    private JacksonService() {

    }

    public static JacksonService getInstance() {
        return jService;
    }

    public String writeValueAsString(Object o) {
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) { //Dat gaat fout pannenkoek.
            e.printStackTrace();
        }
        return jsonString;
    }


}
