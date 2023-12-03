package com.easdrox.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.easdrox.library.model.Genre;
import com.easdrox.library.model.Publisher;
import com.easdrox.library.services.PublisherService;



@Controller
public class PublisherController {
    private final PublisherService publisherService;
    
    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model model){
        Iterable<Publisher> publishers = publisherService.findAllPublishers();
        model.addAttribute("publishers", publishers);
        model.addAttribute("publisherSelected", publishers);
        return "viewPublishers";
    }

    @PostMapping("/findPublishers")
    public String findPublishers(
        @RequestParam(value = "id", defaultValue = "0") Integer id,
        Model model) {
        Publisher publisher = publisherService.findPublisherById(id);
        model.addAttribute("publishers", publisher);
        Iterable<Publisher> publishers = publisherService.findAllPublishers();
        model.addAttribute("publisherSelected", publishers);
        return "viewPublishers";
    }

    @RequestMapping("/addPublishers")
    public String addPublishers(Model model){
        return "viewSavePublishers";
    }

    @PostMapping("/savePublishers")
    public String savePublishers(@RequestParam String name,
    @RequestParam String description) {
        System.out.println("Nombre: " + name);

        publisherService.savePublisher(new Publisher(name, description));

        return "redirect:/publishers";
    }

    @GetMapping("/editPublishers/{id}")
    public String editPublisher(@PathVariable int id, Model model) {
        
        Publisher publisher = publisherService.findPublisherById(id);
        
        model.addAttribute("publisher", publisher);
        
        return "viewEditPublishers";
    }

    @PostMapping("/editPublishers/{id}")
    public String updatePublisher(@PathVariable int id, @ModelAttribute Publisher updatedPublisher) {
    
        publisherService.savePublisher(updatedPublisher);

        return "redirect:/publishers";
    }


}
