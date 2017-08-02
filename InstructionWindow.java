package project;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Component;

public class InstructionWindow extends JFrame implements ActionListener{
	private int nPlayers;
	private JButton confirm;
	private JPanel pane;
	private JLabel header;
	private JFrame frame;
	
	public InstructionWindow(int nPlayers) {
		this.nPlayers = nPlayers;
		frame = new JFrame();
		pane = new JPanel();
		pane.setLayout(null);
		confirm = new JButton();
		confirm.setText("Ok");
		confirm.setBounds(161, 293, 105, 29);
		confirm.addActionListener(this);
		pane.add(confirm);
		
		header = new JLabel("Use these keys to buzz in:");
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 20));
		header.setBounds(59, 0, 310, 70);
		pane.add(header);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBounds(52, 76, 135, 184);
		labelPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(239, 76, 135, 184);
		imagePanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		if(this.nPlayers == 1){
			JLabel player1Label = new JLabel("Players 1: ");
			player1Label.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel zLabel = new JLabel(new ImageIcon(getClass().getResource("letterZ.png")));
			zLabel.setHorizontalAlignment(SwingConstants.LEFT);
			labelPanel.add(player1Label);
			imagePanel.add(zLabel);
		}
		
		if(this.nPlayers == 2){
			JLabel player1Label = new JLabel("Players 1: ");
			player1Label.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel zLabel = new JLabel(new ImageIcon(getClass().getResource("letterZ.png")));
			zLabel.setHorizontalAlignment(SwingConstants.LEFT);
			JLabel player2Label = new JLabel("Players 2: ");
			player2Label.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel mLabel = new JLabel(new ImageIcon(getClass().getResource("letterM.png")));
			mLabel.setHorizontalAlignment(SwingConstants.LEFT);
			labelPanel.add(player1Label);
			labelPanel.add(player2Label);
			imagePanel.add(zLabel);
			imagePanel.add(mLabel);
		}
		
		if(this.nPlayers == 3){
			JLabel player1Label = new JLabel("Player 1: ");
			player1Label.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel zLabel = new JLabel(new ImageIcon(getClass().getResource("letterZ.png")));
			zLabel.setHorizontalAlignment(SwingConstants.LEFT);
			JLabel player2Label = new JLabel("Player 2: ");
			player2Label.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel mLabel = new JLabel(new ImageIcon(getClass().getResource("letterM.png")));
			mLabel.setHorizontalAlignment(SwingConstants.LEFT);
			JLabel player3Label = new JLabel("Player 3: ");
			player3Label.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel qLabel = new JLabel(new ImageIcon(getClass().getResource("letterQ.png")));
			qLabel.setHorizontalAlignment(SwingConstants.LEFT);
			labelPanel.add(player1Label);
			labelPanel.add(player2Label);
			labelPanel.add(player3Label);
			imagePanel.add(zLabel);
			imagePanel.add(mLabel);
			imagePanel.add(qLabel);
		}
		
		pane.add(labelPanel);
		pane.add(imagePanel);
		frame.setPreferredSize(new Dimension(450, 400));
		frame.setBounds(100,100,450,400);
		frame.getContentPane().add(pane);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==confirm){
			frame.setVisible(false);
		}
	}
}
