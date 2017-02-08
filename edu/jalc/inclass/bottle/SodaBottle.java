package edu.jalc.inclass.bottle;
////not specified then its package private only the package can access
public class SodaBottle {

	private final double capacity = 20;
	//this method allow SodaBottleApp to access capacity
	public double getCapacity(){
		return capacity;
	}
}
