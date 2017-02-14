public class Driver {
  public static void main(String... args){
    Dog fido =new Dog("fido");
    Dog spot =new Dog("spot");
    System.out.println(fido.equals(spot));
    System.out.println(fido);
    System.out.println(fido.hashCode()%16);

}
}
