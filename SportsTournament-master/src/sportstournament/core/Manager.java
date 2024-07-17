package sportstournament.core;
import java.util.ArrayList;
import sportstournament.ui.ManagerUi;
/**
 * Manager class. This takes care of values referenced by other classes methods.
 * 
 */
public class Manager {
    
    private Match matches;
    private Team team;
    private Market market;
    private int gameWeeks=1;
    private final ManagerUi ui;
	private SnackGen snackGen = new SnackGen();
	private DrinkGen drinkGen = new DrinkGen();
	private SteroidGen steroidGen = new SteroidGen();
	private AthleteGen athleteGen = new AthleteGen();
	private ShoeGen shoeGen = new ShoeGen();
	
    /**
	 * constructor class
	 * @param ui
	 */   
	public Manager(ManagerUi ui) {
		this.ui = ui;
	}

	/**
	 * base setup of team
	 * @param team
	 */
    public void setup(Team team) {
		this.team = team;
		this.market = marketGenerator();
		this.matches = new Match(1,getDiffValue());
		ui.start();
    }
    
    /**
	 * Start game
	 */
    public void start() {
    	ui.setup(this);
    }
    
	/**
	 * quits game
	 * @param yes
	 */
    public void finish(boolean yes) {
    	if (yes) {
    		ui.quit();
    	}
    }
    
    /**
	 * returns team
	 * @return
	 */
    public Team getteam() {
    	return team;
    }
    
    /**
	 * gets modifier value based on difficulty
	 * @return
	 */
    public int getDiffValue() {
    	if (team.getDifficulty().equals("easy")) {
    		return (int)Math.floor(Math.random()*(2-1+1)+1)+gameWeeks;
    	} else if (team.getDifficulty().equals("medium")) {
    		return (int)Math.floor(Math.random()*(3-1+1)+1)+gameWeeks;
    	} else {
    		return (int)Math.floor(Math.random()*(5-3+1)+3)+gameWeeks;
    	}
    }
    
    /**
	 * set game market
	 */
    public void setMarket(Market market) {
    	this.market = market;
    }
    
    /**
	 * get game market
	 * @return
	 */
    public Market getMarket() {
    	return market;
    }
    
    /**
	 * get team athletes
	 * @param 
	 * @return
	 */
    public ArrayList<Athlete> getAthletes() {
    	return team.getAthletes();
    }
    
	/**
	 * get opponents athletes
	 * @param match
	 * @return
	 */
    public ArrayList<Athlete> getOpponentAthletes(int match) {
    	return getMatches().get(match);
    }
    
    
	/**
	 * get game matches
	 * @return
	 */
    public ArrayList<ArrayList<Athlete>> getMatches() {
    	return matches.getMatch();
    }
    
    /**
  	 * gets match class
  	 * @return
  	 */
    public Match getMatch() {
    	return matches;
    }
    
    /**
	 * generates game market
	 * @return
	 */
    public Market marketGenerator() {
    	Market newMarket = new Market();
    	newMarket.addAthlete(athleteGen.generateAthlete(getDiffValue()));
    	newMarket.addSteroid(steroidGen.genSteroid(getDiffValue()));
    	newMarket.addSnack(snackGen.genSnack(getDiffValue()));
    	newMarket.addDrink(drinkGen.genDrink(getDiffValue()));
    	newMarket.addShoe(shoeGen.genShoe(getDiffValue()));
    	newMarket.setEmpty(false);
    	return newMarket;
    }
    
    /**
	 * generate starter Athletes
	 * @param amount
	 * @return
	 */
    public ArrayList<Athlete> generateStarters(int amount) {
    	ArrayList<Athlete> list = new ArrayList<Athlete>();
    	for (int i=0; i<amount; i++) {
    		Athlete Athlete = athleteGen.generateAthlete(1);
    		list.add(Athlete);
    	}
    	return list;
    }
    
    /**
	 * generates singular Athlete
	 * @return
	 */
    public Athlete generateAthlete() {
    	return athleteGen.generateAthlete(getDiffValue());
    }
    
    /**
	 * heals Athlete
	 * @param Athlete Athlete to heal
	 * @param heal amount
	 */
    public void heal(Athlete Athlete, int regen) {
    	Athlete.staminaRegen(regen);
    }
    
	
	/**
	 * returns starting gold based of game difficulty
	 * @param difficulty difficulty
	 * @return
	 */
	public int startMoney(String difficulty) {
		if (difficulty.equals("easy")) {
			return 40000;
		} else if (difficulty.equals("medium")) {
			return 25000;
		} else {
			return 10000;
		}
	}
	
	/**
	 * make team go through sleep cycle
	 * @return
	 */
	public String sleep() {
		team.setWeek();
		this.gameWeeks+=1;
		if (gameWeeks>team.getGameLength()) {
			return "gameover";
		}
		this.matches = new Match(2,getDiffValue());
		return "nextWeek";
	}

}
