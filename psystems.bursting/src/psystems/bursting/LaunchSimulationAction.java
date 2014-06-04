package psystems.bursting;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class LaunchSimulationAction extends Action implements
		ISelectionListener, IWorkbenchAction {

	private final IWorkbenchWindow m_window;
	public final static String ID = "psystems.bursting.launchSimulation";
	//private IStructuredSelection selection;
	// En lugar de un selecion listener hay que hacer que esta 
	// opcion solo este disponible si hay un fichero con un modelo cargado
	// Ver en el libro como funciona lo de selection listener y tratar de
	// buscar algo parecido
	
	public LaunchSimulationAction(IWorkbenchWindow window) {
		this.m_window = window;
		setId(ID);
		setText("&Launch simulation...");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				"psystems.bursting", "icons/play.png"));
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}
	
	public void run() {
		
		System.out.println("LLPD run simulation");
		
	}

}
