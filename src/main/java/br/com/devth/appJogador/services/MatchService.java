package br.com.devth.appJogador.services;

import br.com.devth.appJogador.entities.Match;
import br.com.devth.appJogador.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> findAll(){
        return matchRepository.findAll();
    }

    public Optional<Match> findById(Long id){
        return matchRepository.findById(id);
    }

    public Match saveMatch(Match match){
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);;
    }

    public Match updateMatch(Long id, Match match) {
        Match entity = matchRepository.getReferenceById(id);
        updateData(entity, match);
        return matchRepository.save(entity);
    }

    private void updateData(Match entity, Match match) {
        entity.setLocal(match.getLocal());
        entity.setDateMatch(match.getDateMatch());
        entity.setTypeMatch(match.getTypeMatch());
    }
}
