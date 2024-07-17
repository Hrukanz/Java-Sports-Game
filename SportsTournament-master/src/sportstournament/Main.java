package sportstournament;

import sportstournament.core.Manager;
import sportstournament.gui.Gui;
import sportstournament.ui.CmdLineUi;
import sportstournament.ui.ManagerUi;

/**
 * Application entry point for the application.
 */
public class Main {
	
    /**
     * @param args The command line arguments. This application supports a single argument: {@code cmd}.
     *             If {@code cmd} is present the application will use a command line interface.
     *             When no argument is specified the application will use a graphical interface.
     */
    public static void main(String[] args) {

       ManagerUi ui;

        if (args.length > 0 && (args[0].equals("cmd"))) {
            ui = new CmdLineUi();
            Manager manager = new Manager(ui);
            manager.start();
		} else { 
			ui = new Gui();
			Manager manager = new Manager(ui);
			manager.start(); 
		}

    }
}


