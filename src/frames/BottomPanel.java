package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class BottomPanel extends JPanel {

	public BottomPanel() {
		this.setLayout(new GridLayout(1,5));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		
		//Label with shoes advice
		JLabel shoes_lab = new JLabel("Shoes advice", SwingConstants.CENTER);
		shoes_lab.setPreferredSize(new Dimension(160, 120));
		shoes_lab.setBorder(border);
		this.add(shoes_lab);
		
		//Label with hat advice
		JLabel hats_lab = new JLabel("Hats advice", SwingConstants.CENTER);
		hats_lab.setPreferredSize(new Dimension(160, 120));
		hats_lab.setBorder(border);
		this.add(hats_lab);
		
		//Label with clothes advice
		JLabel cloth_lab = new JLabel("Clothes advice", SwingConstants.CENTER);
		cloth_lab.setPreferredSize(new Dimension(160, 120));
		cloth_lab.setBorder(border);
		this.add(cloth_lab);
		
		//Label with accessories advice 
		JLabel acs_lab = new JLabel("Accessories advice", SwingConstants.CENTER);
		acs_lab.setPreferredSize(new Dimension(160, 120));
		acs_lab.setBorder(border);
		this.add(acs_lab);
	}


}
