package br.com.devth.appJogador.controllers;

import br.com.devth.appJogador.entities.Match;
import br.com.devth.appJogador.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/matches")
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping
    public ResponseEntity<List<Match>> findAll(){
        List<Match> matchList = matchService.findAll();
        return ResponseEntity.ok().body(matchList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Match>> findById(@PathVariable Long id, @RequestBody Optional<Match> match){
        match = matchService.findById(id);
        return ResponseEntity.ok().body(match);
    }

    @PostMapping
    public ResponseEntity<Match> saveMatch(@RequestBody Match match){
        match = matchService.saveMatch(match);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(match.getId()).toUri();
        return ResponseEntity.created(uri).body(match);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Match> deleteMatch(@PathVariable Long id){
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Match> udpdateMatch(@PathVariable Long id, @RequestBody Match match){
        match = matchService.updateMatch(id, match);
        return ResponseEntity.ok().body(match);
    }
}
