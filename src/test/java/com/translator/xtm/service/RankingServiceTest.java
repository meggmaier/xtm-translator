package com.translator.xtm.service;

import com.translator.xtm.repository.UsageHistory;
import com.translator.xtm.repository.UsageHistoryDao;
import com.translator.xtm.repository.UsageHistoryRepository;
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
class RankingServiceTest {

    @Autowired
    UsageHistoryDao usageHistoryDao;

    @Autowired
    RankingService rankingService;

    @Test
    void getRanking() {
        List<UsageHistory> ranking = rankingService.getRanking();

        assertEquals("Ala", ranking.get(0).getWord());
        assertEquals(4, ranking.get(0).getRanking());
    }

    @BeforeEach
    void prepare() {
        usageHistoryDao.save(new UsageHistory("Ala"));
        usageHistoryDao.save(new UsageHistory("Ala"));
        usageHistoryDao.save(new UsageHistory("Ala"));
        usageHistoryDao.save(new UsageHistory("Ala"));
        usageHistoryDao.save(new UsageHistory( "kot"));
    }
}