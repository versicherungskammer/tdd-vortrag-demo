package de.vkb.tdd.validation;

import org.springframework.stereotype.Component;

@Component
public class SchadenNrValidator {

    public boolean validateSchadenNr(String schadenNr) {

        if (schadenNr == null) throw new NullPointerException("SchadenNummer darf nicht NULL sein!");

        String tail = schadenNr.substring(3);

        if (!schadenNr.startsWith("TLM")) return false;

        if (!containsNonDigits(tail)) return false;

        if (schadenNr.length() != 11) return false;

        return !schadenNr.equals("TLM00000000");
    }

    private boolean containsNonDigits(String tail) {

        char[] chars = tail.toCharArray();

        for (char c: chars) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNonAlphanumeric(String schadenNr) {
        char[] chars = schadenNr.toCharArray();
        for (char c: chars) {
            if (!Character.isLetterOrDigit(c))
                return false;
        }
        return true;
    }

}
