package br.com.devth.appJogador.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateMatch;
    private String local;
    private String typeMatch;
    @ManyToMany(mappedBy = "matches")
    private Set<Player> players;

    public Match(){
    }

    public Match(Long id, Date dateMatch, String local, String typeMatch, Player player) {
        this.id = id;
        this.dateMatch = dateMatch;
        this.local = local;
        this.typeMatch = typeMatch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTypeMatch() {
        return typeMatch;
    }

    public void setTypeMatch(String typeMatch) {
        this.typeMatch = typeMatch;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", dateMatch=" + dateMatch +
                ", local='" + local + '\'' +
                ", typeMatch='" + typeMatch + '\'' +
                '}';
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        player.getMatches().add(this);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
        player.getMatches().remove(this);
    }
}
