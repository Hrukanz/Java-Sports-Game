package sportstournament.ui;

import java.util.ArrayList;
import java.util.Arrays;
import sportstournament.core.Manager;

/**
 * Manager ui works with cmd line to help sort info
 */
public interface ManagerUi {
    String NAME_REQUIREMENT = "Your name must be between 3 and 15 characters and must not include numbers or special characters";

    String NAME_REGEX = "[a-zA-Z]{3,15}";
    
	ArrayList<String> INVENTORY = new ArrayList<String>(Arrays.asList("Shoes", "Drinks", "Snacks", "Steroids"));
	
	ArrayList<String> MARKET = new ArrayList<String>(Arrays.asList("Shoes", "Drinks", "Snacks", "Steroids", "Athletes"));
	
	ArrayList<String> DIFFICULTIES = new ArrayList<String>(Arrays.asList("easy","Easy","Medium","medium","Hard","hard"));

    void setup(Manager manager);

    void start();

    boolean confirmQuit();

    void quit();

    void reportError(String error);
}
