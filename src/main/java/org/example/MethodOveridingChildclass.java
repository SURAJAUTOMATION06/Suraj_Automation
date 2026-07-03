package org.example;

public class MethodOveridingChildclass extends MethodOveriding {
    public void GreenGo() {
        System.out.println("GreenGo Implementation");
    }
    public void RedStob() {
        System.out.println("RedStop Implementation");
    }
    public void YellowSlow() {
        System.out.println("YellowSlow Implementation");
    }
    public  void Zebracrossing(){
        System.out.println("Black and white Implementation");
    }

    public static void main(String[] args) {
        MethodOveridingChildclass MethodOveridingChildclassObject = new MethodOveridingChildclass();
        MethodOveridingChildclassObject.GreenGo();
        MethodOveridingChildclassObject.RedStob();
        MethodOveridingChildclassObject.YellowSlow();
        MethodOveridingChildclassObject.Zebracrossing();
        System.out.println();
        MethodOveriding MethodOveridingObject = new MethodOveriding();
        MethodOveridingObject.GreenGo();
        MethodOveridingObject.RedStob();
        MethodOveridingObject.YellowSlow();
        MethodOveridingObject.Zebracrossing();
    }
}
