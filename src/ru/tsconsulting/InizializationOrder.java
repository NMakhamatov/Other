package ru.tsconsulting;

// Порядок вызова конструкторов.
class Meal {
    Meal() {
        System.out.println("Meal()"); }
}

class Bread {
    Bread() {
        System.out.println("Bread()"); }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese()"); }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
    static {
        System.out.println("Static block in PortableLunch");
    }
    PortableLunch() {
        System.out.println("PortableLunch()");}
}

 class Sandwich extends PortableLunch {
    private Bread b =new Bread();
    private Cheese c;
     {
         c = new Cheese();
     }
    private Lettuce l = new Lettuce();

    public Sandwich() {
        System.out.println("Sandwich()"); }
    public static void main(String[] args) {
        System.out.println("start main");
        new Bread();
        new Sandwich();
        System.out.println("end main");
    }
    static {
         System.out.println("static Блок в Sandwich");
     }
}