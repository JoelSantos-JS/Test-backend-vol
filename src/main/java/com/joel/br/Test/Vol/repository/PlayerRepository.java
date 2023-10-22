package com.joel.br.Test.Vol.repository;

import com.joel.br.Test.Vol.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
