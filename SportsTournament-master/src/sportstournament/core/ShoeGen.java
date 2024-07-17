package sportstournament.core;

public class ShoeGen {
    private String[] names1 = {"Nike", "Adidas", "Puma", "Asics", "Reebok", "Converse", "Salomon", "Arcteryx", "Guidi"};
    private String[] names2 = {"Air Kukini", "Jordan", "Samba", "Mercury", "Vapormax", "XT6", "Speedcross", "Aerios", "Boot"};

    /**
     * Generates a random value based on offence amount
     * @param offence
     * @return
     */
    public int genVal(int offence) {
        int rnd = 0 + (int)(Math.random() * (((25 + (offence * 2)) - 0) + 1));
        return rnd;
    }

    /**
     * 
     * @return 
     */
    public int genOffence() {
    	int[] numbers = {1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4};
        int rnd = 0 + (int)(Math.random() * (((numbers.length - 1) - 0) + 1));
        return numbers[rnd];
    }
    
    /**
     * 
     * @return 
     */
    public int genDefence() {
    	int[] numbers = {1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4};
        int rnd = 0 + (int)(Math.random() * (((numbers.length - 1) - 0) + 1));
        return numbers[rnd];
    }
    
    
    /**
     * generates speed down factor of drink
     * @return speed down factor
     */
    public int genSpeed() {
        int[] numbers = {1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4};
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
    public Shoe genShoe(int value) {
        int offence = genOffence();
        Shoe genShoe = new Shoe(genName(), genVal(offence)+value, offence+value, genDefence()+value, genSpeed()+value, "Shoe", "Slight increase in speed, offence, and defence");
        return genShoe;
    }
}

