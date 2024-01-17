import java.util.*;
import java.util.Arrays;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import java.util.stream.*;
import java.util.StringJoiner;

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

        // Try and Catch
        exceptions.trycatch();

        collections.maps();

        // java 8
        java8.optional();
        java8.lambda_expressions();
        java8.method_references();
        java8.datetime();
        java8.encode_decode();
        java8.array_sorting();
        MyClass x = new MyClass();
        x.normal_method();
        x.default_method();
        new_interface.static_method();
        test.cubing(3);

        stream_api.example();
        stringjoin.join_strings();

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


// Try and catch method for Exception handling

class exceptions {
    public static void trycatch(){
        try {
            int[] numbs = {1,2,3,4};
            System.out.println(numbs[5]);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        // Will always execute finally statement after try and catch
        finally {
            System.out.println("Finished");
        }
    }
}


// Collections and maps
// Creates a dictionary like object which will have a key and a value which when you look up the key you can
// get the associated value

class collections {
    public static void maps(){
        Map<String, Integer> hm
                = new HashMap<String, Integer>();

        hm.put("Bob", 32);
        hm.put("Betty", 24);

        System.out.println(hm.get("Bob"));
    }
}

// Java 8 features: Date time API, Optional class, Lambda expressions, Method reference, Base 64 encode and decode,
// Parallel array sorting, static methods in interface, Functional interfaces, Default methods,
// Stream API,  StringJoiner

class java8 {
    static void datetime(){
        // current datetime
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current datetime: "+ current);
        // formatting the datetime
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String formatedDateTime = current.format(format);

        System.out.println("Datetime in specified format: "+ formatedDateTime);
    }
    // An optional class is an object which may or may not contain a value and allows you to check more easily
    // if there is a value present without getting exceptions
    static void optional(){
        // <String> indicates that the object may contain a string (if it wasn't null)
        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[5]);

        if (checkNull.isPresent()) {
            String word = words[5].toUpperCase();
            System.out.print(word);
        }
        else
            System.out.println("word is null");
    }

    static void lambda_expressions(){
        // given certain parameters applies a block of code (parameter1, parameter2) -> {expression}
        // can also use the keyword Consumer to store a lambda function within a variable
        ArrayList<Integer> x = new ArrayList<>();
        x.add(5);
        x.add(9);
        x.add(8);
        x.add(1);
        Consumer<Integer> stored_lambda = (n) -> {System.out.println(n);};
        x.forEach(stored_lambda);
    }

    // For method reference, it can be used as a shorthand way of writing a lambda method call e.g for the last
    // method
    static void method_references(){
        ArrayList<Integer> x = new ArrayList<>();
        x.add(5);
        x.add(9);
        x.add(8);
        x.add(1);
        x.forEach(System.out::println);
    }

    // Base 64 encode and decode
    // encodes and decodes a string in the form of characters in A-Za-z0-9+/
    static void encode_decode(){
        String sample = "This is a sample string";

        String encoded_sample = Base64.getEncoder().encodeToString(sample.getBytes());
        byte[] actual_bytes = Base64.getDecoder().decode(encoded_sample);
        String decoded_sample = new String(actual_bytes);
        System.out.println("Sample encoded: " + encoded_sample);
        System.out.println("Sample decoded: " + decoded_sample);
    }

    // Parallel array sorting
    //
    static void array_sorting(){
        int[] numbers = {4,2,67,1,6,8,43,14,76,25};
        System.out.println("Unsorted numbers: " + Arrays.toString(numbers));

        Arrays.parallelSort(numbers);
        System.out.println("Sorted number: " + Arrays.toString(numbers));
    }
}

// Static methods in interface
// Static methods in an interface have a body, because of this they can be called without creating
// an instance unlike a regular method within an interface
interface new_interface{
    static void static_method(){
        System.out.println("This is a static method");
    }

    // Default method
    default void default_method(){
        System.out.println("This is a default method");
    }
    void normal_method();
}

class MyClass implements new_interface {
    public void normal_method() {
        System.out.println("This is the normal implementation");
    }

}

// Functional interface
// A functional interface can only have one abstract method, however it can have as many static methods
// as wanted. It can also call lambda expressions as the instance of functional interface

interface cube{
    int calc(int x);
}

class test{
    public static void cubing(int a){
        cube s = (int x) -> x * x * x;

        int ans = s.calc(a);
        System.out.println(ans);
    }
}

// A stream allows multiple operations or methods to be applied to an input without having to store any
// of the intermediate data, before a final terminal operation is applied and outputs a result
// examples of terminal operators, collect, forEach, reduce
class stream_api{
    public static void example(){
        System.out.println("Example of stream API:");
        List<Integer> number = Arrays.asList(2,3,4,5);
        number.stream().map(x->x*x).forEach(System.out::println);
        List<Integer> num_list = number.stream().filter(x->x%3 == 0).collect(Collectors.toList());
        System.out.println(num_list);
    }
}

// Stringjoiner allows you to join multiple strings together easily with a fixed delimiter, prefix and
// suffix

class stringjoin{
    public static void join_strings(){
        StringJoiner sj = new StringJoiner("|", "/", "/");
        sj.add("abc");
        sj.add("def");
        sj.add("ghi");
        System.out.println(sj);
    }
}
