package com.translator.xtm.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UsageHistoryRepositoryTest {

    @Autowired
    UsageHistoryDao usageHistoryDao;

    @Test
    void findAll() {
        List<UsageHistory> words = usageHistoryDao.findAll();

        assertEquals(3, words.size());
        assertEquals("Ala", words.get(0).getWord());
        assertEquals("ma", words.get(1).getWord());
        assertEquals("kota", words.get(2).getWord());

        for (UsageHistory entity: words) {
            assertNotNull(entity.getId());
            assertNotNull(entity.getWord());
            assertNotNull(entity.getRanking());

            if (entity.getWord().equals("Ala")) {
                assertEquals(4L, entity.getRanking());
            } else if (entity.getWord().equals("kota")) {
                assertEquals(1L, entity.getRanking());
            } else if (entity.getWord().equals("ma")) {
                assertEquals(3L, entity.getRanking());
            }
        }
    }

    @BeforeEach
    void prepare() {
        usageHistoryDao.save(new UsageHistory("Ala"));
        usageHistoryDao.save(new UsageHistory("Ala"));
        usageHistoryDao.save(new UsageHistory("Ala"));
        usageHistoryDao.save(new UsageHistory("Ala"));
        usageHistoryDao.save(new UsageHistory( "kota"));
        usageHistoryDao.save(new UsageHistory("ma"));
        usageHistoryDao.save(new UsageHistory("ma"));
        usageHistoryDao.save(new UsageHistory("ma"));
    }
}