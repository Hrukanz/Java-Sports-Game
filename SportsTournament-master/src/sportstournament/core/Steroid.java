package sportstournament.core;

public class Steroid extends Purchasable{
    private int stamina;
    private int speedUp;

	/**
	 * Constructor class
	 * @param name_in name
	 * @param value_in value
	 * @param stamina stamina modifier
	 * @param speedDown speed modifier
	 * @param type type
	 * @param ability ability
	 */
    public Steroid(String name_in, int value_in, int staminaInput, int speedInput, String type, String ability) {
    	super(name_in, value_in, type, ability);
        stamina = staminaInput;
        speedUp = speedInput;
    }

	/**
	 * Getter for stamina modifier of snack
	 * @return stamina modifier
	 */
    public int getStamina() {
        return stamina;
    }
    
    /**
	 * Getter for speed modifier of snack
	 * @return speed modifier
	 */
    public int getSpeedUp() {
        return speedUp;
    }
    
	/**
	 * Buys snack for given team
	 * @param team team buying
	 * @param item snack bought
	 * @return purchase status
	 */
    public String buy(Team team, Steroid item) {
    	if (team.getTotalMoney()>=item.getValue()) {
			if (team.getInventory().size()<4) {
				team.getInventory().addSteroid(item);
            	team.addMoney(-item.getValue());
            	team.getInventory().setEmpty(false);
            	return "bought";
			}
			return "full";
		}
    	return "nomoney";
    }
}
