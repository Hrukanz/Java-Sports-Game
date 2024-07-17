package sportstournament.core;

public class Drink extends Purchasable{
    private int stamina;
    private int offenceUp;

	/**
	 * Constructor class
	 * @param name_in name
	 * @param value_in value
	 * @param stamina stamina modifier
	 * @param offenceUp offence modifier
	 * @param type type
	 * @param ability ability
	 */
    public Drink(String name_in, int value_in, int staminaInput, int offenceInput, String type, String ability) {
    	super(name_in, value_in, type, ability);
        stamina = staminaInput;
        offenceUp = offenceInput;
    }

	/**
	 * Getter for stamina modifier of drink
	 * @return stamina modifier
	 */
    public int getStamina() {
        return stamina;
    }
    
    /**
	 * Getter for offence modifier of drink
	 * @return offence modifier
	 */
    public int getOffenceUp() {
        return offenceUp;
    }
    
	/**
	 * Buys drink for given team
	 * @param team team buying
	 * @param item drink bought
	 * @return purchase status
	 */
    public String buy(Team team, Drink item) {
    	if (team.getTotalMoney()>=item.getValue()) {
			if (team.getInventory().size()<4) {
				team.getInventory().addDrink(item);
            	team.addMoney(-item.getValue());
            	team.getInventory().setEmpty(false);
            	return "bought";
			}
			return "full";
		}
    	return "nomoney";
    }
}

