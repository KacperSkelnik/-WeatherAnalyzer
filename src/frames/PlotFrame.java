package frames;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
	}
}
