package br.com.devth.appJogador.services;

import br.com.devth.appJogador.entities.Player;
import br.com.devth.appJogador.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    public List<Player> findAll(){
        return playerRepository.findAll();
    }
    public Optional<Player> findById(Long id){
        return playerRepository.findById(id);
    }

    public Player savePlayer(Player match){
        return playerRepository.save(match);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);;
    }

    public Player updatePlayer(Long id, Player match) {
        Player entity = playerRepository.getReferenceById(id);
        updateData(entity, match);
        return playerRepository.save(entity);
    }

    private void updateData(Player entity, Player match) {
        entity.setName(match.getName());
        entity.setPosition(match.getPosition());
        entity.setRating(match.getRating());
    }
}
