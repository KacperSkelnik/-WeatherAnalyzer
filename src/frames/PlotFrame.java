package frames;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PlotFrame extends JFrame {
	public PlotFrame(String name) {
		this.setSize(480, 480);
		JPanel panel_1 = new JPanel();
		this.add(panel_1);
		Image icon = new ImageIcon(this.getClass().getResource("/ploticon.png")).getImage();
		this.setIconImage(new ImageIcon(icon).getImage());
		this.setTitle(name);
		
		JMenuBar menuBarPlot = new JMenuBar();
		JMenu menuPlot = new JMenu("Opcje");
		JMenuItem plotColor = new JMenuItem("Kolor wykresu");
		JMenuItem plotBGColor = new JMenuItem("Kolor t³a");
		menuPlot.add(plotColor);
		menuPlot.add(plotBGColor);
		menuBarPlot.add(menuPlot);
		
		this.setJMenuBar(menuBarPlot);
		
		
		
		XYSeries series = new XYSeries("Liniowa");
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		JFreeChart plot = ChartFactory.createXYLineChart(name, "x", "y", dataset);
		ChartPanel plotPanel = new ChartPanel(plot);
		this.add(plotPanel,BorderLayout.CENTER);
	}
}
