package org.example;

public class Constructordemo {
    /* Constructor:- A constructor Execute a block of code when the object is created and will not return any value a
    and the name of the Constructor should always same as class name */


    //This is the default constructor
   public  Constructordemo(){
        System.out.println("Constructor is called");
    }

    //Parameterised constructor
    public Constructordemo(int a, int b){
        System.out.println("Parameterised constructor is called");
    }

    public void getdata(){ //Here the public = Access Modifier , void = return type of the Method, Getdata = Method Name
        System.out.println("Method is called");
    }

    public static void main (String[] args) {
       // In the constructor it should have any return value so void is the Return value
        //Compiler will call the implicit constructor if you have not defined the constructor
        //When ever the constructor is called the block of code is Executed
        Constructordemo pc = new Constructordemo(10 , 20);
        Constructordemo cd = new Constructordemo();
   }
}
