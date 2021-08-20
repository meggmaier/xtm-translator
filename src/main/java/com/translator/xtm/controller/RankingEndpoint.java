package com.translator.xtm.controller;

import com.translator.xtm.repository.UsageHistory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/xtm/ranking")
public interface RankingEndpoint {

    @GetMapping
    List<UsageHistory> getRanking();
}
