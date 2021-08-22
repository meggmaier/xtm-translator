package com.translator.xtm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsageHistoryDao {

    @Autowired
    UsageHistoryRepository usageHistoryRepository;

    public UsageHistory save(UsageHistory entity) {
        Optional<UsageHistory> optionalFind = usageHistoryRepository.findByWord(entity.getWord());

        if (optionalFind.isPresent()) {
            UsageHistory usageHistory = optionalFind.get();
            Long ranking = usageHistory.getRanking();
            ranking++;
            usageHistory.setRanking(ranking);
            return usageHistoryRepository.save(usageHistory);
        } else {
            return usageHistoryRepository.save(entity);
        }
    }

    public List<UsageHistory> findAll() {
        return usageHistoryRepository.findAll();
    }
}
