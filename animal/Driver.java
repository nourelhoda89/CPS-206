package exercises.polymorphism.animal;

import exercises.polymorphism.animal.Cat;
import exercises.polymorphism.animal.Dog;
import java.util.*;


class Driver{

   public static void main (String...args){
   
      ArrayList<Animal> animals = new ArrayList<>();
      animals.add(new Cat("meow","purr","growl"));
      animals.add (new Dog("bark","growl","whimper"));
      animals.add (new Lion ("roar"));
      
      for (Animal animal: animals){
         animalSays(animal);
       }      
   }
   
   public static void animalSays(Animal animal){
      System.out.println(animal);
   }

}