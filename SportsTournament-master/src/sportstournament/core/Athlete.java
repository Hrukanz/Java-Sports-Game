package sportstournament.core;

public class Athlete extends Purchasable{
    private String name;
    private int offence;
    private int defence;
    private int maxStamina;
    private int currentStamina;
    private int speed;
    private boolean injured = false;
    private boolean tired = false;
    private Shoe shoes;

    /**
     * Constructor
     * @param nameInput
     * @param offenceInput
     * @param defenceInput
     * @param staminaInput
     * @param speedInput
     */
    public Athlete(String nameInput, int offenceInput, int defenceInput, int staminaInput, int speedInput, int price) {
    	super(nameInput, price, "Athlete", "Athlete that can play for your team" );
        name = nameInput;
        offence = offenceInput;
        defence = defenceInput;
        maxStamina = staminaInput;
        currentStamina = maxStamina;
        speed = speedInput;
        shoes = new Shoe("empty", 0,0,0,0,"Shoe", "Slight increase in speed, offence, and defence");
     }

    /**
     * @return athletes current stamina.
     */
    public int getStamina() {
        return currentStamina;
    }
    
    public void reduceStamina(int input) {
    	if ((currentStamina-input)<=0) {
    		currentStamina = 0;
    		tired = true;
    	}
    	else {
        	currentStamina -= input;
    	}
    }
    
    public int getOffence() {
    	return offence+shoes.getOffence();
    }
    
    public int getDefence() {
    	return defence+shoes.getDefence();
    }
    
    /**
     * @return athletes name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Increases athletes max stamina, offence, defence, and speed as if they has "leveled up"
     * @param randomly generated number that acts as the "level up" value.
     */
    public void levelUpStats(int value) {
    	maxStamina += value;
    	offence += value;
    	defence += value;
    	speed += value;
    }
    
    
    /**
     * @return athletes speed.
     */
    public int getSpeed() {
    	return speed+shoes.getSpeed();
    }
    
    /**
     * Gives athlete shoes.
     * @param purchasable from shop of type shoe.
     */
    public void addShoe(Shoe purchasable) {
    	shoes = purchasable;
    }
    
    /**
     * @return athlete equipped shoes.
     */
    public Shoe getShoe() {
    	return shoes;
    }
    
    /**
     * @return if athlete injured or not.
     */
    public boolean getInjured() {
        return injured;
    }
    
    public boolean getTired() {
    	return tired;
    }
    
    /**
     * @return monsters maximum health.
     */
    public int getMaxStamina() {
        return maxStamina;
    }

    /**
     * @param stamina amount to regen.
     */
    public void staminaRegen(int regen) {
    	if (currentStamina == 0) {
    		tired = false;
    	}
    	
        if (currentStamina + regen > maxStamina) {
            currentStamina = maxStamina;
        } else {
            currentStamina = currentStamina + regen;
        }
    }
    
    
    public void useDrink(Drink drink) {
    	staminaRegen(drink.getStamina());
    	offence += drink.getOffenceUp();
    }
    
    public void useSnack(Snack snack) {
    	staminaRegen(snack.getStamina());
    	speed += snack.getSpeedDown();
    }
    
    public void useSteroid(Steroid steroid) {
    	maxStamina += steroid.getStamina();
    	staminaRegen(steroid.getStamina());
    	speed += steroid.getSpeedUp();
    }
    
    
    /**
     * @param item to be added to inventory of type Monster.
     * @param player of type player to add item to.
     * @return a string of the state of purchase.
     */
    public String buy(Team team, Athlete item) {
    	if (team.getTotalMoney()>=item.getValue()) {
			if (team.getInventory().size()<4) {
				team.getAthletes().add(item);
            	team.addMoney(-item.getValue());
            	team.getInventory().setEmpty(false);
            	return "bought";
			}
			return "full";
		}
    	return "nomoney";
    }
    
    
    /**
     * @return athletes current stats
     */
    public String getCurrentStats() {
        String outString = "\nName: " + getName() + "\n";
        outString += "Current Stamina: " + getStamina() + "\n";
        outString += "Offence: " + getOffence() + "\n";
        outString += "Defence: " + getDefence() + "\n";
        outString += "Speed: " + getSpeed() + "\n";
        if ((!shoes.getName().equals("empty"))) {
        	outString += "Shoes: " + getShoe().getName() + " which increases speed by " + getShoe().getSpeed();
        }
        
        return outString;	
    }
    

    /**
     * @Override printing of athlete type.
     * @return athlete as a string.
     */
    public String toString() {
    	 String outString = "\nName: " + getName() + "\n";
         outString += "Max Stamina: " + getMaxStamina() + "\n";
         outString += "Offence: " + getOffence() + "\n";
         outString += "Defence: " + getDefence() + "\n";
         outString += "Speed: " + getSpeed() + "\n";
         
         return outString;
    }

}

