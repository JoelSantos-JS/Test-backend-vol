package com.joel.br.Test.Vol.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.br.Test.Vol.DTO.PlayerDTO;
import com.joel.br.Test.Vol.model.Player;
import com.joel.br.Test.Vol.services.PlayerServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/players")
@AllArgsConstructor
public class PlayerController {

    private  final PlayerServices services;
    private  final ObjectMapper mapper;



    @PostMapping
    public ResponseEntity<Player> create(@RequestBody @Valid PlayerDTO player) {
      Player player1 =  mapper.convertValue(player, Player.class);

        return  ResponseEntity.ok().body(services.createPlayer(player1));
    }
}
