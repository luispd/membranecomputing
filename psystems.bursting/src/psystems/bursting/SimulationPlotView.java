package psystems.bursting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.swtchart.Chart;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries.SeriesType;

public class SimulationPlotView extends ViewPart {

	public static final String ID = "psystems.bursting.simulationPlot";
	
	public SimulationPlotView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		// create a chart
		Chart chart = new Chart(parent, SWT.NONE);
		    
		// set titles
		chart.getTitle().setText("Line Chart Example");
		chart.getAxisSet().getXAxis(0).getTitle().setText("Data Points");
		chart.getAxisSet().getYAxis(0).getTitle().setText("Amplitude");

		// create line series
		ILineSeries lineSeries = (ILineSeries) chart.getSeriesSet()
		    .createSeries(SeriesType.LINE, "line series");
		lineSeries.setYSeries(new double[] {2.1,3.2,1.1,4.6});

		// adjust the axis range
		chart.getAxisSet().adjustRange();

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
