package br.com.devth.appJogador.entities;

import jakarta.persistence.*;

import java.util.Date;

public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateMatch;
    private String local;
    private String typeMatch;
    @ManyToMany
    @Column(name = "player_id")
    private Player player;

    public Match(){
    }

    public Match(Long id, Date dateMatch, String local, String typeMatch, Player player) {
        this.id = id;
        this.dateMatch = dateMatch;
        this.local = local;
        this.typeMatch = typeMatch;
        this.player = player;
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

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", dateMatch=" + dateMatch +
                ", local='" + local + '\'' +
                ", typeMatch='" + typeMatch + '\'' +
                '}';
    }
}
