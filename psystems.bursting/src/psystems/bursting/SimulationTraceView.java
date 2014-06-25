package psystems.bursting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class SimulationTraceView extends ViewPart {

	public static final String ID = "psystems.bursting.simulationTrace";
	private Text m_simulationTrace;
	
	@Override
	public void createPartControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		top.setLayout(layout);
		
		m_simulationTrace = new Text(top, SWT.BORDER);
		m_simulationTrace.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		m_simulationTrace.setBackground(m_simulationTrace.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		m_simulationTrace.setForeground(m_simulationTrace.getDisplay().getSystemColor(SWT.COLOR_INFO_FOREGROUND));
		m_simulationTrace.setText("Hola esto es una vista");

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
