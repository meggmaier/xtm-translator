package com.translator.xtm.service;

import com.translator.xtm.repository.UsageHistory;
import com.translator.xtm.repository.UsageHistoryDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class TranslateServiceTest {

    @Autowired
    TranslateService translateService;

    @Autowired
    UsageHistoryDao usageHistoryDao;

    private final String sentence1 = "Ala ma kota.";
    private final String sentence2 = "Ala, jesteś sterem...";
    private final String sentence3 = "Nosisz \"spodnie\", więc \"walcz\"?!";
    private final String onlyPunctuation = "\"?.,()[]{}/!?;";

    @Test
    void getTranslation() {
        String translation1 = "Alice has a cat";
        String translation2 = "Alice you are the helm";
        String translation3 = "Nosisz trousers więc fight";

        assertEquals(translation1, translateService.getTranslation(sentence1, false));
        assertEquals(translation2, translateService.getTranslation(sentence2, false));
        assertEquals(translation3, translateService.getTranslation(sentence3, true));

        List<UsageHistory> repo = usageHistoryDao.findAll();
        assertEquals(9, repo.size());
    }

    @Test
    void isWordSpecific() {
        assertTrue(translateService.isWordSpecific("\"Ala\""));
        assertFalse(translateService.isWordSpecific("Ala"));
    }

    @Test
    void translate() {
        assertEquals( "Alice", translateService.translate("Ala"));
        assertEquals("trousers", translateService.translate("spodnie"));
        assertEquals("wiatrem", translateService.translate("wiatrem"));
    }

    @Test
    void removePunctuation() {
        String withoutPunctuation1 = "Ala ma kota";
        String withoutPunctuation2 = "Ala jesteś sterem";
        String withoutPunctuation3 = "Nosisz \"spodnie\" więc \"walcz\"";
        String withoutQuotes = "Nosisz spodnie więc walcz";

        assertEquals(withoutPunctuation1, translateService.removePunctuation(sentence1, true));
        assertEquals(withoutPunctuation2, translateService.removePunctuation(sentence2, true));
        assertEquals(withoutPunctuation3, translateService.removePunctuation(sentence3, true));
        assertEquals(withoutQuotes, translateService.removePunctuation(sentence3, false));
        assertEquals("", translateService.removePunctuation(onlyPunctuation, false));
    }
}