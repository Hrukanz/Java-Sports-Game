package sportstournament.core;

public class Shoe extends Purchasable{
    private int offence;
    private int defence;
    private int speed;

	/**
	 * Constructor class
	 * @param name_in name
	 * @param value_in value
	 * @param offence offence modifier
	 * @param defence defence modifier
	 * @param speed speed modifier
	 * @param type type
	 * @param ability ability
	 */
    public Shoe(String name_in, int value_in, int offenceInput, int defenceInput, int speedInput, String type, String ability) {
    	super(name_in, value_in, type, ability);
        offence = offenceInput;
        defence = defenceInput;
        speed = speedInput;
    }

	/**
	 * Getter for stamina modifier of snack
	 * @return stamina modifier
	 */
    public int getOffence() {
        return offence;
    }
    
    /**
	 * Getter for speed modifier of snack
	 * @return speed modifier
	 */
    public int getDefence() {
        return defence;
    }
    
    public int getSpeed() {
    	return speed;
    }
    
	/**
	 * Buys Shoe for given team
	 * @param team team buying
	 * @param item Shoe bought
	 * @return purchase status
	 */
    public String buy(Team team, Shoe item) {
    	if (team.getTotalMoney()>=item.getValue()) {
			if (team.getInventory().size()<4) {
				team.getInventory().addShoe(item);
            	team.addMoney(-item.getValue());
            	team.getInventory().setEmpty(false);
            	return "bought";
			}
			return "full";
		}
    	return "nomoney";
    }
}
