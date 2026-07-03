package org.example;


public class TrafficlightsImpl implements Trafficlights { // Can implement one or more Interface in it
    public static void main(String[] args) {
        Trafficlights Trafficobject = new TrafficlightsImpl(); //The Object based on the Interface
        Trafficobject.GreenGo();
        Trafficobject.RedStob();
        Trafficobject.YellowSlow();

        TrafficlightsImpl TrafficlightIndia = new TrafficlightsImpl(); //Create the new object for the Traffic light
        TrafficlightIndia.Zebracrossing();
    }
    @Override
    public void GreenGo() {
        System.out.println("GreenGo Implementation");
    }

    @Override
    public void RedStob() {
        System.out.println("RedStop Implementation");
    }

    @Override
    public void YellowSlow() {
        System.out.println("YellowSlow Implementation");
    }
    public  void Zebracrossing(){
        System.out.println("Black and white Implementation");
    }
}
