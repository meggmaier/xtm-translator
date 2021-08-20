package com.translator.xtm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsageHistoryRepository extends CrudRepository<UsageHistory, Long> {

    List<UsageHistory> findByWord(String word);

    @Query(value = "SELECT NEW UsageHistory(word, COUNT (*))\n" +
            "  FROM UsageHistory\n" +
            "GROUP BY word\n" +
            "ORDER BY COUNT(*) DESC")
    List<UsageHistory> getWordsRanking();
}
