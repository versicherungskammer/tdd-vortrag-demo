package de.vkb.tdd.serivce;

import de.vkb.tdd.validation.SchadenNrValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchadenNrService {

    private SchadenNrValidation schadenValidation;
    private List<String> schadenDb = new ArrayList<>();

    @Autowired
    public SchadenNrService(SchadenNrValidation schadenValidation) {
        this.schadenValidation = schadenValidation;
        schadenDb.add("TLM20000001");
        schadenDb.add("TLM20000002");
        schadenDb.add("TLM20000003");
    }

    public boolean isSchadenNrExist(String schadenNr) {

        boolean validation = schadenValidation.validateSchadenNr(schadenNr);

        if (validation)
            return schadenDb.contains(schadenNr);
        else return false;

    }
}
