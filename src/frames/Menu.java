package frames;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame implements ActionListener, Icon{
	JMenuBar menuBar;
	JMenu menuMenu, menuLanguage;
	JMenuItem mPolish,mEnglish,mTemp,mRainfall,mHumidity,mPressureWeather;
	ImageIcon englishFlag, polishFalg;
	public Menu(){
		createMenuBar();
	}
	
	private ActionListener plotWindow(String name) {
		ActionListener windowListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			PlotFrame frame1 = new PlotFrame(name);
			frame1.setVisible(true);
		}
	};
	return windowListener;
	}
	
	public JMenuBar createMenuBar() {		
		menuBar = new JMenuBar();
	 	menuMenu = new JMenu("Opcje");
	 	mTemp = new JMenuItem("Wykres temperatury");
	 	mTemp.addActionListener(plotWindow("Temperature Plot"));
	 	mRainfall = new JMenuItem("Wykres opad�w");
	 	mRainfall.addActionListener(plotWindow("Rain Fall Plot"));
	 	mHumidity = new JMenuItem("Wykres wilgotno�ci");
	 	mHumidity.addActionListener(plotWindow("Humidity Plot"));
	 	mPressureWeather = new JMenuItem("Wykres ci�nienia atmosferycznego");
	 	mPressureWeather.addActionListener(plotWindow("Pressure Plot"));
	 	menuMenu.add(mTemp);
	 	menuMenu.add(mRainfall);
	 	menuMenu.add(mHumidity);
	 	menuMenu.add(mPressureWeather);
	 	
	 	menuLanguage = new JMenu("J�zyk");
	 	mPolish = new JMenuItem("Polski");
	 	Image polishFlag = new ImageIcon(this.getClass().getResource("/pf.png")).getImage();
	 	mPolish.setIcon(new ImageIcon(polishFlag));
	 	mEnglish = new JMenuItem("English");
	 	Image britishFlag = new ImageIcon(this.getClass().getResource("/ef.png")).getImage();
	 	mEnglish.setIcon(new ImageIcon(britishFlag));
	 	menuLanguage.add(mPolish);
	 	menuLanguage.add(mEnglish);
	 	menuBar.add(menuMenu);
	 	menuBar.add(menuLanguage);
	 	
	 	
	 	
		return menuBar;
	}
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void paintIcon(Component arg0, Graphics arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
