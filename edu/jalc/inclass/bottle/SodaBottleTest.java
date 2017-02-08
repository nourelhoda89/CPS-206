package edu.jalc.inclass.bottle;
//To run the tests, you need the enable assertions flag, so it should be
//java -ea edu.jalc.inclass.bottle.SodaBottleTest
public class SodaBottleTest {

	public void testGetCapacity(){
		System.out.println("Testing SodaBottle::getCapacity");
		SodaBottle sodaBottle = new SodaBottle();
		assert(sodaBottle.getCapacity() == 20.0);
	}

	public static void main(String... args){
		SodaBottleTest sodaBottleTest = new SodaBottleTest();
		sodaBottleTest.testGetCapacity();

		System.out.println("All SodaBottle Tests passed");
	}
}
