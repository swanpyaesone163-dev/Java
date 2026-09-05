// interface is a collection of abstract methods
// here, "abstract" measn it has no body (or) the implementation is not defined

public interface A {
    void display();
    void print();      // all abstract methods in an interface are abstract by default
}

// there must be at least one class which uses this interface
// it is only useful when another class is making use (or is implementing) the interface

public class B implements A{ // class B must implement all of the abstract methods of A
    int value;
    
    display(){
        System.out.println(value);
    }

    print(String x){
        System.out.println(x);
    }
}