package sportstournament.core;

public class DrinkGen {
    private String[] names1 = {"Blueberry", "Mango", "Vanilla", "Watermelon", "Apple", "Kiwifruit", "Chocolate", "Tropical", "Spinach"};
    private String[] names2 = {"Beer", "Gatorade", "Wine", "Tea", "Vodka", "Rum", "Coffee", "Cider", "Syrup"};

    /**
     * Generates a random value based on stamina amount
     * @param staminaRegen
     * @return
     */
    public int genVal(int stamina) {
        int rnd = 0 + (int)(Math.random() * (((25 + (stamina * 2)) - 0) + 1));
        return rnd;
    }

    /**
     * generates stamina factor of drink
     * @return stamina factor
     */
    public int genStamina() {
        int[] numbers = {2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
        int rnd = 0 + (int)(Math.random() * (((numbers.length - 1) - 0) + 1));
        return numbers[rnd];
    }
    
    /**
     * generates offence up factor of drink
     * @return offence up factor
     */
    public int genOffence() {
        int[] numbers = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5};
        int rnd = 0 + (int)(Math.random() * (((numbers.length - 1) - 0) + 1));
        return numbers[rnd];
    }

    /**
     * Generates a random name based on name banks above
     * @return
     */
    public String genName() {
        int rnd0 = 0 + (int)(Math.random() * (((names1.length - 1) - 0) + 1));
        int rnd1 = 0 + (int)(Math.random() * (((names2.length - 1) - 0) + 1));

        return names1[rnd0] + " " + names2[rnd1];
    }

    /**
     * Generates a drink item
     * @param value extra value modifier for special conditions
     * @return generated drink
     */
    public Drink genDrink(int value) {
        int stamina = genStamina();
        Drink genDrink = new Drink(genName(), genVal(stamina)+value, stamina+value, genOffence()+value, "Drink", "Regen stamina and up offence");
        return genDrink;
    }
}
