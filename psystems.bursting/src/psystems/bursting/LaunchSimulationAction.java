package psystems.bursting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.gcn.plinguacore.parser.AbstractParserFactory;
import org.gcn.plinguacore.parser.input.InputParser;
import org.gcn.plinguacore.parser.input.InputParserFactory;
import org.gcn.plinguacore.simulator.ISimulator;
import org.gcn.plinguacore.util.PlinguaCoreException;
import org.gcn.plinguacore.util.psystem.Psystem;

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
		
		//FileDialog fd = new FileDialog(m_window.getShell());
		//String filePath = fd.open();
		
		try {
			  /* Open a P-Lingua file*/
			  FileInputStream stream = new FileInputStream("C:\\Users\\Luis\\Desktop\\transition.pli");
			  try 
			  {
			  /* Create a new InputParser for P-Lingua format */
			   AbstractParserFactory pf = new InputParserFactory();
			   InputParser parser = (InputParser) pf.createParser("P-Lingua");
			   parser.setVerbosityLevel(5);
			   /* Parse the file */
			   Psystem ps = parser.parse(stream);
			   /* Create a simulator for active membranes */
			   ISimulator sim = ps.createSimulator(false, false);
			   sim.setTimed(true);
			   sim.setVerbosity(1);
//			   sim.setInfoChannel(System.out);
			   /* Run until a halt state */
			   sim.run();
			 
			  } catch (PlinguaCoreException ex) {
			 	ex.printStackTrace();
			  }
			  } catch (FileNotFoundException e) {
				e.printStackTrace();
			  }
			 
		
		
		System.out.println("LLPD run simulation");
		
	}

}
