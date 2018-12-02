import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class gui2 {
	
    JFrame frame = new JFrame("Gachon Lunch Detected");
    
    private final JPanel panel = new JPanel();
    private final JPanel panel_2 = new JPanel();
    private final JPanel panel_3 = new JPanel();
    private JTextField height;
    private JTextField active;
    private final JLabel tip_1 = new JLabel("활동량 적음 25");
    private final JLabel tip_2 = new JLabel("활동량 보통 30~35");
    private final JLabel lblNewLabel = new JLabel("활동량 많음 40");
    private final JTextField result = new JTextField();
    private final JLabel label_3 = new JLabel("Kcal");
    public static final JButton backButton = new JButton("이전");
    public static final JButton inputButton = new JButton("확인");
    private JComboBox locList;
    public static String curLoc = "기숙사";
    
    public gui2() {
    	result.setHorizontalAlignment(SwingConstants.RIGHT);
    	result.setBounds(302, 187, 80, 21);
    	result.setColumns(10);
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
        	frame.getContentPane().add(panel_2, BorderLayout.CENTER);
        	panel_2.setLayout(null);
        	
        	JRadioButton radioButton_1 = new JRadioButton("일일 권장 칼로리");
        	radioButton_1.setBounds(8, 6, 140, 23);
        	radioButton_1.setSelected(true);
        	panel_2.add(radioButton_1);
        	
        	
        	JRadioButton radioButton_2 = new JRadioButton("\uCE7C\uB85C\uB9AC \uC2E0\uACBD \uC548 \uC500");
        	radioButton_2.setBounds(292, 6, 150, 23);
        	panel_2.add(radioButton_2);
        	
        	ButtonGroup group = new ButtonGroup();
        	group.add(radioButton_1);
        	group.add(radioButton_2);
        	
        	JLabel lblcm = new JLabel("키(cm)");
        	lblcm.setHorizontalAlignment(SwingConstants.CENTER);
        	lblcm.setBounds(18, 35, 57, 15);
        	panel_2.add(lblcm);
        	
        	height = new JTextField();
        	height.setBounds(86, 32, 116, 21);
        	panel_2.add(height);
        	height.setColumns(10);
        	
        	JLabel label_2 = new JLabel("활동량");
        	label_2.setHorizontalAlignment(SwingConstants.CENTER);
        	label_2.setBounds(18, 73, 57, 15);
        	panel_2.add(label_2);
        	
        	active = new JTextField();
        	active.setBounds(86, 70, 116, 21);
        	panel_2.add(active);
        	active.setColumns(10);
        	tip_1.setBounds(86, 101, 120, 15);
        	
        	panel_2.add(tip_1);
        	tip_2.setBounds(86, 126, 120, 15);
        	
        	panel_2.add(tip_2);
        	lblNewLabel.setBounds(86, 151, 120, 15);
        	
        	panel_2.add(lblNewLabel);
        	
        	panel_2.add(result);
        	label_3.setBounds(385, 190, 57, 15);
        	
        	panel_2.add(label_3);
        	
        	JButton calcButton = new JButton("계산");
        	calcButton.setBounds(86, 186, 97, 23);
        	panel_2.add(calcButton);
        	
        	JLabel label_4 = new JLabel("현재 위치");
        	label_4.setBounds(540, 73, 57, 15);
        	panel_2.add(label_4);
        	
        	locList = new JComboBox();
        	locList.setForeground(Color.BLACK);
        	locList.setBackground(Color.WHITE);
        	locList.setMaximumRowCount(6);
        	locList.setModel(new DefaultComboBoxModel(new String[] {"기숙사", "학생회관", "중앙 도서관", "교육 대학", "대학원", "가천관", "바이오나노 대학"}));
        	locList.setBounds(495, 98, 140, 21);
        	panel_2.add(locList);
        	
        	
        	
        	frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
        	
        	panel_3.add(backButton);
        	panel_3.add(inputButton);
        	inputButton.setHorizontalAlignment(SwingConstants.LEFT);
        	

        	radioButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    	height.setEnabled(true);
        	    	active.setEnabled(true);
        	    	result.setEnabled(true);
        	    	calcButton.setEnabled(true);
        	    }
        	});
        	radioButton_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    	height.setEnabled(false);
        	    	active.setEnabled(false);
        	    	result.setEnabled(false);
        	    	calcButton.setEnabled(false);
        	    }
        	});
        	
        	calcButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    	double h = Double.parseDouble(height.getText());
        	    	double a = Double.parseDouble(active.getText());
        	    	int i = (int)((h - 100) * 0.9 * a);
        	    	result.setText(String.valueOf(i));
        	    }
        	});
        	
        	inputButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			if (radioButton_1.isSelected()) {
        				System.out.println(result.getText());
        			}
        			else
        				System.out.println(-1);
            		
                    System.out.println(curLoc);
        		}

        	});
        	
            locList.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JComboBox<String> cb = (JComboBox<String>)e.getSource();
                    curLoc = (String) cb.getSelectedItem();
                }
            });
        } catch(IOException e) {}
    }
}
