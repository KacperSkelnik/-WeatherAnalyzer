package frames;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame implements ActionListener, Icon{
	
	Language lang = new Language();
	
	JMenuBar menuBar;
	JMenu menuMenu, menuLanguage;
	JMenuItem mPolish,mEnglish,mTemp,mRainfall,mHumidity,mPressureWeather;
	ImageIcon englishFlag, polishFalg;
	public Menu(){
		createMenuBar();
	}
	
	private ActionListener plotWindow(String name, String query, String x_plot, String y_plot) {
		ActionListener windowListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			PlotFrame frame1 = new PlotFrame(name, query, x_plot, y_plot);
			frame1.setVisible(true);
		}
	};
	return windowListener;
	}
	
	private ActionListener setLanguage(String language, String country) {
		ActionListener LanguageListener = new ActionListener() {
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
				
				lang.locale.setDefault(new Locale(language,country));
				MainFrame.frame.setVisible(false);
				MainFrame.stop();
			try {
				MainFrame.main(new String[]{});
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};
	return LanguageListener;
	}
	
	
	public JMenuBar createMenuBar() {		
		menuBar = new JMenuBar();
	 	menuMenu = new JMenu(lang.Res.getString("options"));
	 	mTemp = new JMenuItem(lang.Res.getString("temperature_chart"));
	 	mTemp.addActionListener(plotWindow("Temperature Plot", "SELECT Date,Temp FROM Weather_Data","Date","Temperature [°C]"));
	 	mRainfall = new JMenuItem(lang.Res.getString("rainfall_chart"));
	 	mRainfall.addActionListener(plotWindow("Rain Fall Plot", "SELECT Date,Rain FROM Weather_Data","Date","Rain [mm]"));
	 	mHumidity = new JMenuItem(lang.Res.getString("humidity_chart"));
	 	mHumidity.addActionListener(plotWindow("Humidity Plot", "SELECT Date,Humidity FROM Weather_Data","Date","Humidity [%]"));
	 	mPressureWeather = new JMenuItem(lang.Res.getString("atmospheric_pressure_chart"));
	 	mPressureWeather.addActionListener(plotWindow("Pressure Plot", "SELECT Date,Press FROM Weather_Data","Date","Pressure [hPa]"));
	 	menuMenu.add(mTemp);
	 	menuMenu.add(mRainfall);
	 	menuMenu.add(mHumidity);
	 	menuMenu.add(mPressureWeather);
	 	
	 	menuLanguage = new JMenu(lang.Res.getString("language"));
	 	mPolish = new JMenuItem("Polski");
	 	Image polishFlag = new ImageIcon(this.getClass().getResource("/pf.png")).getImage();
	 	mPolish.setIcon(new ImageIcon(polishFlag));
	 	mPolish.addActionListener(setLanguage("pl", "PL"));
	 	mEnglish = new JMenuItem("English");
	 	Image britishFlag = new ImageIcon(this.getClass().getResource("/ef.png")).getImage();
	 	mEnglish.setIcon(new ImageIcon(britishFlag));
	 	mEnglish.addActionListener(setLanguage("en", "GB"));
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
