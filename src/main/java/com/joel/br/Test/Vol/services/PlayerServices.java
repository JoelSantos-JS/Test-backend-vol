package com.joel.br.Test.Vol.services;

import com.joel.br.Test.Vol.Config.CodinomeHandler;
import com.joel.br.Test.Vol.model.Player;
import com.joel.br.Test.Vol.model.enums.GroupType;
import com.joel.br.Test.Vol.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServices {
    @Autowired
    private   PlayerRepository repository;
    @Autowired
    private   CodinomeHandler handler;


    public Player createPlayer(Player player ) {
        String codinome = getCodinome(player.getGroupType());
        player.setCodinome(codinome);
        return repository.save(player);
    }

    public String getCodinome(GroupType groupType) {
      return   handler.findCodinome(groupType);
    }
}
