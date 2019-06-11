package frames; //Kacper Skelnik

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class WindChill extends JFrame{
	JLabel label, lTemp, lWind, lWindChill, fakeLabel;
	JTextField tTemp, tWind, tWindChill;
	JButton calculate;
	double windChill = 0;
	double windSpeed = 0;
	double temp = 0;
	public WindChill() throws Exception{
		
		Language language = new Language();
		
		label = new JLabel(language.Res.getString("windchill_calculator"), SwingConstants.CENTER);
		lTemp = new JLabel(language.Res.getString("temperature"));
		tTemp = new JTextField("0");
		lWind = new JLabel(language.Res.getString("wind_velocity"));
		tWind = new JTextField("0");
		
		ActionListener buttonListener = new ActionListener() {
	 		@Override
	 		public void actionPerformed(ActionEvent arg0) {
	 			temp = Double.parseDouble(tTemp.getText());
	 			windSpeed = Double.parseDouble(tWind.getText());
	 			
	 			windChill = 13.12 + 0.6215*temp - 11.37*Math.pow(windSpeed, 0.16) + 0.3965*temp*Math.pow(windSpeed, 0.16);
	 			
	 			tWindChill.setText(String.format ("%.2f",windChill));
	 		}	
	 	};
		calculate = new JButton(language.Res.getString("calculate"));
		calculate.addActionListener(buttonListener);
		
		lWindChill = new JLabel(language.Res.getString("windchill"));
		tWindChill = new JTextField(String.valueOf(windChill));
		fakeLabel = new JLabel("");
	}
}
