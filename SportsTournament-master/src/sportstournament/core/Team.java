package sportstournament.core;

import java.util.ArrayList;


public class Team {
	   private String teamName;
	    private int gameLength;
	    private int totalMoney;
	    private String gameDifficulty;
	    private int currentWeek;
	    private int points;
	    private Inventory inventory;
	    private ArrayList<Athlete> teamAthletes;

	    /**
	     * Constructor class.
	     * @param teamNameIn
	     * @param numberOfWeeks
	     * @param startingMoney
	     * @param difficulty
	     * @param startingAthletes
	     * @param currentWeek
	     * @param startingPoints
	     */
	    
	    public Team(String teamNameIn, int numberOfWeeks, int startingMoney, String difficulty, ArrayList<Athlete> startingAthletes, int currentWeek, int startingPoints) {
	        teamName = teamNameIn;
	        gameLength = numberOfWeeks;
	        totalMoney = startingMoney;
	        gameDifficulty = difficulty;
	        teamAthletes = startingAthletes;
	        this.currentWeek = currentWeek;
	        points = startingPoints;
	        inventory = new Inventory();
	    }

	    /**
	     * gets money
	     * @return
	     */
	    public int getTotalMoney() {
	    	return totalMoney;
	    }
	    
	    /**
	     * gets points
	     * @return
	     */
	    public int getPoints() {
	    	return points;
	    }
	    
	    /**
	     * adds points to team
	     * @param added
	     */
	    public void addPoints(int added) {
	    	points+=added;
	    }
	    
	    /**
	     * add money to team
	     * @param money
	     */
	    public void addMoney(int money) {
	    	totalMoney += money;
	    }
	    
	    /**
	     * gets current week
	     * @return
	     */
	    public int getcurrentWeek() {
	    	return currentWeek;
	    }
	    
	    /**
	     * sets team week
	     */
	    public void setWeek() {
	    	if (currentWeek<gameLength) {
	    		currentWeek+=1;
	    	}
	    }

	    /**
	     * get team name
	     * @return
	     */
	    public String getTeamName() {
	    	return teamName;
	    }
	    
	    /**
	     * get game length
	     * @return
	     */
	    public int getGameLength() {
	    	return gameLength;
	    }

	    /**
	     * adds athlete to team
	     * @param Athlete
	     */
	    public void addAthlete(Athlete athlete) {
	        teamAthletes.add(athlete);
	    }
	    
	    /**
	     * returns Athlete list
	     * @return
	     */
	    public ArrayList<Athlete> getAthletes() {
	    	return teamAthletes;
	    }
	    
	    /**
	     * returns player inventory
	     * @return
	     */
	    public Inventory getInventory() {
	    	return inventory;
	    }
	    
	    /**
	     * returns athletes current stamina for whole team
	     * @return
	     */
	    public String getTeamStamina() {
	    	String string = "";
	    	for (Athlete athlete : teamAthletes) {
	    		string+="\n"+athlete.getName()+" has "+athlete.getStamina()+" stamina left";
	    	}
	    	return string;
	    }

	    /**
	     * returns athletes current stats
	     * @return
	     */
	    public String getCurrentAthleteStats() {
	    	String outString = "";
	    	for (Athlete athlete : teamAthletes) {
		    	outString+=athlete.getCurrentStats();
	    	}
	        return outString;
	    }
	    
	    /**
	     * get game difficulty
	     * @return
	     */
	    public String getDifficulty() {
	    	return gameDifficulty;
	    }
}
