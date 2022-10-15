import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class show_picture {
    private int url = 0;
    public class MyPanel extends Panel{
        private final Image screenImage = new BufferedImage(1600, 900, 2);
        private final Graphics2D screenGraphic = (Graphics2D) screenImage.getGraphics();
        private Image backgroundImage;
        public MyPanel() {
            loadImage();
            setFocusable(true);
            setPreferredSize(new Dimension(1600,900));
            drawView();
        }
        private void loadImage() {
            ImageIcon icon = new ImageIcon("_img\\"+url+".jpg");
            backgroundImage = icon.getImage();
        }
        private void drawView() {
            screenGraphic.drawImage(backgroundImage, 0, 0, null);
        }
        public void paint(Graphics g) {
            g.drawImage(screenImage, 0, 0, null);
        }

    }
    public class MyFrame extends Frame{
        public MyFrame() {
            this.setTitle("结构展示");
            this.setLocation(150,50);
            MyPanel panel = new MyPanel();
            this.add(panel);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            this.pack();
            this.setVisible(true);
        }

    }
    public void foo(int x) {
        url = x;
        Frame frame=new MyFrame();
    }
}
