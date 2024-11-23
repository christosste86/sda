package com.sda.sdaspring.controllers;

import com.sda.sdaspring.models.Bird;
import com.sda.sdaspring.services.BirdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class BirdController {
    @GetMapping("/")
    public String getMainPage(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("welcomeString", "Welcome to the Charming Birdhouse");
        if(Objects.nonNull(search)){
            model.addAttribute("birds", BirdService.getBirdsbyName(search));
        } else {
            model.addAttribute("birds", BirdService.getBirds());
        }
        return "index";
    }

    @GetMapping("/add-bird")
    public String getBirdForm() {

        return "add-bird";
    }

    @PostMapping("/add-bird")
    public String createBird(@RequestParam String name,
                             @RequestParam(required = false, defaultValue = "false") boolean canFly,
                             @RequestParam int weight) {
        Bird bird = new Bird(BirdService.getBirds().size(), name, canFly, weight);
        BirdService.getBirds().add(bird);
        return "redirect:/";
    }

    @GetMapping("/bird-details/{bird}")
    public String showDetails(@PathVariable("bird") Integer birdOrder, Model model) {
        model.addAttribute("bird", BirdService.getBirds().get(birdOrder));
        return "bird-details";
    }
}
