package com.translator.xtm.controller;

import com.translator.xtm.repository.UsageHistory;
import com.translator.xtm.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingController implements RankingEndpoint{

    @Autowired
    RankingService rankingService;

    @Override
    public List<UsageHistory> getRanking() {
        return rankingService.getRanking();
    }
}
