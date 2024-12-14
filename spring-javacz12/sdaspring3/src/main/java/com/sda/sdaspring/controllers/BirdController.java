package com.sda.sdaspring.controllers;

import com.sda.sdaspring.models.Bird;
import com.sda.sdaspring.services.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class BirdController {

    private final int PAGE_SIZE = 4;
    private final BirdService birdService;

    @Autowired
    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }

//    @Autowired
//    public BirdController(@Qualifier("birdServiceList")BirdService birdService) {
//        this.birdService = birdService;
//    }

    @GetMapping("/")
    public String getMainPage(Model model,
                              @RequestParam(value = "search", required = false) String search,
                              @RequestParam(value = "sortBy", required = false) String sortBy,
                              @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        model.addAttribute("welcomeString", "Welcome to the Charming Birdhouse");
        if (Objects.nonNull(search)) {
            model.addAttribute("birds", birdService.getBirdsByName(search, page, PAGE_SIZE));
        } else if (Objects.nonNull(sortBy)) {
            model.addAttribute("birds", birdService.findAllSorted(sortBy, page, PAGE_SIZE));
        } else {
            model.addAttribute("birds", birdService.getBirds(page, PAGE_SIZE));
        }
        model.addAttribute("page", page);
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
        Bird bird = new Bird(name, canFly, weight);
        birdService.createBird(bird);
        return "redirect:/";
    }

    @GetMapping("/bird-details/{bird}")
    public String showDetails(@PathVariable("bird") Long birdOrder, Model model) {
        model.addAttribute("bird", birdService.getBirdById(birdOrder));
        return "bird-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteBird(@PathVariable("id") Long birdOrder) {
        birdService.deleteBird(birdOrder);
        return "redirect:/";
    }

    @GetMapping("/increase/{id}")
    public String increaseBirdWeight(@PathVariable("id") Long birdOrder) {
        birdService.updateBird(birdOrder);
        return "redirect:/";
    }

    @GetMapping("/flying-jpql")
    public String findFlyingJPQL(Model model, @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        model.addAttribute("birds", birdService.findFlyingJPQL(page, PAGE_SIZE));
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping("/flying-native")
    public String findFlyingNative(Model model, @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        model.addAttribute("birds", birdService.findFlyingNative(page, PAGE_SIZE));
        model.addAttribute("page", page);
        return "index";
    }
}
