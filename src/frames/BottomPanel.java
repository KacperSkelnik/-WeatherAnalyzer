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

	public BottomPanel() throws Exception {
		this.setLayout(new GridLayout(1,5));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		
		OutfitGuide outfitGuide = new OutfitGuide();
		
		//Label with shoes advice
		JLabel shoes_lab = new JLabel(outfitGuide.shoes, SwingConstants.CENTER);
		shoes_lab.setPreferredSize(new Dimension(160, 120));
		shoes_lab.setBorder(border);
		this.add(shoes_lab);
		
		//Label with hat advice
		JLabel hats_lab = new JLabel(outfitGuide.hat, SwingConstants.CENTER);
		hats_lab.setPreferredSize(new Dimension(160, 120));
		hats_lab.setBorder(border);
		this.add(hats_lab);
		
		//Label with clothes advice
		JLabel cloth_lab = new JLabel(outfitGuide.clothes, SwingConstants.CENTER);
		cloth_lab.setPreferredSize(new Dimension(160, 120));
		cloth_lab.setBorder(border);
		this.add(cloth_lab);
		
		//Label with accessories advice 
		JLabel acs_lab = new JLabel(outfitGuide.accessories, SwingConstants.CENTER);
		acs_lab.setPreferredSize(new Dimension(160, 120));
		acs_lab.setBorder(border);
		this.add(acs_lab);
	}

}
