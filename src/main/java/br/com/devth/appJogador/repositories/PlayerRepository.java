package br.com.devth.appJogador.repositories;

import br.com.devth.appJogador.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
