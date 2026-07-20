package org.example;

public class superkeywordchild extends superkeywordparent{

    String name = "Matrix comsec";
    public void getStringdata(){
        super.getdata();
        System.out.println(name);
        System.out.println(super.name);
    }
    public void getdata(){
        super.getdata();
    }
    public static void main(String[] args) {
        superkeywordchild sc = new superkeywordchild();
        sc.getStringdata();
        sc.getdata();
    }
}
//The super keyword in Java is used to refer to the parent class (superclass) object from a child class.
/*The super keyword refers to the immediate parent class object and is used to:

1)Access parent class variables.
2)Call parent class methods.
3)Invoke parent class constructors.*/