package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.List;


@Component
public class DataInitializer {
    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public DataInitializer(RunnerRepository runnerRepository, RaceRepository raceRepository, ResultRepository resultRepository) {
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
        this.resultRepository = resultRepository;
    }

    @PostConstruct
    public void initData() {
        // Futók inicializálása
        Runner runner1 = new Runner("John", 25,"Male");
        Runner runner2 = new Runner("Alice", 30,"Female");
        Runner runner3 = new Runner("Bob", 28,"Male");
        Runner runner4 = new Runner("Emma", 35,"Female");

        runnerRepository.saveAll(List.of(runner1, runner2, runner3, runner4));

        // Versenyek inicializálása
        Race race1 = new Race("Marathon", 42);
        Race race2 = new Race("10K Run", 10);

        raceRepository.saveAll(List.of(race1, race2));

        // Eredmények inicializálása
        resultRepository.save(new Result(runner1, race1, 180)); // John, Marathon, 180 perc
        resultRepository.save(new Result(runner2, race1, 200)); // Alice, Marathon, 200 perc
        resultRepository.save(new Result(runner3, race1, 190)); // Bob, Marathon, 190 perc
        resultRepository.save(new Result(runner1, race2, 45)); // John, 10K Run, 45 perc
        resultRepository.save(new Result(runner4, race2, 50)); // Emma, 10K Run, 50 perc
    }
}
