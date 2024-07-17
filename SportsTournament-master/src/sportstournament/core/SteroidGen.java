package sportstournament.core;

public class SteroidGen {
    private String[] names = {"Tren", "SARMs", "Test", "Anavar", "Winstrol", "Deca", "Anadrol"};

    /**
     * Generates a random value based on stamina amount
     * @param stamina
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
        int[] numbers = {10, 12, 14, 15, 16, 18, 19, 20, 21, 12, 23, 24, 24};
        int rnd = 0 + (int)(Math.random() * (((numbers.length - 1) - 0) + 1));
        return numbers[rnd];
    }
    
    /**
     * generates speed up factor of drink
     * @return speed up factor
     */
    public int genSpeed() {
        int[] numbers = {15, 13, 14, 15, 16, 18, 19, 17, 21, 12, 23, 23, 22};
        int rnd = 0 + (int)(Math.random() * (((numbers.length - 1) - 0) + 1));
        return numbers[rnd];
    }

    /**
     * Generates a random name based on name banks above
     * @return
     */
    public String genName() {
        int rnd0 = 0 + (int)(Math.random() * (((names.length - 1) - 0) + 1));

        return names[rnd0];
    }

    /**
     * Generates a drink item
     * @param value extra value modifier for special conditions
     * @return generated drink
     */
    public Steroid genSteroid(int value) {
        int stamina = genStamina();
        Steroid genSteroid = new Steroid(genName(), genVal(stamina)+value, stamina+value, genSpeed()+value, "Steroid", "Risky but insane increase in stamina and speed");
        return genSteroid;
    }
}
