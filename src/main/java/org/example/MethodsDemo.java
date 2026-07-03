package org.example;

public class MethodsDemo {
    public static void main(String[] args) {
        MethodsDemo md = new MethodsDemo();
        String name = md.getdata();
        System.out.println(md.getdata());
        MethodsDemo2 md2 = new MethodsDemo2();
        String name2 = md2.getuserdata();
        System.out.println(md2.getuserdata());
        getdata2();

    }
    public  String getdata()
    {
        System.out.println("HELLO WORLD");
        return "suraj pawar";
    }
    public  static String getdata2()
    {
        System.out.println("HELLO WORLD");
        return "suraj pawar";
    }

}
