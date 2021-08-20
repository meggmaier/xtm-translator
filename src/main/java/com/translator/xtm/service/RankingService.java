package com.translator.xtm.service;

import com.translator.xtm.repository.UsageHistory;
import com.translator.xtm.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    UsageHistoryRepository usageHistoryRepository;

    public List<UsageHistory> getRanking() {
        return usageHistoryRepository.getWordsRanking();
    }
}
