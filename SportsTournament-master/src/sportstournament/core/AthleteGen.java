package sportstournament.core;

public class AthleteGen {
    public String[] names = {"Lebron", "James", "Messi", "Lionel", "Ronaldo", "Christiano", "Tiger", "Woods", "Kobe", "Bryant",
    		"Nate", "Diaz", "Israel", "Adesanya", "Mike", "Tyson", "Tyson", "Fury"};

    /**
     * Generates name based on name bank
     * @return random name
     */
    public String getName() {
        int rnd = 0 + (int)(Math.random() * (((names.length - 1) - 0) + 1));
        return names[rnd];
    }


    /**
     * Generates random defence amount withing paramaters
     * @return defence
     */
    public int getDefence() {
        return 5 + (int)(Math.random() * ((10 - 5) + 1));
    }
    
    /**
     * Generates random offence amount withing paramaters
     * @return offence
     */
    public int getOffence() {
        return 5 + (int)(Math.random() * ((10 - 5) + 1));
    }
    
    /**
     * generates value of athlete based on stamina had
     * @param stamina
     * @return value
     */
    public int getValue(int stamina) {
        int rnd = 0 + (int)(Math.random() * (((25 + (stamina * 2)) - 0) + 1));
        return rnd;
    }

    /**
     * Generates stamina of athlete
     * @return stamina
     */
    public int getStamina() {
        return 10 + (int)(Math.random() * ((20 - 10) + 1));
    }
    
    /**
     * Generates random speed for athlete
     * @return speed
     */
    public int getSpeed() {
    	return 5 + (int)(Math.random() * ((10 - 5) + 1));
    }

    /**
     * Generates random athlete
     * @param value extra modifier for special use
     * @return Generated athlete
     */
    public Athlete generateAthlete(int value) {
    	int stamina = getStamina();
        Athlete athlete = new Athlete(getName(), getOffence()+value, getDefence()+value, stamina+value, getSpeed()+value,getValue(stamina));
        return athlete;
    }
}
