import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class run {

	public static void main(String[] args) {
		gui GUI = new gui();
		gui2 GUI2 = new gui2();
		gui3 GUI3 = new gui3();
		
        GUI.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.frame.setLocationRelativeTo(null);
        GUI.frame.setVisible(true);
        GUI2.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI2.frame.setLocationRelativeTo(null);
        GUI2.frame.setVisible(false);
        
    	gui.inputButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {	    	
    	    	GUI.frame.setVisible(false);
    	    	GUI2.frame.setLocation(GUI.frame.getLocation());
    	        GUI2.frame.setVisible(true);
    	    }
    	});
    	
    	gui2.backButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	GUI2.frame.setVisible(false);
    	    	GUI.frame.setLocation(GUI2.frame.getLocation());
    	    	GUI.frame.setVisible(true);
    	    }
    	});
    	
    	gui2.inputButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	GUI2.frame.setVisible(false);
    	    	GUI3.frame.setLocation(GUI2.frame.getLocation());
    	    	GUI3.frame.setVisible(true);
    	    }
    	});
	}

}
