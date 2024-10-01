package tn.esprit.gestionzoo.entities;

public class Zoo {
    private static final int MAX_CAGES = 25;
    private Animal[] animals;
    private String name;
    private String city;
    private int animalCount;

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.animals = new Animal[MAX_CAGES];
        this.animalCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("The name of the zoo cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public String getCity() {
        return city;
    }

    public boolean isZooFull() {
        return animalCount >= MAX_CAGES;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Cannot add more animals, the zoo is full.");
            return false;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                System.out.println("This animal is already in the zoo.");
                return false;
            }
        }
        animals[animalCount++] = animal;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                animals[i] = animals[animalCount - 1]; // Replace with the last animal
                animals[animalCount - 1] = null;
                animalCount--;
                return true;
            }
        }
        return false;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public void displayAnimals() {
        if (animalCount == 0) {
            System.out.println("No animals in the zoo.");
        } else {
            for (int i = 0; i < animalCount; i++) {
                System.out.println(animals[i]);
            }
        }
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return z1.animalCount > z2.animalCount ? z1 : z2;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", animalCount=" + animalCount +
                '}';
    }
}

