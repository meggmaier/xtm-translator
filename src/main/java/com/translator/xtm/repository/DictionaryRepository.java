package com.translator.xtm.repository;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class DictionaryRepository {

    private final JSONObject repository;

    public DictionaryRepository(DictionaryJsonReader dictionaryJsonReader) {
        repository = dictionaryJsonReader.readJsonFile();
    }

    public String findById(String s) {
        assert repository.containsKey(s);
        return (String) repository.get(s);
    }

    public boolean existsById(String s) {
        return repository.containsKey(s);
    }

    public JSONObject findAll() {
        return repository;
    }
}
