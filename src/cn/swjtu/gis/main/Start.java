package cn.swjtu.gis.main;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Foutas on 2017/6/8.
 */
//public class Start extends Applet{
//
//    private Image image;
//    private JPanel jPanel;
//    private JButton jButton;
//
//    public void init() {
//        jPanel = new JPanel(new BorderLayout());
//
//        try{
//            ImageIcon icon = new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\1.jpg");
//            image = icon.getImage();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        add(jPanel);
//        setSize(800, 800);
//        setVisible(true);
//    }
//
//    public void paint(Graphics graphics) {
//        graphics.drawImage(image, 0, 0, this);
//    }
//
//}


public class Start extends JFrame{
    public Start() {
        setTitle("GIS展示");
        Container container = getContentPane();
        JButton jButton = new JButton("显示地图");
        container.add(BorderLayout.SOUTH, jButton);
        ImageIcon icon = new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\1.jpg");
        JLabel jLabel = new JLabel(icon);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jLabel);
        jButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        Start start = new Start();
        start.show();
    }

}
