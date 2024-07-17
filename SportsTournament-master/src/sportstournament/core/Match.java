package sportstournament.core;

import java.util.ArrayList;

public class Match {
	ArrayList<ArrayList<Athlete>> matches;
	
	/**
	 * Constructor class
	 * @param day day
	 * @param difficulty difficulty
	 */
	public Match(int week, int difficulty) {
		matches = matchGenerator(week,difficulty);
	}
	
	/**
	 * Generates a list of a list of athletes each one being a different match
	 * @param day day
	 * @param difficulty difficulty
	 * @return returns a list of a list of athlete which can be used as potential matchs
	 */
	public ArrayList<ArrayList<Athlete>> matchGenerator(int week, int difficulty) {
		int amount = 0;
		AthleteGen athleteGen = new AthleteGen();
		ArrayList<ArrayList<Athlete>> matchList = new ArrayList<ArrayList<Athlete>>();
		for (int i=0; i<4; i++) {
			ArrayList<Athlete> list = new ArrayList<Athlete>();
			matchList.add(list);
			if (week<4) {
				amount = week;
			} else {
				amount = (int)Math.floor(Math.random()*(5-3+1)+3);
			}
			for (int n=0; n<amount; n++) {
	    		Athlete athlete = athleteGen.generateAthlete(difficulty);
	    		matchList.get(i).add(athlete);
	    	}
		}
		return matchList;
	}

	/**
	 * Returns matches
	 * @return matches
	 */
	public ArrayList<ArrayList<Athlete>> getMatch() {
		return matches;
	}
	
	/**
	 * removes matchs from array
	 * @param index which match to remove
	 */
	public void removeMatch(int index) {
		matches.remove(index);
	}
	
	/**
	 * Decideds who goes first in match
	 * @param team team
	 * @param opponent opponent
	 * @param turn turn
	 * @return who goes first
	 */
	public String offence(Athlete team, Athlete opponent) {
		if (team.getSpeed()>=opponent.getSpeed()) {
			return "team";
		}
		
		return "opponent";
	}
	
	
	public String commenceMatch(ArrayList<Athlete> team, ArrayList<Athlete> opponent) {
		String whoWon;
		int teamIndex = 0, opponentIndex = 0;
		while (true) {
			if (offence(team.get(teamIndex), opponent.get(opponentIndex)) == "team") {
				(team.get(teamIndex))
			}
		}
		return whoWon;
	}
	
	public String attack(Athlete team, Athlete opponent) {
		4
	}
	
	/**
	 * Runs at end of matchs
	 * @param index index
	 * @param matchIndex match index
	 * @param match current match
	 * @return returns if removed
	 */
    public boolean matchOver(int index, int matchIndex, ArrayList<Athlete> match) {
    	if (index>=match.size()) {
    		this.removeMatch(matchIndex);
    		return true;
    	} else {
    		return false;
    	}
    }
    
	/**
	 * check if team is out of athletes
	 * @param index index
	 * @param athletes athletes
	 * @return boolean
	 */
    public boolean teamOver(int index, ArrayList<Athlete> athletes) {
    	if (index>=athletes.size()) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
	/**
	 * decides and rewards match rewards
	 * @param whoWon winner of match
	 * @param team team
	 */
    public void matchRewards(String whoWon, Team team) {
    	String difficulty = team.getDifficulty();
    	if (whoWon.equals("opponent")) {
    		if (difficulty.equals("easy")) {
        		team.addMoney(-10);
        	} else if (difficulty.equals("medium")) {
        		team.addMoney(-15);
        	} else if (difficulty.equals("hard")){
        		team.addMoney(-25);
        	}
    	} else {
    		if (difficulty.equals("easy")) {
        		team.addMoney(30);
        		team.addPoints(20);
        	} else if (difficulty.equals("medium")) {
        		team.addMoney(20);
        		team.addPoints(35);
        	} else if (difficulty.equals("hard")){
        		team.addMoney(15);
        		team.addPoints(50);
        	}
    	}
    	
    }

	/**
	 * To string for match
	 */
	public String toString() {
		int increment = 0;
		String outString = "";
		for (ArrayList<Athlete> match : matches) {
			outString+="("+increment+")";
			for (Athlete athlete : match) {
				outString+="\n"+athlete;
			}
			increment++;
		}
		return outString;
	}
}
