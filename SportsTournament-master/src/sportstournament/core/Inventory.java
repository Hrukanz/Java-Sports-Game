package sportstournament.core;

import java.util.ArrayList;

public class Inventory {
	 	private ArrayList<Snack> snacks;
	    private ArrayList<Shoe> shoes;
	    private ArrayList<Steroid> steroids;
	    private ArrayList<Drink> drinks;
	    private boolean empty;

		/**
		 * Constructor class
		 */
		public Inventory() {
		    snacks = new ArrayList<Snack>();
		    shoes = new ArrayList<Shoe>();
		    steroids = new ArrayList<Steroid>();
		    drinks = new ArrayList<Drink>();
		    empty = true;

		}
		
		/**
		 * getter for inventort size
		 * @return boolean
		 */
		public boolean getEmpty() {
			return empty;
		}
		
		/**
		 * sets wheter inventory is empty
		 * @param state boolean
		 */
		public void setEmpty(boolean state) {
			empty = state;
		}

		//add methods
		/**
		 * adds Snack item
		 * @param item Snack
		 */
		public void addSnack(Snack item ) {
			empty = false;
			snacks.add(item);
		}
		
		/**
		 * adds Drink item
		 * @param item Drink
		 */
		public void addDrink(Drink item ) {
			empty = false;
			drinks.add(item);
		}
		
		/**
		 * adds Shoe item
		 * @param item Shoe
		 */
		public void addShoe(Shoe item ) {
			empty = false;
			shoes.add(item);
		}
		
		/**
		 * adds Steroid item
		 * @param item Steroid
		 */
		public void addSteroid(Steroid item ) {
			empty = false;
			steroids.add(item);
		}
		
		// get methods
		/**
		 * returns current Snack inventory
		 * @return Snack list
		 */
		public ArrayList<Snack> getSnacks() {
			return snacks;
		}
		
		/**
		 * returns current Drink inventory
		 * @return Drink list
		 */
		public ArrayList<Drink> getDrinks() {
			return drinks;
		}
		
		/**
		 * returns current Steroid inventory
		 * @return Steroid list
		 */
		public ArrayList<Steroid> getSteroids() {
			return steroids;
		}
		
		/**
		 * returns current Shoe inventory
		 * @return Shoe list
		 */
		public ArrayList<Shoe> getShoes() {
			return shoes;
		}
		
		/**
		 * returns combined size of all inventories
		 * @return size
		 */
		public int size() {
			return snacks.size()+steroids.size()+shoes.size()+drinks.size();
		}
		
		/**
		 * Decieds what item Team is using on the Athlete
		 * @param name name of item
		 * @return item type
		 */
		public String itemType(String name) {
			for (Snack snack: snacks) {
				if (name.equals(snack.getName())) {
					return "Snack";
				}
			}
			for (Shoe shoe: shoes) {
				if (name.equals(shoe.getName())) {
					return "Shoe";
				}
			}
			for (Drink drink: drinks) {
				if (name.equals(drink.getName())) {
					return "Drink";
				}
			}
			for (Steroid steroid: steroids) {
				if (name.equals(steroid.getName())) {
					return "Steroid";
				}
	    	}
			return "fail";
	    }
		
		/**
		 * get name for item at index
		 * @param index index
		 * @return name of item
		 */
		public String getName(int index) {
			int increment = 0;
			for (Snack snack: snacks) {
				if (index==increment) {
					return snack.getName();
				}
				increment += 1;
			}
			for (Shoe shoe: shoes) {
				if (index==increment) {
					return shoe.getName();
				}
				increment += 1;
			}
			for (Drink drink: drinks) {
				if (index==increment) {
					return drink.getName();
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
		 * returns boolean if inventory is empty
		 * @return boolean
		 */
		public boolean isEmpty() {
			if (size()==0) {
				return true;
			}
			return false;
		}

		/**
		 * uses the item on given Athlete
		 * @param name item name
		 * @param Athlete Athlete
		 */
		public void use(String name, Athlete athlete) {
			for (Snack snack: snacks) {
				if (name.equals(snack.getName())) {
					athlete.useSnack(snack);
					snacks.remove(snacks.indexOf(snack));
					empty = isEmpty();
					break;
				}
			}
			for (Shoe shoe: shoes) {
				if (name.equals(shoe.getName())) {
					athlete.addShoe(shoe);
					shoes.remove(shoes.indexOf(shoe));
					empty = isEmpty();
					break;
				}
			}
			for (Drink drink: drinks) {
				if (name.equals(drink.getName())) {
					athlete.useDrink(drink);
					drinks.remove(drinks.indexOf(drink));
					empty = isEmpty();
					break;
				}
			}
			for (Steroid steroid: steroids) {
				if (name.equals(steroid.getName())) {
					athlete.useSteroid(steroid);
					steroids.remove(steroids.indexOf(steroid));
					empty = isEmpty();
					break;
				}
	    	}
	    }
		
		/**
		 * sells item
		 * @param name
		 * @param Team
		 */
		public void sell(String name, Team team) {
			for (Snack snack: snacks) {
				if (name.equals(snack.getName())) {
					team.addMoney(snack.getValue() - 2);
					snacks.remove(snacks.indexOf(snack));
					empty = isEmpty();
					break;
				}
			}
			for (Shoe shoe: shoes) {
				if (name.equals(shoe.getName())) {
					team.addMoney(shoe.getValue() - 2);
					shoes.remove(shoes.indexOf(shoe));
					empty = isEmpty();
					break;
				}
			}
			for (Drink drink: drinks) {
				if (name.equals(drink.getName())) {
					team.addMoney(drink.getValue() - 2);
					drinks.remove(drinks.indexOf(drink));
					empty = isEmpty();
					break;
				}
			}
			for (Steroid steroid: steroids) {
				if (name.equals(steroid.getName())) {
					team.addMoney(steroid.getValue() - 2);
					steroids.remove(steroids.indexOf(steroid));
					empty = isEmpty();
					break;
				}
	    	}
	    }
		
		/**
		 * return string of inventory
		 */
		public String toString() {
			String outString = "";
			int increment = 0;
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
