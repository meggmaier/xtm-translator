package com.translator.xtm.service;

import com.translator.xtm.repository.DictionaryRepository;
import com.translator.xtm.repository.UsageHistory;
import com.translator.xtm.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class TranslateService {

    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    UsageHistoryRepository usageHistoryRepository;

    private final String LEAVE_QUOTES_REGEX = "[^a-zA-Z \"ąĄęĘżŻźŹśŚóÓłŁńŃćĆ]";
    private final String SPECIFIC_WORD_REGEX = "\"([^\"]*)\"";
    private final String PUNCTUATION_REGEX = "[^a-zA-Z ąĄęĘżŻźŹśŚóÓłŁńŃćĆ]";

    public String getTranslation(String sentence, boolean specific) {
        String translation = "";
        sentence = removePunctuation(sentence, specific);
        List<String> wordsOfSentence = Arrays.asList(sentence.split(" "));

        if (specific) {
            StringJoiner joiner = new StringJoiner(" ");
            for (String word: wordsOfSentence) {
                if (isWordSpecific(word)) {
                    word = translate(word);
                }
                joiner.add(word);
                usageHistoryRepository.save(new UsageHistory(word));
            }
            translation = joiner.toString();
        } else {
            translation = wordsOfSentence.stream()
                    .map(this::translate)
                    .collect(Collectors.joining(" "));

            wordsOfSentence.forEach(word -> usageHistoryRepository.save(new UsageHistory(word)));
        }
        return translation;
    }

    public boolean isWordSpecific(String word) {
        Pattern pattern = Pattern.compile(SPECIFIC_WORD_REGEX);
        return pattern.matcher(word).find();
    }

    public String translate(String word) {
        word = word.replaceAll(PUNCTUATION_REGEX, "");
        if (dictionaryRepository.existsById(word)) {
            word = dictionaryRepository.findById(word);
        }
        return word;
    }

    public String removePunctuation(String sentence, boolean specific) {
        if (specific) {
            sentence = sentence.replaceAll(LEAVE_QUOTES_REGEX, "");
        } else {
            sentence = sentence.replaceAll(PUNCTUATION_REGEX, "");
        }
        return sentence;
    }
}
