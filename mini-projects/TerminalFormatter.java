import java.util.*;

public class TerminalFormatter{
    
    static final int TERMINAL_LENGTH = 75;

    public static void printLine(){
        for(int i = 0; i < TERMINAL_LENGTH; i++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void printSmallLine(){
        for(int i = 0; i < TERMINAL_LENGTH; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void centered(String str){
        int space_left = TERMINAL_LENGTH - str.length();
        System.out.print("|");

        int count;
        for(count = 2; count < (space_left/2); count++){
            System.out.print(" ");
        }
        System.out.print(str);
        count += str.length();
        for(count = count; count < TERMINAL_LENGTH; count++){
            System.out.print(" ");
        }
        System.out.print("|");

        System.out.println();
    }

    public static void leftAligned(String str){
        System.out.print("| ");
        int count = 2;
        System.out.print(str);

        count += str.length();

        for(count = count; count < TERMINAL_LENGTH - 1; count++){
            System.out.print(" ");
        }
        System.out.print("|");

        System.out.println();
    }

    public static void smallBordered(String str){
        printSmallLine();
        centered(str);
        printSmallLine();
    }

    public static void Bordered(String str){
        printLine();
        centered(str);
        printLine();
    }

    public static void civStats(Civilization.CivState obj){
        printLine();
        centered(obj.name);
        centered("Region: " + obj.region);
        printLine();
        leftAligned("Population: " + obj.population);
        leftAligned("      Food: " + obj.food);
        leftAligned("      Wood: " + obj.wood);
        leftAligned("     Stone: " + obj.stone);
        leftAligned("     Metal: " + obj.metal);
        printLine();
    }
}