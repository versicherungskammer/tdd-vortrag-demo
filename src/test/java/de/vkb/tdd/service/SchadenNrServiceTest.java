package de.vkb.tdd.service;

import de.vkb.tdd.serivce.SchadenNrService;
import de.vkb.tdd.validation.SchadenNrValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@SpringBootTest
public class SchadenNrServiceTest {

    @Autowired
    SchadenNrService schadenNrService;

    @MockBean
    SchadenNrValidator schadenNrValidator;

    @Test
    void returnTrueIfSchadenNrExist() {
        // Stub
        String schadenNr = "TLM20000001";
        when(schadenNrValidator.validateSchadenNr(schadenNr)).thenReturn(true);
        boolean actual = schadenNrService.isSchadenNrExist(schadenNr);
        assertTrue(actual);
    }

    @Test
    void isSchadenNrExistShouldBeCalledExactlyOnce() {
        // Mock
        String schadenNr = "TLM20000001";
        when(schadenNrValidator.validateSchadenNr(any())).thenReturn(anyBoolean());
        schadenNrService.isSchadenNrExist(schadenNr);
        verify(schadenNrValidator, times(1)).validateSchadenNr(schadenNr);
    }
}
