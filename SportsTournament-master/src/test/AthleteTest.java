package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sportstournament.core.Athlete;
import sportstournament.core.Drink;
import sportstournament.core.Shoe;

class AthleteTest {

	
	@Test
	void levelUpTest() {
		int stamina = 10;
		int offence = 20;
		int defence = 15;
		int speed = 5;
		Athlete athleteTest = new Athlete("Test", offence, defence, stamina, speed, 100);
		athleteTest.levelUpStats(10);
		assertEquals(athleteTest.getMaxStamina(), 20);
		assertEquals(athleteTest.getOffence(), 30);

	}
	
	@Test
	void staminaRegenTest() {
		int stamina = 10;
		int offence = 20;
		int defence = 15;
		int speed = 5;
		Athlete athleteTest = new Athlete("Test", offence, defence, stamina, speed, 100);
		athleteTest.reduceStamina(10);
		assertEquals(athleteTest.getTired(), true);
		athleteTest.staminaRegen(100);
		assertEquals(athleteTest.getTired(), false);
		assertEquals(athleteTest.getStamina(), 10);
		
	}
	
	@Test
	void useDrinkTest() {
		int stamina = 10;
		int offence = 20;
		int defence = 15;
		int speed = 5;
		Drink drinkTest = new Drink("Test", 100, stamina, offence, "Drink", "Testing");
		Athlete athleteTest = new Athlete("Test", offence, defence, stamina, speed, 100);
		athleteTest.reduceStamina(10);
		assertEquals(athleteTest.getTired(), true);
		athleteTest.useDrink(drinkTest);
		assertEquals(athleteTest.getTired(), false);
		assertEquals(athleteTest.getStamina(), 10);
		assertEquals(athleteTest.getOffence(), 40);
		
		
	}
	
	@Test
	void shoeTest() {
		int stamina = 10;
		int offence = 20;
		int defence = 15;
		int speed = 5;
		Shoe shoeTest = new Shoe("Test", 100, offence, defence, speed, "Shoe", "Testing");
		Athlete athleteTest = new Athlete("Test", offence, defence, stamina, speed, 100);
		assertEquals((athleteTest.getShoe()).getName(), "empty");
		athleteTest.addShoe(shoeTest);
		assertEquals((athleteTest.getShoe()).getName(), "Test");
		
	}

}
