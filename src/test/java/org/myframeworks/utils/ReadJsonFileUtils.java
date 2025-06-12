package org.myframeworks.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.myframeworks.constants.FrameworkConstants;
import org.myframeworks.enums.ConfigProperties;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class ReadJsonFileUtils {

    private ReadJsonFileUtils() {
        // Private constructor to prevent instantiation
    }

    private static HashMap<String, String> jsonMap = new HashMap<>();

    static {
        try {
            jsonMap = new ObjectMapper().readValue(
                    new File(FrameworkConstants.getJsonConfigFilePath()),
                    new TypeReference<HashMap<String, String>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(ConfigProperties key) {
        if(jsonMap.containsKey(key.name().toLowerCase())) {
            return jsonMap.get(key.name().toLowerCase());
        } else {
            throw new IllegalArgumentException("Key not found in JSON config: " + key.name().toLowerCase());
        }
    }

}
