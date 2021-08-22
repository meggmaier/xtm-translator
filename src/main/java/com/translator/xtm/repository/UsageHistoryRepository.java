package com.translator.xtm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public interface UsageHistoryRepository extends CrudRepository<UsageHistory, Long> {

    Optional<UsageHistory> findByWord(String word);

    @Override
    UsageHistory save(UsageHistory usageHistory);

    @Override
    @Query(value = "SELECT NEW UsageHistory(id, word, ranking) FROM UsageHistory ORDER BY ranking DESC")
    List<UsageHistory> findAll();
}
