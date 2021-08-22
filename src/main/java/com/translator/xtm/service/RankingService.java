package com.translator.xtm.service;

import com.translator.xtm.repository.UsageHistory;
import com.translator.xtm.repository.UsageHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    UsageHistoryDao usageHistoryDao;

    public List<UsageHistory> getRanking() {
        return usageHistoryDao.findAll();
    }
}
