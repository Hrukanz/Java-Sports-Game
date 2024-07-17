package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sportstournament.core.Market;
import sportstournament.core.Athlete;
import sportstournament.core.Steroid;
import sportstournament.core.Team;

class MarketTest {

	@Test
	void buyTest() {
		Steroid steroidTest = new Steroid("Test", 100, 10, 10, "Steroid", "Testing");
		Team teamTest = new Team("Test", 3, 100, "easy", new ArrayList<Athlete>(), 1, 1);
		Market marketTest = new Market();
		marketTest.addSteroid(steroidTest);
		String state = marketTest.buy("Test", teamTest);
		assertEquals(state, "bought");
		assertEquals(teamTest.getTotalMoney(), 0);
		
	}
	
	@Test
	void buyWithNoMoneyTest() {
		Steroid steroidTest = new Steroid("Test", 100, 10, 10, "Steroid", "Testing");
		Team teamTest = new Team("Test", 3, 0, "easy", new ArrayList<Athlete>(), 1, 1);
		Market marketTest = new Market();
		marketTest.addSteroid(steroidTest);
		String state = marketTest.buy("Test", teamTest);
		assertEquals(state, "nomoney");
		assertEquals(teamTest.getTotalMoney(), 0);
		
	}

}
