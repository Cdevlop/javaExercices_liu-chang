package fr.liu.myApi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.liu.myApi.model.Animal;
import fr.liu.myApi.service.AnimalService;

@RestController
public class AnimalController {
    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
    
    @GetMapping("/animal")
    public Animal getAnimal(@RequestParam int id) {
        Animal animal = animalService.getAnimal(id);
        return animal;
    }

    @PostMapping("/animal")
    public Animal createAnimal(@RequestBody AnimalRequest body) {
        Animal animal = animalService.createAnimal(body.getName(), body.getType(), body.getWeight());
        return animal;
    }

    @PutMapping("/animal")
    public Animal updateAnimal(@RequestParam int id, @RequestBody AnimalRequest body) {
        Animal animal = animalService.updateAnimal(id, body.getName(), body.getType(), body.getWeight());
        return animal;
    }

    @DeleteMapping("/animal")
    public Animal deleAnimal(@RequestParam int id) {
        Animal animal = animalService.deleteAnimal(id);
        return animal;
    }

    @GetMapping("/animals")
    public Animal getAnimals() {
        Animal animal = animalService.getAnimals();
        return animal;
    }




}
