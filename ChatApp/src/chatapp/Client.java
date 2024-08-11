package chatapp;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class Client implements ActionListener {
    
    JTextField text;
    static JPanel a1;
    static Box vertical = Box.createVerticalBox();
    
    static JFrame f = new JFrame();
    
    static DataOutputStream dout;
    static DataInputStream din;
    static Socket s;

    Client() {
        f.setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.darkGray);
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);
        
        JLabel back = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("chatapp/icons/3.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
        back.setBounds(5, 20, 25, 25);
        p1.add(back);
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        JLabel profile = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("chatapp/icons/2.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);

        JLabel video = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("chatapp/icons/video.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        video.setBounds(300, 20, 30, 30);
        p1.add(video);

        JLabel phone = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("chatapp/icons/phone.png")).getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT)));
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone);

        JLabel morevert = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("chatapp/icons/3icon.png")).getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT)));
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert);

        JLabel name = new JLabel("Client");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);
        
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        f.add(a1);
        
        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);
        
        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);
        
        f.setSize(450, 700);
        f.setLocation(800, 50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);
        
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String out = text.getText();
            dout.writeUTF(out);

            JPanel p2 = formatLabel(out);
            a1.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            a1.add(vertical, BorderLayout.PAGE_START);

            text.setText("");

            f.repaint();
            f.invalidate();
            f.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        
        panel.add(output);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        return panel;
    }
    
    public static void main(String[] args) {
        new Client();
        
        try {
            s = new Socket("127.0.0.1", 6001);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            new Thread(new ReceiveMessage()).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ReceiveMessage extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg);

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
