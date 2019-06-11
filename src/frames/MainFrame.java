package frames; //Kacper Skelnik Wojtek Tyczyñski

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements Runnable{
		
		ArrayList<BottomPanel> bottomArrli = new ArrayList<BottomPanel>(1);
		ArrayList<WeatherlPanel> weatherlArrli = new ArrayList<WeatherlPanel>(1);
		static MainFrame frame;
		static ExecutorService exec;
		private Boolean stop = false;
	
	public MainFrame() throws Exception {
		
		Language language = new Language();
		
        WindowListener exitListener = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(frame,
                        language.Res.getString("exit"),
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                switch (confirm) {
                case JOptionPane.YES_OPTION:
                    System.exit(1);
                    break;
                     
                case JOptionPane.NO_OPTION:
                    break;
            }
            }
        };
        this.addWindowListener(exitListener);
        
		this.setSize(640,640);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		Image icon = new ImageIcon(this.getClass().getResource("/mainIcon.png")).getImage();
		this.setIconImage(new ImageIcon(icon).getImage());
		this.setTitle("Weather Analyzer");
		
		//Menusadasd
		Menu menu = new Menu();
		this.setJMenuBar(menu.createMenuBar());
		
		//bottom panel
		BottomPanel	panelB = new BottomPanel();
		bottomArrli.add(panelB);
		this.add(panelB, BorderLayout.PAGE_END);
	
		//WeatherlPanel
		WeatherlPanel panelC = new WeatherlPanel();
		weatherlArrli.add(panelC);
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
	
	public static void main(String[] args) throws Exception { //Kacper Skelnik
		frame = new MainFrame();
		frame.setVisible(true);
		
		exec = Executors.newFixedThreadPool(1);
		exec.execute(frame);
		exec.shutdown();
	}	

	@Override
	public void run() { //Kacper Skelnik
		
		while(!stop) {
		try {

			BottomPanel	panelB = new BottomPanel();
			this.remove(bottomArrli.get(0));
			bottomArrli.remove(0);
			bottomArrli.add(0,panelB);
			this.add(bottomArrli.get(0),  BorderLayout.PAGE_END);
			
			WeatherlPanel panelC = new WeatherlPanel();
			this.remove(weatherlArrli.get(0));
			weatherlArrli.remove(0);
			weatherlArrli.add(0,panelC);
			weatherlArrli.get(0).setLayout(new GridLayout(7,2));
			this.add(weatherlArrli.get(0), BorderLayout.LINE_END);
			
			this.revalidate();
			this.repaint();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(1000); //minute
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static void stop() { //Kacper Skelnik
        frame.stop = true;
    }
}
