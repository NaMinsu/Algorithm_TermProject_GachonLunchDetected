import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class gui3 {
	
    JFrame frame = new JFrame("Gachon Lunch Detected");
    
    private final JPanel panel = new JPanel();
    private final JPanel panel_1 = new JPanel();
    
    private JTable table;
    
    public gui3() {
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setSize(700, 450);
    	
        try {
        	panel.setPreferredSize(new Dimension(768, 160));
        	BufferedImage myPicture = ImageIO.read(new File("Logo.PNG"));
        	Image logo = myPicture.getScaledInstance(450, 150, BufferedImage.SCALE_SMOOTH);
        	frame.getContentPane().add(panel, BorderLayout.NORTH);
        	panel.setBackground(Color.WHITE);
        	panel.setForeground(Color.WHITE);
        	JLabel picLabel = new JLabel(new ImageIcon(logo));
        	panel.add(picLabel);
        	
        	frame.getContentPane().add(panel_1, BorderLayout.CENTER);
        	panel_1.setLayout(null);
        	
        	JLabel lblNewLabel = new JLabel("\uC74C\uC2DD\uCD94\uCC9C");
        	lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        	lblNewLabel.setBounds(12, 10, 76, 15);
        	panel_1.add(lblNewLabel);
        	
        	JScrollPane scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 35, 546, 150);
        	panel_1.add(scrollPane);
        	
        	table = new JTable();
        	scrollPane.setViewportView(table);
        	table.setFont(new Font("굴림", Font.PLAIN, 12));
        	table.setFillsViewportHeight(true);
        	table.setModel(new DefaultTableModel(
        		new Object[][] {
        			{"밥", "어딘가", 99999, 1000},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        		},
        		new String[] {
        			"\uC74C\uC2DD\uBA85", "\uC704\uCE58", "\uAC00\uACA9", "\uCE7C\uB85C\uB9AC"
        		}
        	));
        	table.setRowHeight(25);
        	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        	table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        	table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        	table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        	table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        	table.setEnabled(false);
        	
        	JButton button1 = new JButton("지도 보기");
        	button1.setBounds(570, 60, 97, 23);
        	panel_1.add(button1);
        	
        	JButton button2 = new JButton("지도 보기");
        	button2.setBounds(570, 85, 97, 23);
        	panel_1.add(button2);
        	
        	JButton button3 = new JButton("지도 보기");
        	button3.setBounds(570, 110, 97, 23);
        	panel_1.add(button3);
        	
        	JButton button4 = new JButton("지도 보기");
        	button4.setBounds(570, 135, 97, 23);
        	panel_1.add(button4);
        	
        	JButton button5 = new JButton("지도 보기");
        	button5.setBounds(570, 160, 97, 23);
        	panel_1.add(button5);
        	

        } catch(IOException e) {}
    }
   
	public static void main(String[] args) {
		gui3 GUI3 = new gui3();
        GUI3.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI3.frame.setVisible(true);
	}
}
