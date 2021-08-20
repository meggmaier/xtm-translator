package com.translator.xtm.repository;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class DictionaryJsonReader {

    private final String jsonFileName = "dictionary.json";

    @SuppressWarnings("unchecked")
    public JSONObject readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        JSONObject json = null;
        try {
            URL resource = getClass().getClassLoader().getResource(jsonFileName);
            assert resource != null;
            FileReader reader = new FileReader(new File(resource.toURI()), StandardCharsets.UTF_8);
            json = (JSONObject) jsonParser.parse(reader);

        } catch (ParseException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return json;
    }
}
