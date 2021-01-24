package de.vkb.tdd.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SchadenNrValidatorTest {

    @Test
    void checkAValidSchadenNr() {
        String validSchadenNr = "TLM20000001";
        SchadenNrValidator validator = new SchadenNrValidator();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertTrue(actual);
    }

    @Test
    void returnFalseIfSchadenNrDoesNotStartWithTLM() {
        String validSchadenNr = "SLM20000001";
        SchadenNrValidator validator = new SchadenNrValidator();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

    @Test
    void returnFalseIfSchadenNrAfterTLMNotEndWithDigits(){
        String validSchadenNr = "TLMx0000001";
        SchadenNrValidator validator = new SchadenNrValidator();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

    @Test
    void returnFalseIfSchadenNrIsLongerThan10() {
        String validSchadenNr = "TLM200000011";
        SchadenNrValidator validator = new SchadenNrValidator();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

    @Test
    void returnFalseIfSchadenNrIsTLM20000000() {
        String validSchadenNr = "TLM00000000";
        SchadenNrValidator validator = new SchadenNrValidator();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

    @Test
    void shouldThrowNullPointerExceptionIfSchadenNrIsNull() {
        SchadenNrValidator validator = new SchadenNrValidator();
        Throwable exception = assertThrows(
                NullPointerException.class,
                () -> validator.validateSchadenNr(null)
        );
        assertEquals("SchadenNummer darf nicht NULL sein!", exception.getMessage());
    }

    @Test
    void returnFalseIfSchadenNrIsNotAlphanumeric() {
        String validSchadenNr = "TLM20000001$";
        SchadenNrValidator validator = new SchadenNrValidator();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

}
