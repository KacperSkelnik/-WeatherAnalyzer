package frames;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class WeatherlPanel extends JPanel {
	
	JLabel lTemp,lWindChill,lWind, lRainfall, lHumidity, lPressureWeather;
	JTextField tTemp, tWindChill,tWind, tRainfall, tHumidity, tPressureWeather;
	final String degree  = "\u00b0";
	
	public WeatherlPanel() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(320, 480));
		Border border = BorderFactory.createMatteBorder(3, 6, 0, 3, Color.BLACK);
		this.setBorder(border);
		
		JLabel label = new JLabel("Dane pogodowe: ", SwingConstants.CENTER);
		JLabel fakeLabel = new JLabel("");
		lTemp = new JLabel("Temperatura: ", SwingConstants.CENTER);
	 	tTemp = new JTextField(degree+"C");
	 	tTemp.setEditable(false);
	 	lWindChill = new JLabel("Temp. odczuwalna : ", SwingConstants.CENTER);
	 	tWindChill = new JTextField(degree+"C");
	 	tWindChill.setEditable(false);
	 	lWind = new JLabel("Prêdkoœæ wiatru : ", SwingConstants.CENTER);
	 	tWind = new JTextField("m/s");
	 	tWind.setEditable(false);
	 	lPressureWeather = new JLabel("Ciœnienie atmosferyczne: ", SwingConstants.CENTER);
	 	tPressureWeather = new JTextField("hPa");
	 	tPressureWeather.setEditable(false);
	 	lRainfall = new JLabel("Opad deszczu: ", SwingConstants.CENTER);
	 	tRainfall = new JTextField("l/m^2");
	 	tRainfall.setEditable(false);
	 	lHumidity = new JLabel("Wilgotnoœæ: ", SwingConstants.CENTER);
	 	tHumidity = new JTextField("%");
	 	tHumidity.setEditable(false);
	 	
	 	this.add(label);
	 	this.add(fakeLabel);
	 	this.add(lTemp);
	 	this.add(tTemp);
		this.add(lWindChill);
	 	this.add(tWindChill);
	 	this.add(lWind);
	 	this.add(tWind);
	 	this.add(lPressureWeather);
	 	this.add(tPressureWeather);
	 	this.add(lRainfall);
	 	this.add(tRainfall);
	 	this.add(lHumidity);
	 	this.add(tHumidity);
	}
}
