package br.com.devth.appJogador.repositories;

import br.com.devth.appJogador.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
