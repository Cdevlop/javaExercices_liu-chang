package fr.liu.myApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.liu.myApi.model.Animal;

@Service
public class AnimalService {

    private ArrayList<Animal> animals;

    public AnimalService() {
        this.animals = new ArrayList<Animal>();

        Animal a1 = new Animal(0, "saumon", "poisson", 2);
        Animal a2 = new Animal(1, "aigle", "oiseau", 2);

        this.animals.add(a1);
        this.animals.add(a2);
    }

    public Animal getAnimal(int id) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    public Animal createAnimal(String name, String type, int weight) {
        Animal animal = new Animal(this.animals.size(), name, type, weight);
        this.animals.add(animal);
        return animal;
    }

    public Animal updateAnimal(int id, String name, String type, int weight) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                animal.setName(name);
                animal.setType(type);
                animal.setWeight(weight);
                return animal;
            }
        }
        return null;
    }

    public Animal deleteAnimal(int id) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                int index = this.animals.indexOf(animal);
                return this.animals.remove(index);
            }
        }
        return null;
    }

}
