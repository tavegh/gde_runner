package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {
    @Autowired
    private ResultRepository ResultRepository;

    @PostMapping("/addResult")
    public Result addResult(@RequestBody Result result) {
        return ResultRepository.save(result);
    }

    @GetMapping("/getAverageTime/{id}")
    public double getAverageTime(@PathVariable Long id) {
        List<Result> results = ResultRepository.findByRaceId(id);
        if (results.isEmpty()) {
            return 0.0;
        } else {
            double totalTime = results.stream().mapToDouble(result -> Double.parseDouble(result.getTime())).sum();
            return totalTime / results.size();
        }
    }
}
