package br.com.devth.appJogador.controllers;

import br.com.devth.appJogador.entities.Player;
import br.com.devth.appJogador.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> findAll(){
        List<Player> matchList = playerService.findAll();
        return ResponseEntity.ok().body(matchList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Player>> findById(@PathVariable Long id, @RequestBody Optional<Player> player){
        player = playerService.findById(id);
        return ResponseEntity.ok().body(player);
    }

    @PostMapping
    public ResponseEntity<Player> saveMatch(@RequestBody Player player){
        player = playerService.savePlayer(player);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(player.getId()).toUri();
        return ResponseEntity.created(uri).body(player);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Player> deleteMatch(@PathVariable Long id){
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Player> udpdateMatch(@PathVariable Long id, @RequestBody Player player){
        player = playerService.updatePlayer(id, player);
        return ResponseEntity.ok().body(player);
    }
}
