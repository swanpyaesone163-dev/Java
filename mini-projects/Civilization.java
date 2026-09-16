import java.util.*;
import javax.swing.plaf.synth.Region;

public class Civilization {

    public interface Citizens {
        void work();
        void relax();
        void say();
        void reflect();
    }

    public static class CivRegions{
        String regionName;
        double difficulty;
        double foodModifier;
        double woodModifier;
        double stoneModifier;
        double metalModifier;
        double populationModifier;

        CivRegions(String regionName, double difficulty, double foodModifier, double woodModifier, double stoneModifier, double metalModifier, double populationModifier){
            this.regionName = regionName;
            this.difficulty = difficulty;
            this.foodModifier = foodModifier;
            this.woodModifier = woodModifier;
            this.stoneModifier = stoneModifier;
            this.metalModifier = metalModifier;
            this.populationModifier = populationModifier;
        }
        CivRegions(){
            regionName = "";
            difficulty = 0;
            foodModifier = 0;
            woodModifier = 0;
            stoneModifier = 0;
            metalModifier = 0;
            populationModifier = 0;
        }
    }

    public static class PlayerCiv{
        String name;
        String region;
        double food;
        double wood;
        double stone;
        double metal;
        double population;

        PlayerCiv(String name, String region){
            this.name = name;
            this.region = region;
            this.food = 0; 
            this.wood = 0;
            this.stone = 0;
            this.metal = 0;
            this.population = 10;
        }
    }

    public static void main(String[] args) {
        TerminalFormatter.Bordered("WELCOME TO CIV TERMINAL!");
        
        Map<Integer, CivRegions> regionData = new HashMap<>();
        regionData.put(1, new CivRegions("Plains", 0.5, 1, 1, 0.5, 0.3, 1));
        regionData.put(2, new CivRegions("Hills", 0.7, 0.7, 1, 0.7, 0.4, 0.8));
        regionData.put(3, new CivRegions("Delta", 0.7, 1.2, 1, 0.4, 0.25, 1.2));
        regionData.put(4, new CivRegions("Steppes", 0.7, 0.8, 0.7, 0.5, 0.3, 0.7));
        regionData.put(5, new CivRegions("Arctic", 0.8, 0.6, 0.7, 0.5, 0.3, 0.5));
        regionData.put(6, new CivRegions("Jungle", 1, 1, 1, 0.5, 0.3, 0.8));

        TerminalFormatter.leftAligned("The world is in its antiquities; tribes roam the earth.");
        TerminalFormatter.leftAligned("In one corner of the earth, people started farming.");
        TerminalFormatter.leftAligned("With time, they got better at it.");
        TerminalFormatter.leftAligned("Then they got good enough to settle in one place.");
        TerminalFormatter.leftAligned("Given a few centuries, agriculture would yield a surplus");
        TerminalFormatter.leftAligned("The surplus give time for people to specialize in a trade.");
        TerminalFormatter.leftAligned("There came occupations, business, money, laws, power.");
        TerminalFormatter.leftAligned("Now, the stage is set, and the world is now up for grabs.");
        
        TerminalFormatter.smallBordered("How shall the world call this civlization?");

        Scanner sc = new Scanner(System.in);
        final String CIVNAME = sc.nextLine();

        System.out.print("\033[1A");
        System.out.println("Your civilization is called " + CIVNAME + "!");

        TerminalFormatter.smallBordered("What shall we call your citizens?");

        final String CITIZENS_NAME = sc.nextLine();
        System.out.print("\033[1A");
        System.out.println("Your citizens shall be called " + CITIZENS_NAME + "!");

        TerminalFormatter.smallBordered("Choose the climate of your civilization (1~6)");
        for(Map.Entry<Integer, CivRegions> entry: regionData.entrySet()){
            TerminalFormatter.leftAligned(entry.getKey() + ") " + entry.getValue().regionName);
        }

        TerminalFormatter.printSmallLine();

        final int SELECTED_REGION_KEY = sc.nextInt();

        CivRegions selectedRegion = regionData.getOrDefault(SELECTED_REGION_KEY, new CivRegions());
        
        System.out.print("\033[1A");
        System.out.println(CIVNAME + " is founded in the " + selectedRegion.regionName + ".");

        PlayerCiv civilization = new PlayerCiv(CIVNAME, selectedRegion.regionName);
        TerminalFormatter.civStats(civilization);

        TerminalFormatter.PlayerMenu();





        sc.close();

    }
}
