package com.translator.xtm.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/xtm/translate")
public interface TranslateEndpoint {

    @PostMapping("/{specific}")
    String translate(@RequestBody String sentence, @PathVariable boolean specific);
}
