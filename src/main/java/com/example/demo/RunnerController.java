package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

// /getRunners - Összes futó lekérdezése

@RestController
public class RunnerController {
    @Autowired
    private RunnerRepository RunnerRepository;

    @GetMapping("/getRunners")
    public List<Runner> getRunners() {
        return (List<Runner>) RunnerRepository.findAll();
    }
    // addRunner - futó hozzáadása

    @PostMapping("/addRunner")
    public Runner addRunner(@RequestBody Runner runner) {
        return RunnerRepository.save(runner);
    }

}
