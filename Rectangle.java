class Rectangles{
    double width, length, area;
    String color;

    Rectangles(){
        this.width = 0;
        this.length = 0;
        this.color = "NULL";
        this.area = width * length;
    }

    Rectangles(double width, double length, String color){
        this.width = width;
        this.length = length;
        this.color = color;
        this.area = width * length;
    }

    void findArea(){
        area = length * width; 
    }

    void display(){
        System.out.println("Rectangle with width " + width + ", length " + length + ", and of " + color + " color!");
    }
}

public class Rectangle{
    public static void main(String[] args) {
        Rectangles r1 = new Rectangles(4, 1, "red");
        r1.display();

        Rectangles r2 = new Rectangles(2.0, 2.0, "red");
        r2.display();

        if(r1.area == r2.area && r1.color.equals(r2.color)){
            System.out.println("Matching Rectangles!");
        }
        else{
            System.out.println("Non-matching Rectangles..");
        }
    }
}
