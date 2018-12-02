import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.util.HashMap;

public class map {
    private JFrame frame = new JFrame("Campus Map");
    private JLayeredPane lpane = new JLayeredPane();
    private JPanel panel1 = new MyPanel("campus_map.png");
    private JPanel panel2 = new JPanel();
    
    public static HashMap<String, Integer[]> loc = new HashMap<String, Integer[]>();
    public static String[] navigator = {"dormitory", "student union", "library"};
    
    public map()
    {
    	addLocation();
        frame.setPreferredSize(new Dimension(884, 884));
        frame.setLayout(new BorderLayout());
        frame.add(lpane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lpane.setBounds(0, 0, 867, 845);
        panel1.setBounds(0, 0, 867, 845);
        panel1.setOpaque(true);
//      panel2.add(linedraw1);
        panel2.setBounds(200, 100, 100, 100);
        panel2.setOpaque(false);
        lpane.add(panel1, new Integer(0), 0);
        lpane.add(panel2, new Integer(1), 0);
        frame.pack();
        frame.setVisible(true);
    }

    public void addLocation() {
        loc.put("dormitory", new Integer[] {700, 60});
        loc.put("student union", new Integer[] {617, 357});
        loc.put("library", new Integer[] {520, 420});

    }
    // This is your custom panel
    class MyPanel extends JPanel {
        private static final long serialVersionUID = -4559408638276405147L;
        private String imageFile;

        public MyPanel(String imageFile) {
            this.imageFile = imageFile;
        }
        @Override
        protected void paintComponent(Graphics g) {
        	
            // Add your image here
            Image img = new ImageIcon(imageFile).getImage();
            g.drawImage(img, 0, 0, this);
            Graphics2D g2 = (Graphics2D) g;
            //Add your lines here
            g.setColor(Color.black);
            //g.drawLine(0, 0, g.getClipBounds().width, g.getClipBounds().height);
            g.setColor(Color.red);
            g2.setStroke(new BasicStroke(5));
            
            for (int i = 0; i < navigator.length - 1; i++) {
                Integer[] temp = loc.get(navigator[i]);
                Integer[] temp2 = loc.get(navigator[i + 1]);
                g2.drawLine(temp[0], temp[1], temp2[0], temp2[1]);
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new map();	
    }

}