/*interface Students {
    void Display_Grade();
    void AttendanceStatus();
    void displayInfo();
    void isExcellent();
}

class PG_Student implements Students{
    String name;
    int age;
    double cgpa;
    double attendance;

    PG_Student(String name, int age, double cgpa, double attendance){
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
        if((0 <= attendance) && (attendance <= 1)){
            this.attendance = attendance;
        }
        else{
            this.attendance = 0;
        }
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Attendance: " + (attendance * 100) + "%");
    }

    public void Display_Grade(){
        System.out.println("PG CGPA: " + cgpa);
    }

    public void AttendanceStatus(){
        System.out.println("PG Attendance Required: 90%");
        if(attendance < 0.9){
            System.out.println("Attendance requirement not met!");
        }
        else{
            System.out.println("Attendance requirement met!");
        }
    }

    public void isExcellent(){
        if(cgpa >= 8.0) System.out.println("Excellent Student!");
        else if(cgpa >= 6.0 && cgpa < 8.0) System.out.println("Keep Improving!");
        else{ System.out.println("Lock In!");}
    }
}

class UG_Student implements Students{
    String name;
    int age;
    double cgpa;
    double attendance;

    UG_Student(String name, int age, double cgpa, double attendance){
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
        if((attendance >= 0) && (attendance <= 1)){
            this.attendance = attendance;
        }
        else{
            this.attendance = 0;
        }
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Attendance: " + (attendance * 100) + "%");
    }

    public void Display_Grade(){
        System.out.println("UG CGPA: " + cgpa);
    }

    public void AttendanceStatus(){
        System.out.println("UG Attendance Required: 75%");
        if(attendance < 0.75){
            System.out.println("Attendance requirement not met!");
        }
        else{
            System.out.println("Attendance requirement met!");
        }
    }

    public void isExcellent(){
        if(cgpa >= 7.5) System.out.println("Excellent Student!");
        else if(cgpa >= 6.0 && cgpa < 7.5) System.out.println("Keep Improving!");
        else{ System.out.println("Lock In!");}
    }
}

public class Student{
    public static void main(String[] args){

    PG_Student student1 = new PG_Student("Swan", 18, 8.83, 0.80);
    UG_Student student2 = new UG_Student("John", 22, 7.9, 0.80);
    UG_Student student3 = new UG_Student("Michelle", 20, 5.8, 0.70);

    student1.displayInfo();
    student1.isExcellent();
    student1.AttendanceStatus();
System.out.println();
    student2.displayInfo();
    student2.isExcellent();
    student2.AttendanceStatus();
System.out.println();
    student3.displayInfo();
    student3.isExcellent();
    student3.AttendanceStatus();
    }
}
*/

interface Students {
    void displayGrade();
    void attendanceStatus();
    void displayInfo();
    void checkPerformance();
}

abstract class AbstractStudent implements Students {
    private final String name;
    private final int age;
    private final double cgpa;
    private final double attendance;

    protected AbstractStudent(String name, int age, double cgpa, double attendance) {
        if (attendance < 0.0 || attendance > 1.0) {
            throw new IllegalArgumentException(
                "Attendance must be between 0 and 1, got: " + attendance
            );
        }
        if (cgpa < 0.0 || cgpa > 10.0) {
            throw new IllegalArgumentException(
                "CGPA must be between 0 and 10, got: " + cgpa
            );
        }
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
        this.attendance = attendance;
    }

    protected String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected double getCgpa() {
        return cgpa;
    }

    protected double getAttendance() {
        return attendance;
    }

    protected abstract double getRequiredAttendance();
    protected abstract double getExcellentThreshold();
    protected abstract double getImprovingThreshold();
    protected abstract String getLevelLabel();

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Attendance: " + (attendance * 100) + "%");
    }

    @Override
    public void displayGrade() {
        System.out.println(getLevelLabel() + " CGPA: " + cgpa);
    }

    @Override
    public void attendanceStatus() {
        double required = getRequiredAttendance();
        System.out.println(getLevelLabel() + " Attendance Required: " + (required * 100) + "%");
        if (attendance < required) {
            System.out.println("Attendance requirement not met!");
        } else {
            System.out.println("Attendance requirement met!");
        }
    }

    @Override
    public void checkPerformance() {
        if (cgpa >= getExcellentThreshold()) {
            System.out.println("Excellent Student!");
        } else if (cgpa >= getImprovingThreshold()) {
            System.out.println("Keep Improving!");
        } else {
            System.out.println("Lock In!");
        }
    }
}

class PGStudent extends AbstractStudent {
    private static final double REQUIRED_ATTENDANCE = 0.90;
    private static final double EXCELLENT_THRESHOLD = 8.0;
    private static final double IMPROVING_THRESHOLD = 6.0;

    PGStudent(String name, int age, double cgpa, double attendance) {
        super(name, age, cgpa, attendance);
    }

    @Override
    protected double getRequiredAttendance() {
        return REQUIRED_ATTENDANCE;
    }

    @Override
    protected double getExcellentThreshold() {
        return EXCELLENT_THRESHOLD;
    }

    @Override
    protected double getImprovingThreshold() {
        return IMPROVING_THRESHOLD;
    }

    @Override
    protected String getLevelLabel() {
        return "PG";
    }
}

class UGStudent extends AbstractStudent {
    private static final double REQUIRED_ATTENDANCE = 0.75;
    private static final double EXCELLENT_THRESHOLD = 7.5;
    private static final double IMPROVING_THRESHOLD = 6.0;

    UGStudent(String name, int age, double cgpa, double attendance) {
        super(name, age, cgpa, attendance);
    }

    @Override
    protected double getRequiredAttendance() {
        return REQUIRED_ATTENDANCE;
    }

    @Override
    protected double getExcellentThreshold() {
        return EXCELLENT_THRESHOLD;
    }

    @Override
    protected double getImprovingThreshold() {
        return IMPROVING_THRESHOLD;
    }

    @Override
    protected String getLevelLabel() {
        return "UG";
    }
}

public class Student {
    public static void main(String[] args) {
        try {
            PGStudent student1 = new PGStudent("Swan", 18, 8.83, 0.80);
            UGStudent student2 = new UGStudent("John", 22, 7.9, 0.80);
            UGStudent student3 = new UGStudent("Michelle", 20, 5.8, 0.70);

            runReport(student1);
            runReport(student2);
            runReport(student3);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create student record: " + e.getMessage());
        }
    }

    private static void runReport(Students student) {
        student.displayInfo();
        student.checkPerformance();
        student.attendanceStatus();
        System.out.println();
    }
}
