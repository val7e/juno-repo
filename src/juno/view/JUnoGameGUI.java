package juno.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JUnoGameGUI extends JFrame {
    private JPanel gamePanel;
    private JButton drawButton;
    private JButton playButton;
    private JLabel statusLabel;
    
    public JUnoGameGUI() {
        super("Uno Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize the components
        gamePanel = new JPanel();
        drawButton = new JButton("Draw Card");
        playButton = new JButton("Play Card");
        statusLabel = new JLabel("Welcome to Uno!");
        
        // Add the components to the frame
        add(gamePanel);
        gamePanel.add(drawButton);
        gamePanel.add(playButton);
        gamePanel.add(statusLabel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        JUnoGameGUI gui = new JUnoGameGUI();
    }
}
