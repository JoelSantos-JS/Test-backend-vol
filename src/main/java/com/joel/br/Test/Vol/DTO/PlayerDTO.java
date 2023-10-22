package com.joel.br.Test.Vol.DTO;

import com.joel.br.Test.Vol.model.enums.GroupType;

public record PlayerDTO (String name, String email , String codinome, String phoneNumber, GroupType groupType){
}
