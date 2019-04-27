package frames;

import java.awt.RenderingHints;
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
		
		label = new JLabel("Kalkulator temp. odczuwalnej", SwingConstants.CENTER);
		lTemp = new JLabel("Temperatura:");
		tTemp = new JTextField("0");
		lWind = new JLabel("Prêdkoœæ wiatru:");
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
		calculate = new JButton("Oblicz");
		calculate.addActionListener(buttonListener);
		
		lWindChill = new JLabel("Temperatura odczuwalna:");
		tWindChill = new JTextField(String.valueOf(windChill));
		fakeLabel = new JLabel("");
	}
}
