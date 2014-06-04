package psystems.bursting;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.addView(SimulationPlotView.ID, IPageLayout.LEFT, 1.0f, layout.getEditorArea());
	}
}
