public class Dog{
private String name;
public Dog(String name){
  this.name=name;
}
//overridding the equals method
/*public boolean equals(Object other){
  Dog dog =(Dog)other;
  return this.name.equals(dog.name);//&& super.equals(other);
}*/
public String toString(){
  return "my name is " + this.name;
}
public int hashCode(){
  return super.hashCode()%32;
}
}
