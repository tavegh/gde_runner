package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @GetMapping("/getRaceRunners/{id}")
    public List<Runner> getRaceRunners(@PathVariable Long id) {
        Optional<Race> race = raceRepository.findById(id);
        if (race.isPresent()) {
            return race.get().getRunners();
        } else {
            throw new RuntimeException("Race not found with id: " + id);
        }
    }
    //updateRace - Verseny módosítása:
    @PutMapping("/updateRace/{id}")
    public Race updateRace(@PathVariable Long id, @RequestBody Race updatedRace) {
        return raceRepository.findById(id)
                .map(race -> {
                    race.setName(updatedRace.getName());
                    race.setDistance(updatedRace.getDistance());
                    return raceRepository.save(race);
                })
                .orElseThrow(() -> new RuntimeException("Race not found with id: " + id));
    }
    @GetMapping("/Versenyek")       //Versenyek html látszódjon
    public String listRaces(Model model) {
        List<Race> races = (List<Race>) raceRepository.findAll();
        model.addAttribute("races", races);
        return "Versenyek";
    }
}