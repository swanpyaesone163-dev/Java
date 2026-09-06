public class Print{
    public static void println(Object obj){
        System.out.println(obj);
    }
    public static void println(){
        System.out.println();
    }
    public static void print(){
        System.out.print("");
    }
    public static void println(double d){
        System.out.println(String.format("%.2f", d));
    }
    public static void print(double d){
        System.out.print(String.format("%.2f", d));
    }
    public static void print(Object obj){
        System.out.print(obj);
    }
    public static void printf(String format, Object... args){
        System.out.printf(format, args);
    }
}