package com.translator.xtm.repository.dictionary;

import com.translator.xtm.repository.DictionaryRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class DictionaryRepositoryTest {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Test
    public void testFindById() {
        String ala = dictionaryRepository.findById("Ala");

        assertEquals(ala, "Alice");
    }

    @Test
    public void testExistsById(){
        assertTrue(dictionaryRepository.existsById("Ala"));
        assertTrue(dictionaryRepository.existsById("kota"));
        assertFalse(dictionaryRepository.existsById("KOTA"));
        assertFalse(dictionaryRepository.existsById("alA"));
    }

    @Test
    public void testFindAll(){
        int size = dictionaryRepository.findAll().size();
        assertEquals(size, 11);
    }
}