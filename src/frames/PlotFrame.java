package frames; //Wojtek Tyczyñski

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class PlotFrame extends JFrame {
	public PlotFrame(String name, String query, String x_plot, String y_plot) {
		
		Language lang = new Language();
		
		this.setSize(1080, 640);
		JPanel panel_1 = new JPanel();
		this.add(panel_1);
		Image icon = new ImageIcon(this.getClass().getResource("/ploticon.png")).getImage();
		this.setIconImage(new ImageIcon(icon).getImage());
		this.setTitle(name);
		
		JMenuBar menuBarPlot = new JMenuBar();
		JMenu menuPlot = new JMenu(lang.Res.getString("options"));
		JMenuItem plotColor = new JMenuItem(lang.Res.getString("chart_color"));
		JMenuItem plotBGColor = new JMenuItem(lang.Res.getString("background_color"));
		menuPlot.add(plotColor);
		menuPlot.add(plotBGColor);
		menuBarPlot.add(menuPlot);
		
		this.setJMenuBar(menuBarPlot);
		
		try {
			JDBCCategoryDataset dataset = new JDBCCategoryDataset(JavaConnect.ConnectDB(),query);
			JFreeChart chart = ChartFactory.createLineChart(name, x_plot, y_plot, dataset);
			ChartPanel plotPanel = new ChartPanel(chart);
			this.add(plotPanel,BorderLayout.CENTER);
			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
			
			
			plotBGColor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Color color = JColorChooser.showDialog(null, lang.Res.getString("background_color"), Color.WHITE);
					chart.getPlot().setBackgroundPaint(color);
				}
			});
			
			plotColor.addActionListener(new ActionListener() {
				

				@Override
				public void actionPerformed(ActionEvent e) {
					Color color = JColorChooser.showDialog(null, lang.Res.getString("chart_color"), Color.RED);
					renderer.setPaint(color);
				}
			});
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
		
	}
}
