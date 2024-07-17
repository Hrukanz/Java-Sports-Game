package sportstournament.core;

public class SnackGen {
    private String[] names1 = {"Chicken", "Beef", "Vanilla", "Seafood", "BBQ", "Salted", "Chocolate", "Tropical", "Vege"};
    private String[] names2 = {"Chips", "Wafers", "Brownie", "Pizza", "Cookies", "Candy", "Crackers", "Popcorn", "Icecream"};

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
        int[] numbers = {3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7};
        int rnd = 0 + (int)(Math.random() * (((numbers.length - 1) - 0) + 1));
        return numbers[rnd];
    }
    
    /**
     * generates speed down factor of drink
     * @return speed down factor
     */
    public int genSpeed() {
        int[] numbers = {-1, -1, -1, -1, -2, -2, -2, -2, -3, -3, -3, -3, -4};
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
     * Generates a snack item
     * @param value extra value modifier for special conditions
     * @return generated snack
     */
    public Snack genSnack(int value) {
        int stamina = genStamina();
        Snack genSnack = new Snack(genName(), genVal(stamina)+value, stamina+value, genSpeed()+value, "Snack", "Better stamina regen but slower");
        return genSnack;
    }
}
