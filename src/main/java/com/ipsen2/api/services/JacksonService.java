package com.ipsen2.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

/**
 * Service mainly for converting objects to JSON.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class JacksonService {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String writeValueAsString(ArrayList<Object> oList) throws JsonProcessingException {
        return mapper.writeValueAsString(oList);
    }


}
