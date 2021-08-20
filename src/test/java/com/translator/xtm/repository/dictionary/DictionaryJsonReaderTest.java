package com.translator.xtm.repository.dictionary;

import com.translator.xtm.repository.DictionaryJsonReader;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DictionaryJsonReaderTest {

    @Autowired
    DictionaryJsonReader dictionaryJsonReader;

    @Test
    public void testFileReading() {
        JSONObject json = dictionaryJsonReader.readJsonFile();

        assertNotNull(json);
        assertEquals(json.get("Ala"), "Alice");
        assertEquals(json.size(), 11);
    }
}