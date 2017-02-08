package edu.jalc.inclass.bottle;
////not specified then its package private only the package can access
public class SodaBottle {

	private double capacity;
	//this method allow SodaBottleApp to access capacity
	public double getCapacity(){
		SetCapacity(20.0);
		return capacity;
	}
		public void SetCapacity(double capacity){
			this.capacity =capacity;
}
