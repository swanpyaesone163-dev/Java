import java.util.*;

import javax.swing.plaf.synth.Region;

public class Civilization {

    public interface Citizens {
        void work();
        void relax();
        void say();
        void reflect();
    }

    public static class Regions{
        String regionName;
        double difficulty;
        double foodModifier;
        double woodModifier;
        double stoneModifier;
        double metalModifier;
        double populationModifier;

        Regions(String name, double diff, double foodMod, double woodMod, double stoneMod, double metalMod, double populationMod){
            regionName = name;
            difficulty = diff;
            foodModifier = foodMod;
            woodModifier = woodMod;
            stoneModifier = stoneMod;
            metalModifier = metalMod;
            populationModifier = populationMod;
        }
        Regions(){
            regionName = "";
            difficulty = 0;
            foodModifier = 0;
            woodModifier = 0;
            stoneModifier = 0;
            metalModifier = 0;
            populationModifier = 0;
        }
    }

    public static class CivState{
        String name;
        String region;
        double food;
        double wood;
        double stone;
        double metal;
        double population;

        CivState(String name, String region){
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

        Map<Integer, String> region = new HashMap<>();

        region.put(1, "Plains");
        region.put(2, "Hills");
        region.put(3, "Delta");
        region.put(4, "Steppes");
        region.put(5, "Artic");
        region.put(6, "Jungle");

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
        for (Map.Entry mapElement : region.entrySet()) {
            String thisRegion = (String)mapElement.getValue();
            int thisKey = (int)mapElement.getKey();

            TerminalFormatter.leftAligned(thisKey + ") " + thisRegion);
        }
        TerminalFormatter.printSmallLine();

        Regions SelectedRegion = new Regions();

        final int SELECTED_REGION_KEY = sc.nextInt();
        switch (SELECTED_REGION_KEY) {
            case 1:
                SelectedRegion.difficulty = 0.5;
                SelectedRegion.foodModifier = 1;
                SelectedRegion.woodModifier = 1;
                SelectedRegion.stoneModifier = 0.5;
                SelectedRegion.metalModifier = 0.3;
                SelectedRegion.populationModifier = 1;
                break;
            case 2:
                SelectedRegion.difficulty = 0.7;
                SelectedRegion.foodModifier = 0.7;
                SelectedRegion.woodModifier = 1;
                SelectedRegion.stoneModifier = 0.7;
                SelectedRegion.metalModifier = 0.4;
                SelectedRegion.populationModifier = 0.8;
                break;
            case 3:
                SelectedRegion.difficulty = 0.7;
                SelectedRegion.foodModifier = 1.2;
                SelectedRegion.woodModifier = 1;
                SelectedRegion.stoneModifier = 0.4;
                SelectedRegion.metalModifier = 0.25;
                SelectedRegion.populationModifier = 1.2;
                break;
            case 4:
                SelectedRegion.difficulty = 0.7;
                SelectedRegion.foodModifier = 0.8;
                SelectedRegion.woodModifier = 0.7;
                SelectedRegion.stoneModifier = 0.5;
                SelectedRegion.metalModifier = 0.3;
                SelectedRegion.populationModifier = 0.7;
                break;
            case 5:
                SelectedRegion.difficulty = 0.8;
                SelectedRegion.foodModifier = 0.6;
                SelectedRegion.woodModifier = 0.7;
                SelectedRegion.stoneModifier = 0.5;
                SelectedRegion.metalModifier = 0.3;
                SelectedRegion.populationModifier = 0.5;
                break;
            case 6:
                SelectedRegion.difficulty = 1;
                SelectedRegion.foodModifier = 1;
                SelectedRegion.woodModifier = 1;
                SelectedRegion.stoneModifier = 0.5;
                SelectedRegion.metalModifier = 0.3;
                SelectedRegion.populationModifier = 0.8;
                break;
        }

        final String SELECTED_REGION = region.get(SELECTED_REGION_KEY);
        System.out.print("\033[1A");
        System.out.println(CIVNAME + " is founded in the " + SELECTED_REGION + ".");

        CivState civilization = new CivState(CIVNAME, SELECTED_REGION);
        TerminalFormatter.civStats(civilization);
        sc.close();

    }
}
