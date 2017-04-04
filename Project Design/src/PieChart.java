import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

/**
 * PieChart object cotains the title of the chart the wedges of the chart.
 * Also contains the PieChartPanel class.
 * 
 * @author Joe Pauly, Nathan Fritz, Cavan Gary
 *
 */
public class PieChart {
	
	/** The title of the pie chart */
	private String title;
	
	/** A list of wedges for the pie chart */
	private List<Wedge> wedges;
		
	/**
	 * Constructor of the pie chart class.
	 *
	 * @param title
	 * 				The title of the pie chart.
	 * @param wedges
	 * 				The wedges of the pie chart.
	 */
	public PieChart(String title, List<Wedge> wedges) {
	}
		
		/**
		 * The PieChartPanel is and extension of JPanel.
		 *
		 * @author Joe Pauly, Nathan Fritz, Cavan Gary
		 *
		 */
		public class PieChartPanel extends JPanel
		{
			/** The Serial UID */
			private static final long serialVersionUID = 1L;
		
			/** 
			 * Overridden paintComponent method to paint
			 * the wedges of the pie chart.
			 */
			@Override
			public void paintComponent(Graphics g) {
			}
		}
}
