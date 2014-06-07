package psystems.bursting;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class MembraneModelAction extends Action implements ISelectionListener,
		IWorkbenchAction {

	private final IWorkbenchWindow m_window;
	public final static String ID = "psystems.bursting.membraneModel";
	
	public MembraneModelAction(IWorkbenchWindow window) {
		m_window = window;
		setId(ID);
		setText("&MembraneModel");
		setToolTipText("Membrane model");
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
		IWorkbenchPage page = m_window.getActivePage();
		MembraneModelEditorInput input = new MembraneModelEditorInput();
		
		try {
			page.openEditor(input, MembraneModelEditor.ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
