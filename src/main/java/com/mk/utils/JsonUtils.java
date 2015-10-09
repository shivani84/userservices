package com.mk.utils;

import com.mk.vo.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by shivani on 8/3/15.
 */
public class JsonUtils {
    public static <T> T jsonToPojo(String json, Class classType) {
        Object obj;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            obj = objectMapper.readValue(json, classType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return (T) obj;
    }

    public static String pojoToJson(Object instance) {
        String json;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(instance);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
