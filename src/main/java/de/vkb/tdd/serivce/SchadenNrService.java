package de.vkb.tdd.serivce;

import de.vkb.tdd.validation.SchadenNrValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchadenNrService {

    private SchadenNrValidator validator;
    private List<String> schadenDb = new ArrayList<>();

    @Autowired
    public SchadenNrService(SchadenNrValidator validator) {
        this.validator = validator;
        schadenDb.add("TLM20000001");
        schadenDb.add("TLM20000002");
        schadenDb.add("TLM20000003");
    }

    public boolean isSchadenNrExist(String schadenNr) {

        boolean validation = validator.validateSchadenNr(schadenNr);

        if (validation)
            return schadenDb.contains(schadenNr);
        else return false;

    }
}
