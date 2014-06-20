package psystems.bursting;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;



public class MembraneModelEditor extends EditorPart {

	public static String ID = "psystems.bursting.editors.membraneModel";
	private Text m_plinguaCode;
	
	public MembraneModelEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		setPartName(getUser());

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		top.setLayout(layout);
		
		m_plinguaCode = new Text(top, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		m_plinguaCode.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		m_plinguaCode.setBackground(m_plinguaCode.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		m_plinguaCode.setForeground(m_plinguaCode.getDisplay().getSystemColor(SWT.COLOR_INFO_FOREGROUND));
		
		String modelText = ((MembraneModelEditorInput)getEditorInput()).getModelText();
		
		m_plinguaCode.setText(modelText);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	private String getUser() {
		return ((MembraneModelEditorInput)getEditorInput()).getName();
	}

}
