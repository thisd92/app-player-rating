package br.com.devth.appJogador.entities;

import jakarta.persistence.*;

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private int numberMatches;
    private double rating;
    @ManyToMany
    @Column(name = "match_id")
    private Match match;

    public Player(){
    }

    public Player(Long id, String name, String position, int numberMatches) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.numberMatches = numberMatches;
        this.rating = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumberMatches() {
        return numberMatches;
    }

    public void setNumberMatches(int numberMatches) {
        this.numberMatches = numberMatches;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", numberMatches=" + numberMatches +
                ", rating=" + rating +
                '}';
    }
}
