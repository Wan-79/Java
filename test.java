public class Main {
    // classes and objects
    int x = 5;static void myMethod() {
        Main myObj = new Main();
        Main myObj2 = new Main();
        System.out.println(myObj.x);
        myObj2.x =  23;
        System.out.println(myObj2.x);
    }


    public static void main(String[] args) {
//        myMethod();
        // Inheritance and polymorphism
        First Object1 = new First();
        First Object2 = new Second();
        First Object3 = new Third();
        Object1.num();
        Object2.num();
        Object3.num();
        // Encapsulation
        Item Object4 = new Item();
        Object4.setItem("Table");
        System.out.println(Object4.getItem());

        // Abstraction
        Piano Object5 = new Piano();
        Object5.note();
        Object5.silence();

        // Interface
        Hearts myCard = new Hearts();
        myCard.take();
        myCard.pass();



    }

// OOPs

}

// Inheritance lets you use methods and objects from Class main
// Polymorphism lets you have multiple classes inherit from one, and make one method do different tasks
class First {
    public void num() {
        int y = 1;
        System.out.println(y);
    }
}
class Second extends First {
    public void num() {
        int y = 2;
        System.out.println(y);
    }
}

class Third extends First {
    public void num() {
        int y = 3;
        System.out.println(y);
    }
}

// Private is used so the variable can only be accessed within the class, however you can access them using
// get and set method means you can access these variables

class Item {
    private String item;
    public String getItem() {
        return item;
    }
    public void setItem(String newItem) {
        this.item = newItem;
    }
}

// Abstract classes, hides details from the user only showing them essential information
// an abstract class cannot be used to create objects

abstract class Instrument {
    public abstract void note();

    public void silence(){
        System.out.println("........");
    }
}
class Piano extends Instrument {
    public void note() {
        System.out.println("C#");
    }
}

// an interface is a completely abstract class, where the interface methods have no body
// and the body is defined by the implement class

interface Cards {
    public void take();
    public void pass();
}

class Hearts implements Cards {
    public void take() {
        System.out.println("4 of Hearts");
    }

    public void pass() {
        System.out.println("No card");
    }
}

// to import packages, use import and then the package name at the top
// to create your own package you can use "package name;"  at the start of the code

