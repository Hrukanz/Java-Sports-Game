package sportstournament.core;

import java.util.ArrayList;

public class Market {
    private ArrayList<Snack> snacks;
    private ArrayList<Drink> drinks;
    private ArrayList<Steroid> steroids;
    private ArrayList<Athlete> athletes;
    private ArrayList<Shoe> shoes;
    private boolean empty;
	
	/**
	 * constructor for shop class
	 */
	public Market() {
	    snacks = new ArrayList<Snack>();
	    drinks = new ArrayList<Drink>();
	    steroids = new ArrayList<Steroid>();
	    athletes = new ArrayList<Athlete>();
	    shoes = new ArrayList<Shoe>();
	    empty = true;

	}
	
	// add methods
	/**
	 * getter for snack
	 * @param item of type snack
	 */
	public void addSnack(Snack item ) {
		snacks.add(item);
	}
	
	/**
	 * getter for shoe
	 * @param item of type shoe
	 */
	public void addShoe(Shoe item ) {
		shoes.add(item);
	}
	
	/**
	 * adds item to shop
	 * @param item
	 */
	public void addDrink(Drink item ) {
		drinks.add(item);
	}
	
	/**
	 * adds item to shop
	 * @param item of type athlete
	 */
	public void addAthlete(Athlete item ) {
		athletes.add(item);
	}
	
	/**
	 * adds item to shop
	 * @param item of type steroid
	 */
	public void addSteroid(Steroid item ) {
		steroids.add(item);
	}
	
	// get methods
	/**
	 * gets an list of the snack type in the store
	 * @return list of snack type
	 */
	public ArrayList<Snack> getSnacks() {
		return snacks;
	}
	
	/**
	 * gets an list of the shoe type in the store
	 * @return list of shoe type
	 */
	public ArrayList<Shoe> getShoes() {
		return shoes;
	}
	
	/**
	 * gets an list of steroid type in the store
	 * @return list of steroid type
	 */
	public ArrayList<Steroid> getSteroids() {
		return steroids;
	}
	
	/**
	 * gets an list of drink type in the store
	 * @return list of drink type
	 */
	public ArrayList<Drink> getDrink() {
		return drinks;
	}
	
	/**
	 * gets an list of athlete type in the store
	 * @return list of athlete type
	 */
	public ArrayList<Athlete> getAthlete() {
		return athletes;
	}
	
	/**
	 * @return boolean true or false of empty
	 */
	public boolean getEmpty() {
		return empty;
	}
	
	/**
	 * @param state is boolean which empty is set to
	 */
	public void setEmpty(boolean state) {
		empty = state;
	}
	
	/**
	 * Checks size of store
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (size()==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * combined size of store
	 * @return integer size of store
	 */
	public int size() {
		return snacks.size()+steroids.size()+athletes.size()+drinks.size()+shoes.size();
	}
	
	/**
	 * returns name of item at index
	 * @param index 
	 * @return name of type string
	 */
	public String getName(int index) {
		int increment = 0;
		for (Athlete athlete: athletes) {
			if (index==increment) {
				return athlete.getName();
			}
			increment += 1;
		}
		for (Snack snack: snacks) {
			if (index==increment) {
				return snack.getName();
			}
			increment += 1;
		}
		for (Drink drink: drinks) {
			if (index==increment) {
				return drink.getName();
			}
			increment += 1;
		}
		for (Shoe shoe: shoes) {
			if (index==increment) {
				return shoe.getName();
			}
			increment += 1;
		}
		for (Steroid steroid: steroids) {
			if (index==increment) {
				return steroid.getName();
			}
			increment += 1;
		}
		return "fail";
	}
	
	/**
	 * Allows user to buy items
	 * @param name of item and is a string
	 * @param team of type team
	 * @return returns String
	 */
    public String buy(String name, Team team) {
    	for (Athlete athlete: athletes) {
			if (name.equals(athlete.getName())) {
				String state = athlete.buy(team, athlete);
				if (state.equals("nomoney")||state.equals("full")) {
					empty = isEmpty();
					return state;
				} else {
					athletes.remove(athletes.indexOf(athlete));
					empty = isEmpty();
					return state;
				}
			}
		}
		for (Snack snack: snacks) {
			if (name.equals(snack.getName())) {
				String state = snack.buy(team, snack);
				if (state.equals("nomoney")||state.equals("full")) {
					empty = isEmpty();
					return state;
				} else {
					snacks.remove(snacks.indexOf(snack));
					empty = isEmpty();
					return state;
				}
			}
		}
		for (Drink drink: drinks) {
			if (name.equals(drink.getName())) {
				String state = drink.buy(team, drink);
				if (state.equals("nomoney")||state.equals("full")) {
					empty = isEmpty();
					return state;
				} else {
					drinks.remove(drinks.indexOf(drink));
					empty = isEmpty();
					return state;
				}
			}
		}
		for (Shoe shoe: shoes) {
			if (name.equals(shoe.getName())) {
				String state = shoe.buy(team, shoe);
				if (state.equals("nomoney")||state.equals("full")) {
					empty = isEmpty();
					return state;
				} else {
					shoes.remove(shoes.indexOf(shoe));
					empty = isEmpty();
					return state;
				}
			}
		}
		for (Steroid steroid: steroids) {
			if (name.equals(steroid.getName())) {
				String state = steroid.buy(team, steroid);
				if (state.equals("nomoney")||state.equals("full")) {
					empty = isEmpty();
					return state;
				} else {
					steroids.remove(steroids.indexOf(steroid));
					empty = isEmpty();
					return state;
				}
			}
    	}
		return "fail";
    }
    
  	/**
  	 * returns string version of store
  	 */
	public String toString() {
		String outString = "";
		int increment = 0;
		for (Athlete athlete: athletes) {
			outString+="\n("+increment+") "+athlete+" || Stamina : "+athlete.getStamina()+" || Speed: "+athlete.getSpeed() +" || Offence: "+athlete.getOffence()+" || Defence: "+athlete.getDefence();
			increment += 1;
		}
		
		for (Snack snack: snacks) {
			outString+="\n("+increment+") "+snack+" || Stamina Regen: "+snack.getStamina()+" || Speed Down: "+snack.getSpeedDown();
			increment += 1;
		}
		for (Shoe shoe: shoes) {
			outString+="\n("+increment+") "+shoe+" || Offence Up: "+shoe.getOffence()+" || Defence Up: "+shoe.getDefence()+" || Speed Up: "+shoe.getSpeed();
			increment += 1;
		}
		for (Drink drink: drinks) {
			outString+="\n("+increment+") "+drink+" || Stamina Regen: "+drink.getStamina()+" || Offence Up: "+drink.getOffenceUp();
			increment += 1;
		}
		for (Steroid steroid: steroids) {
			outString+="\n("+increment+") "+steroid+" || Stamina Up & Regen: "+steroid.getStamina()+" || Speed Up: "+steroid.getSpeedUp();
			increment += 1;
		}
		return outString;
	}
}
