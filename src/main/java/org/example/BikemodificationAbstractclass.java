package org.example;

public class BikemodificationAbstractclass extends Abstractclass {  /* The inheritance is same as Abstract class using the extend keyword where you
                                                                        can call a method of one class to another class*/
    public static void main(String[] args) {
        BikemodificationAbstractclass BikeSpecs = new BikemodificationAbstractclass();
        BikeSpecs.Bikecolor();
        BikeSpecs.BikeEnginecc();
        BikeSpecs.Bikebrakes();
    }

    public  void Bikecolor(){
        System.out.println(Color);
    }
}
