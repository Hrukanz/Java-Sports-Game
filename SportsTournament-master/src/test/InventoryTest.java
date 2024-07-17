package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import sportstournament.core.Inventory;
import sportstournament.core.Team;
import sportstournament.core.Drink;
import sportstournament.core.Athlete;

class InventoryTest {

	@Test
	void addInventoryTest() {
		Inventory inventoryTest = new Inventory();
		int stamina = 10;
		int offence = 10;
		Drink drinkTest = new Drink("Test", 100, stamina, offence, "Drink", "Testing");
		inventoryTest.addDrink(drinkTest);
		assertEquals(inventoryTest.isEmpty(), false);
		String drinkName = (inventoryTest.getDrinks()).get(0).getName();
		assertEquals("Test", drinkName);
	}
	
	@Test
	void typeSearchTest() {
		Inventory inventoryTest = new Inventory();
		int stamina = 10;
		int offence = 10;
		Drink drinkTest = new Drink("Test", 100, stamina, offence, "Drink", "Testing");
		Drink drinkTest1 = new Drink("Test1", 100, stamina, offence, "Drink", "Testing");
		inventoryTest.addDrink(drinkTest);
		inventoryTest.addDrink(drinkTest1);
		String type = inventoryTest.itemType(drinkTest.getName());
		assertEquals(type, "Drink");
	}
	
	@Test
	void useTest() {
		Inventory inventoryTest = new Inventory();
		int stamina = 10;
		int offence = 20;
		int defence = 15;
		int speed = 5;
		Drink drinkTest = new Drink("Test", 100, stamina, offence, "Drink", "Testing");
		Athlete athleteTest = new Athlete("Test", offence, defence, stamina, speed, 100);
		athleteTest.reduceStamina(10);
		inventoryTest.addDrink(drinkTest);
		inventoryTest.use("Test", athleteTest);
		assertEquals(athleteTest.getTired(), false);
		assertEquals(athleteTest.getStamina(), 10);
		assertEquals(athleteTest.getOffence(), 40);
		
		assertEquals(inventoryTest.isEmpty(), true);
	}
	
	@Test
	void sellTest() {
		Team teamTest = new Team("Test", 3, 100, "easy", new ArrayList<Athlete>(), 1, 1);
		Inventory inventoryTest = teamTest.getInventory();
		int stamina = 10;
		int offence = 20;
		Drink drinkTest = new Drink("Test", 100, stamina, offence, "Drink", "Testing");
		inventoryTest.addDrink(drinkTest);
		inventoryTest.sell("Test", teamTest);
		assertEquals(inventoryTest.isEmpty(), true);
		assertEquals(teamTest.getTotalMoney(), 198);
	}
	
	
	

}
