package exercises.polymorphism.animal;

public class Lion extends Animal {

   String roar;

   private Lion(){
      super(null);
   }

   public Lion(String roar){
      super(roar);
      this.roar = roar;
   }
      
   public String toString (){
      return this.getGrowl();
   }

}
