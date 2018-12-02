import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class gui {
	
    JFrame frame = new JFrame("Gachon Lunch Detected");
    
    private final JPanel panel = new JPanel();
    private final JPanel panel_2 = new JPanel();
    private final JLabel label_1 = new JLabel("가격");
    private final JCheckBox[] price = { new JCheckBox("5000원 이하"), new JCheckBox("10000원 이하"), new JCheckBox("난 돈이 많다")};
    private final JLabel label_2 = new JLabel("종류");
    private final JCheckBox[] kind = { new JCheckBox("한식"), new JCheckBox("중식"), new JCheckBox("일식"), new JCheckBox("양식"), new JCheckBox("기타") };
    private final JLabel label_3 = new JLabel("주재료");
    private final JCheckBox[] ingredient = { new JCheckBox("곡류"), new JCheckBox("육류"), new JCheckBox("생선"), new JCheckBox("야채"), new JCheckBox("기타") };
    private final JLabel label_4 = new JLabel("매운정도");
    private final JCheckBox[] spicy = { new JCheckBox("순함"), new JCheckBox("보통"), new JCheckBox("얼큰"), new JCheckBox("매움") };
    private final JLabel label_5 = new JLabel("온도");
    private final JCheckBox[] temper = { new JCheckBox("시원함"), new JCheckBox("미지근함"), new JCheckBox("뜨거움") };
    public static final JButton inputButton = new JButton("다음");
    private final JPanel panel_3 = new JPanel();
    
    public gui() {
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
        	GridBagLayout gbl_panel_2 = new GridBagLayout();
        	gbl_panel_2.columnWidths = new int[]{100, 120, 120, 120, 120, 120, 0};
        	gbl_panel_2.rowHeights = new int[]{40, 40, 40, 40, 40, 0, 0, 0, 0};
        	gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        	gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        	frame.getContentPane().add(panel_2, BorderLayout.CENTER);
        	panel_2.setLayout(gbl_panel_2);
        	
        	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        	gbc_lblNewLabel.gridx = 0;
        	gbc_lblNewLabel.gridy = 0;
        	panel_2.add(label_1, gbc_lblNewLabel);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
        	gbc_chckbxNewCheckBox.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox.gridx = 1;
        	gbc_chckbxNewCheckBox.gridy = 0;
        	panel_2.add(price[0], gbc_chckbxNewCheckBox);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_2 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_2.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_2.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_2.gridx = 2;
        	gbc_chckbxNewCheckBox_2.gridy = 0;
        	panel_2.add(price[1], gbc_chckbxNewCheckBox_2);
        	
        	GridBagConstraints gbc_checkBox = new GridBagConstraints();
        	gbc_checkBox.fill = GridBagConstraints.HORIZONTAL;
        	gbc_checkBox.insets = new Insets(0, 0, 5, 5);
        	gbc_checkBox.gridx = 3;
        	gbc_checkBox.gridy = 0;
        	panel_2.add(price[2], gbc_checkBox);
        	
        	GridBagConstraints gbc_label = new GridBagConstraints();
        	gbc_label.insets = new Insets(0, 0, 5, 5);
        	gbc_label.gridx = 0;
        	gbc_label.gridy = 1;
        	panel_2.add(label_2, gbc_label);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_1.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_1.gridx = 1;
        	gbc_chckbxNewCheckBox_1.gridy = 1;
        	panel_2.add(kind[0], gbc_chckbxNewCheckBox_1);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_3 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_3.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_3.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_3.gridx = 2;
        	gbc_chckbxNewCheckBox_3.gridy = 1;
        	panel_2.add(kind[1], gbc_chckbxNewCheckBox_3);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_4 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_4.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_4.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_4.gridx = 3;
        	gbc_chckbxNewCheckBox_4.gridy = 1;
        	panel_2.add(kind[2], gbc_chckbxNewCheckBox_4);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_5 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_5.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_5.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_5.gridx = 4;
        	gbc_chckbxNewCheckBox_5.gridy = 1;
        	panel_2.add(kind[3], gbc_chckbxNewCheckBox_5);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_6 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_6.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_6.insets = new Insets(0, 0, 5, 0);
        	gbc_chckbxNewCheckBox_6.gridx = 5;
        	gbc_chckbxNewCheckBox_6.gridy = 1;
        	panel_2.add(kind[4], gbc_chckbxNewCheckBox_6);
        	
        	GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        	gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        	gbc_lblNewLabel_1.gridx = 0;
        	gbc_lblNewLabel_1.gridy = 2;
        	panel_2.add(label_3, gbc_lblNewLabel_1);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_7 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_7.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_7.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_7.gridx = 1;
        	gbc_chckbxNewCheckBox_7.gridy = 2;
        	panel_2.add(ingredient[0], gbc_chckbxNewCheckBox_7);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_8 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_8.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_8.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_8.gridx = 2;
        	gbc_chckbxNewCheckBox_8.gridy = 2;
        	panel_2.add(ingredient[1], gbc_chckbxNewCheckBox_8);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_9 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_9.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_9.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_9.gridx = 3;
        	gbc_chckbxNewCheckBox_9.gridy = 2;
        	panel_2.add(ingredient[2], gbc_chckbxNewCheckBox_9);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_10 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_10.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_10.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_10.gridx = 4;
        	gbc_chckbxNewCheckBox_10.gridy = 2;
        	panel_2.add(ingredient[3], gbc_chckbxNewCheckBox_10);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_11 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_11.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_11.insets = new Insets(0, 0, 5, 0);
        	gbc_chckbxNewCheckBox_11.gridx = 5;
        	gbc_chckbxNewCheckBox_11.gridy = 2;
        	panel_2.add(ingredient[4], gbc_chckbxNewCheckBox_11);
        	
        	GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        	gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        	gbc_lblNewLabel_2.gridx = 0;
        	gbc_lblNewLabel_2.gridy = 3;
        	panel_2.add(label_4, gbc_lblNewLabel_2);
        	
        	GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
        	gbc_checkBox_1.fill = GridBagConstraints.HORIZONTAL;
        	gbc_checkBox_1.insets = new Insets(0, 0, 5, 5);
        	gbc_checkBox_1.gridx = 1;
        	gbc_checkBox_1.gridy = 3;
        	panel_2.add(spicy[0], gbc_checkBox_1);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_12 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_12.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_12.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_12.gridx = 2;
        	gbc_chckbxNewCheckBox_12.gridy = 3;
        	panel_2.add(spicy[1], gbc_chckbxNewCheckBox_12);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_13 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_13.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_13.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_13.gridx = 3;
        	gbc_chckbxNewCheckBox_13.gridy = 3;
        	panel_2.add(spicy[2], gbc_chckbxNewCheckBox_13);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_14 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_14.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_14.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_14.gridx = 4;
        	gbc_chckbxNewCheckBox_14.gridy = 3;
        	panel_2.add(spicy[3], gbc_chckbxNewCheckBox_14);
        	
        	GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        	gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        	gbc_lblNewLabel_3.gridx = 0;
        	gbc_lblNewLabel_3.gridy = 4;
        	panel_2.add(label_5, gbc_lblNewLabel_3);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_15 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_15.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_15.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_15.gridx = 1;
        	gbc_chckbxNewCheckBox_15.gridy = 4;
        	panel_2.add(temper[0], gbc_chckbxNewCheckBox_15);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_16 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_16.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_16.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_16.gridx = 2;
        	gbc_chckbxNewCheckBox_16.gridy = 4;
        	panel_2.add(temper[1], gbc_chckbxNewCheckBox_16);
        	
        	GridBagConstraints gbc_chckbxNewCheckBox_17 = new GridBagConstraints();
        	gbc_chckbxNewCheckBox_17.fill = GridBagConstraints.HORIZONTAL;
        	gbc_chckbxNewCheckBox_17.insets = new Insets(0, 0, 5, 5);
        	gbc_chckbxNewCheckBox_17.gridx = 3;
        	gbc_chckbxNewCheckBox_17.gridy = 4;
        	panel_2.add(temper[2], gbc_chckbxNewCheckBox_17);
        	
        	frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
        	panel_3.add(inputButton);
        	inputButton.setHorizontalAlignment(SwingConstants.LEFT);
        	
        	inputButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    	for (int i = 0; i < price.length; i++) {
        	    		if (price[i].isSelected() == true) {
        	    			System.out.println("price " + i + " selected");
        	    		}
        	    	}
        	    	for (int i = 0; i < kind.length; i++) {
        	    		if (kind[i].isSelected() == true) {
        	    			System.out.println("kind " + i + " selected");
        	    		}
        	    	}
        	    	for (int i = 0; i < ingredient.length; i++) {
        	    		if (ingredient[i].isSelected() == true) {
        	    			System.out.println("ingredient " + i + " selected");
        	    		}
        	    	}
        	    	for (int i = 0; i < spicy.length; i++) {
        	    		if (spicy[i].isSelected() == true) {
        	    			System.out.println("spicy " + i + " selected");
        	    		}
        	    	}
        	    	for (int i = 0; i < temper.length; i++) {
        	    		if (temper[i].isSelected() == true) {
        	    			System.out.println("temper " + i + " selected");
        	    		}
        	    	}
        	    }
        	});

        } catch(IOException e) {}
    }
    
}
