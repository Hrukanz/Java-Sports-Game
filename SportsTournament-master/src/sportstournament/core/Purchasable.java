package sportstournament.core;

public class Purchasable {
	  private String name;
	    private int value;
	    private String type;
	    private String ability;

	    /**
	     * constructor class
	     * @param name_in name
	     * @param value_in value
	     * @param itemType type
	     * @param property what it does
	     */
	    public Purchasable(String name_in, int value_in, String itemType, String property) {
	    	type = itemType;
	        name = name_in;
	        value = value_in;
	        ability = property;
	    }
	    
	    /**
	     * get ablility
	     * @return ability
	     */
	    public String getAbility() {
	    	return ability;
	    }
	    
	    /**
	     * get type
	     * @return type
	     */
	    public String getType() {
	    	return type;
	    }
	    
	    /**
	     * get name
	     * @return name
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * get value
	     * @return value
	     */
	    public int getValue() {
	        return value;
	    }
	    
	    /**
	     * return string of item
	     */
	    public String toString() {
	    	return "Type: "+type+" || Name: "+name+" || Ability: "+ability+" || Value: "+value+" gold";
	    }
}
