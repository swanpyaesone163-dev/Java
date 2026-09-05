import java.util.HashMap;
import java.util.Map;

import Survival.Food;


/**
 * actor
 */
interface actor {
    void sustain(Food food, int count);
    void move();
    void ponder();
    void emote();
    void act();
}

class player implements actor{
    private int hunger = 100;
    private int thirst = 100;

    final int max_hunger = 100;
    final int max_thirst = 100;

    @override
    int sustain(Food food, int count){
        int food_left = count;

        for(int i = 0; i < count; i++){
            food_left -= 1;
            if(hunger + food.saturation() > max_hunger){
                hunger = 100;
                break;
            }
            else{
                hunger += food.saturation();
            }
        }
        return food_left;
    }

    public void move() {}
    public void ponder() {}
    public void emote() {}
    public void act() {}
}


public class Survival{
    public record Food(String name, int saturation){}

    static Map<Integer, Food> foods = new HashMap<>();

    static String[] locations = {"Campsite", "Forest Trail", "Deep Forest", "Forested Hill", "Forest Clearing", "Dirt Path", "LakeSide"}; 
    public static void main(String[] args) {
        foods.put(1, new Food("Apple", 10));
        foods.put(2, new Food("Bread", 25));

        Food apple = foods.get(1);
        Food bread = foods.get(2);
    }
}
