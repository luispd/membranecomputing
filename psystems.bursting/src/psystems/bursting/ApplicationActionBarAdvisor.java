package psystems.bursting;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction m_exitAction;
	private IWorkbenchAction m_aboutAction;
	private IWorkbenchAction m_launchSimulationAction;
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	m_exitAction = ActionFactory.QUIT.create(window);
    	register(m_exitAction);
    	m_aboutAction = ActionFactory.ABOUT.create(window);
    	register(m_aboutAction);
    	m_launchSimulationAction = new LaunchSimulationAction(window);
    	register(m_launchSimulationAction);
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager fileMenu = new MenuManager("File", "psystems.bursting.menus.main");
    	fileMenu.add(m_exitAction);
    	MenuManager simulationMenu = new MenuManager("&Simulation", "simulation");
    	simulationMenu.add(m_launchSimulationAction);
    	MenuManager helpMenu = new MenuManager("&Help", "help");
    	helpMenu.add(m_aboutAction);
    	
    	menuBar.add(fileMenu);
    	menuBar.add(simulationMenu);
    	menuBar.add(helpMenu);
    }
    
    protected void fillCoolBar(ICoolBarManager coolBar) {
        IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
        coolBar.add(toolbar);
        toolbar.add(m_launchSimulationAction);
    }
    
}
