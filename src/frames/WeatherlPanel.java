package frames; //Kacper Skelnik

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class WeatherlPanel extends JPanel{
	
	JLabel lTemp,lWindChill,lWind, lVisibility, lHumidity, lPressureWeather;
	JTextField tTemp, tWindChill,tWind, tVisibility, tHumidity, tPressureWeather;
	final String degree  = "\u00b0";
	boolean running = true;
	
	public WeatherlPanel() throws Exception{
		
		Language language = new Language();
		WeatherYdnJava weatherDate = new WeatherYdnJava();
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(320, 480));
		Border border = BorderFactory.createMatteBorder(3, 6, 0, 3, Color.BLACK);
		this.setBorder(border);
		
		JLabel label = new JLabel(language.Res.getString("weather_data"), SwingConstants.CENTER);
		JLabel fakeLabel = new JLabel("");
		lTemp = new JLabel(language.Res.getString("temperature"), SwingConstants.CENTER);
	 	tTemp = new JTextField(weatherDate.Temp + " " + degree+"C");
	 	tTemp.setEditable(false);
	 	lWindChill = new JLabel(language.Res.getString("windchill"), SwingConstants.CENTER);
	 	tWindChill = new JTextField(weatherDate.WindChill + " " + degree+"C");
	 	tWindChill.setEditable(false);
	 	lWind = new JLabel(language.Res.getString("wind_velocity"), SwingConstants.CENTER);
	 	tWind = new JTextField(weatherDate.Wind + " " + "km/h");
	 	tWind.setEditable(false);
	 	lPressureWeather = new JLabel(language.Res.getString("atmospheric_pressure"), SwingConstants.CENTER);
	 	tPressureWeather = new JTextField(weatherDate.PressureWeather + " " + "hPa");
	 	tPressureWeather.setEditable(false);
	 	lVisibility = new JLabel(language.Res.getString("visibility"), SwingConstants.CENTER);
	 	tVisibility = new JTextField(weatherDate.Visibility + " " + "km");
	 	tVisibility.setEditable(false);
	 	lHumidity = new JLabel(language.Res.getString("humidity"), SwingConstants.CENTER);
	 	tHumidity = new JTextField(weatherDate.Humidity + " " + "%");
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
	 	this.add(lVisibility);
	 	this.add(tVisibility);
	 	this.add(lHumidity);
	 	this.add(tHumidity);
	}
}
