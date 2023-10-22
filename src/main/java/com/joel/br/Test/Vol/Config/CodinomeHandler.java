package com.joel.br.Test.Vol.Config;

import com.joel.br.Test.Vol.model.enums.GroupType;
import com.joel.br.Test.Vol.services.CodinomeServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CodinomeHandler {

    @Autowired
    private  CodinomeServices services;



    public String findCodinome(GroupType codinome) {
        if (codinome == GroupType.AVANGERS) {
            List<String> avangers = services.getAvangerss();
            if (avangers != null && !avangers.isEmpty()) {
                String first = avangers.get(0);
                avangers.remove(0);
                return first;
            } else {
                // Handle the case when avangers list is empty or null
                return "No available codenames for AVANGERS";
            }
        } else if (codinome == GroupType.JUSTICE_LEAGUE) {
            List<String> justiceLeague = services.getJusticeLeague();
            if (justiceLeague != null && !justiceLeague.isEmpty()) {
                String first = justiceLeague.get(0);
                justiceLeague.remove(0);
                return first;
            } else {
                // Handle the case when justiceLeague list is empty or null
                return "No available codenames for JUSTICE_LEAGUE";
            }
        }
        return "Invalid GroupType";
    }


}
