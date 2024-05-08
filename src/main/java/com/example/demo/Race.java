package com.example.demo;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int distance;

    // Konstruktorok, getterek és setterek

    public Race() {
    }

    public Race(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
    @OneToMany(mappedBy = "race")
    private List<Result> results;

    // Konstruktor, getterek, setterek...

    public List<Runner> getRunners() {
        // Implementáld ezt a metódust úgy, hogy visszaadj egy listát
        // a versenyhez tartozó futókról
        // Például:
        return results.stream()
                .map(Result::getRunner)
                .collect(Collectors.toList());
    }

    // Getterek és setterek

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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

