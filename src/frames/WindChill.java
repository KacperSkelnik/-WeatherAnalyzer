package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class WindChill extends JFrame{
	JLabel label, lTemp, lWind, lWindChill, fakeLabel;
	JTextField tTemp, tWind, tWindChill;
	JButton calculate;
	public WindChill(){
		label = new JLabel("Kalkulator temp. odczuwalnej", SwingConstants.CENTER);
		lTemp = new JLabel("Temperatura:");
		tTemp = new JTextField("");
		lWind = new JLabel("Prêdkoœæ wiatru:");
		tWind = new JTextField("");
		
		calculate = new JButton("Oblicz");
		
		lWindChill = new JLabel("Temperatura odczuwalna:");
		tWindChill = new JTextField("");
		fakeLabel = new JLabel("");
	}
}
