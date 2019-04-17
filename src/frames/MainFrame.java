package frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	//To jest testowy komentarz
	//lalala dupa
	public MainFrame() throws HeadlessException {
		this.setSize(640,640);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		Image icon = new ImageIcon(this.getClass().getResource("/mainIcon.png")).getImage();
		this.setIconImage(new ImageIcon(icon).getImage());
		this.setTitle("Weather Analyzer");
		
		//Menu
		Menu menu = new Menu();
		this.setJMenuBar(menu.createMenuBar());
		
		//bottom panel
		BottomPanel panelB = new BottomPanel();
		this.add(panelB, BorderLayout.PAGE_END);
	
		//WeatherlPanel
		WeatherlPanel panelC = new WeatherlPanel();
		panelC.setLayout(new GridLayout(7,2));
		this.add(panelC, BorderLayout.LINE_END);
		
		//WindChill
		WindChill panelW = new WindChill();
		this.add(panelW.label);
			panelW.label.setBounds(50, 25, 200, 20);
		this.add(panelW.lTemp);
			panelW.lTemp.setBounds(20, 100, 100, 20);
		this.add(panelW.tTemp);
			panelW.tTemp.setBounds(130, 100, 160, 20);
		this.add(panelW.lWind);
			panelW.lWind.setBounds(20, 150, 100, 20);
		this.add(panelW.tWind);
			panelW.tWind.setBounds(130, 150, 160, 20);
		this.add(panelW.calculate);
			panelW.calculate.setBounds(115, 200, 80, 20);
		this.add(panelW.lWindChill);
			panelW.lWindChill.setBounds(20, 250, 150, 20);
		this.add(panelW.tWindChill);
			panelW.tWindChill.setBounds(180, 250, 110, 20);
		this.add(panelW.fakeLabel);
		

	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

}
