interface Student{
    void Display_Grade();
    void Attendance();
}

class PG_Students implements Student{

    public void Display_Grade() {
        System.out.println("PG Grade: A");
    }

    public void Attendance() {
        System.out.println("PG Attendance: 90%");
    }
}

class UG_Students implements Student{

    public void Display_Grade() {
        System.out.println("UG Grade: B");
    }

    public void Attendance() {
        System.out.println("UG Attendance: 85%");
    }
}

public class Experiment{

    public static void main(String[] args) {

        PG_Students pg = new PG_Students();
        UG_Students ug = new UG_Students();

        pg.Display_Grade();
        pg.Attendance();

        ug.Display_Grade();
        ug.Attendance();
    }
}
