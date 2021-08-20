package com.translator.xtm.controller;

import com.translator.xtm.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController implements TranslateEndpoint{

    @Autowired
    TranslateService translateService;

    @Override
    public String translate(String sentence, boolean specific) {
        return translateService.getTranslation(sentence, specific);
    }
}
