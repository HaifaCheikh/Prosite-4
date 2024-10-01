package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class main {
    public static void main(String[] args) {
        Animal lion = new Animal("Felidae", "Lion", 8, true);
        Animal elephant = new Animal("Elephantidae", "Elephant", 15, true);
        Animal crocodile = new Animal("Crocodylidae", "Crocodile", 12, false);

        Zoo zoo1 = new Zoo("Safari Zoo", "Paris");
        Zoo zoo2 = new Zoo("Rainforest Zoo", "London");

        zoo1.addAnimal(lion);
        zoo1.addAnimal(elephant);
        zoo1.addAnimal(crocodile);

        zoo2.addAnimal(lion); // Adding same animal in different zoo

        System.out.println("Display animals in Zoo 1:");
        zoo1.displayAnimals();

        System.out.println("Display animals in Zoo 2:");
        zoo2.displayAnimals();

        System.out.println("\nSearching for Elephant in Zoo 1:");
        int index = zoo1.searchAnimal(elephant);
        System.out.println("Found at index: " + index);

        System.out.println("\nRemoving Crocodile from Zoo 1:");
        zoo1.removeAnimal(crocodile);
        zoo1.displayAnimals();

        System.out.println("\nComparing Zoo 1 and Zoo 2:");
        Zoo largerZoo = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("The larger zoo is: " + largerZoo.getName());
    }
}

