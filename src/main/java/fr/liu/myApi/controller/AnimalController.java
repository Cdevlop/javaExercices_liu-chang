package fr.liu.myApi.controller;

import java.net.URI;
import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
    @CrossOrigin
    @GetMapping("/animal")
    public ResponseEntity<Animal> getAnimal(@RequestParam int id) {
        Animal animal = animalService.getAnimal(id);
        if (animal != null) {
            return ResponseEntity.ok(animal);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/animal")
    public ResponseEntity<Animal> createAnimal(@RequestBody AnimalRequest body) {
        String name = body.getName();
        String type = body.getType();
        int weight = body.getWeight();
        Animal animal = animalService.createAnimal(name, type, weight);

        if (animal != null) {
            return ResponseEntity.ok(animal);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/animal")
    public ResponseEntity<Animal> updateAnimal(@RequestParam int id, @RequestBody AnimalRequest body) {
        Animal animal = animalService.updateAnimal(id, body.getName(), body.getType(), body.getWeight());

        if (animal != null) {
            return ResponseEntity.ok(animal);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/animal")
    public ResponseEntity<Animal> deleleAnimal(@RequestParam int id) {
        Animal animal = animalService.deleteAnimal(id);

        if (animal != null) {
            return ResponseEntity.ok(animal);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/animal")
    public ResponseEntity<ArrayList<Animal>> getAnimals() {
        ArrayList<Animal> animals = animalService.getAnimals();

        if (animals != null) {
            return ResponseEntity.ok(animals);
        }
        return ResponseEntity.notFound().build();
    }
}
