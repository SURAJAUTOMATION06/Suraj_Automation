package org.example;

public class FunctionOverloading {  /* Function Overloading means the method having the Same name with the different Arguments
                                       or different datatypes and it is ok if you creates the same kind of method in same class and also
                                        call it under the psvm with the value of different argument*/
    public static void main(String[] args) {
        FunctionOverloading FunctionOverloadingObject =  new FunctionOverloading();
        FunctionOverloadingObject.Getdata(10);
        FunctionOverloadingObject.Getdata(20,30);
        FunctionOverloadingObject.Getdata("suraj");
    }
    public void Getdata(int a){
        System.out.println(a);
    }
    public void Getdata(int a, int b ){
        System.out.println(a);
        System.out.println(b);
    }

    public void Getdata(String Stringname){
        System.out.println(Stringname);
    }

}
