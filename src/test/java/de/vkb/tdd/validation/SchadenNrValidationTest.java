package de.vkb.tdd.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SchadenNrValidationTest {

    @Test
    void checkAValidSchadenNr() {
        String validSchadenNr = "TLM20000001";
        SchadenNrValidation validator = new SchadenNrValidation();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertTrue(actual);
    }

    @Test
    void returnFalseIfSchadenNrDoesNotStartWithTLM() {
        String validSchadenNr = "SLM20000001";
        SchadenNrValidation validator = new SchadenNrValidation();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

    @Test
    void returnFalseIfSchadenNrAfterTLMNotEndWithDigits(){
        String validSchadenNr = "TLMx0000001";
        SchadenNrValidation validator = new SchadenNrValidation();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

    @Test
    void returnFalseIfSchadenNrIsLongerThan10() {
        String validSchadenNr = "TLM200000011";
        SchadenNrValidation validator = new SchadenNrValidation();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

    @Test
    void returnFalseIfSchadenNrIsTLM20000000() {
        String validSchadenNr = "TLM00000000";
        SchadenNrValidation validator = new SchadenNrValidation();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

    @Test
    void shouldThrowNullPointerExceptionIfSchadenNrIsNull() {
        SchadenNrValidation validator = new SchadenNrValidation();
        Throwable exception = assertThrows(
                NullPointerException.class,
                () -> validator.validateSchadenNr(null)
        );
        assertEquals("SchadenNummer darf nicht NULL sein!", exception.getMessage());
    }

    @Test
    void returnFalseIfSchadenNrIsNotAlphanumeric() {
        String validSchadenNr = "TLM20000001$";
        SchadenNrValidation validator = new SchadenNrValidation();
        boolean actual = validator.validateSchadenNr(validSchadenNr);
        assertFalse(actual);
    }

}
