package com.translator.xtm.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsageHistoryRepositoryTest {

    @Autowired
    UsageHistoryRepository usageHistoryRepository;

    @Test
    void findByWord() {

        List<UsageHistory> alaWord = usageHistoryRepository.findByWord("Ala");
        List<UsageHistory> piesWord = usageHistoryRepository.findByWord("pies");

        assertFalse(alaWord.isEmpty());
        assertEquals(4, alaWord.size());
        assertTrue(piesWord.isEmpty());
    }

    @Test
    void findAll() {
        List<UsageHistory> words = (List<UsageHistory>) usageHistoryRepository.findAll();

        assertEquals(5, words.size());
        for (UsageHistory entity: words) {
            assertNotNull(entity.getId());
            assertNotNull(entity.getDateOfUsage());
            assertNotNull(entity.getWord());
        }
    }

    @Test
    void getRanking() {
        List<UsageHistory> ranking = usageHistoryRepository.getWordsRanking();

        assertEquals("Ala", ranking.get(0).getWord());
        assertEquals(4, ranking.get(0).getRanking());

    }

    @BeforeEach
    void prepare() {
        usageHistoryRepository.save(new UsageHistory("Ala"));
        usageHistoryRepository.save(new UsageHistory("Ala"));
        usageHistoryRepository.save(new UsageHistory("Ala"));
        usageHistoryRepository.save(new UsageHistory("Ala"));
        usageHistoryRepository.save(new UsageHistory( "kot"));
    }
}