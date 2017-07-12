import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class TriviaGui extends JFrame implements ActionListener{

	//This is a change
	private JFrame startupFrame;
	private JPanel gridPanel;
	private JPanel scorePanel;
	private JPanel buttonPanel;
	private JButton[][] gridButtons;
	private JButton quit, reset, newGame;
	private JLabel[] genreLabels;
	private GridLayout layout;
	private int player1, player2, player3;
	
	public TriviaGui() {
		startupFrame = new JFrame("Trivia Game");
		player1 = 0;
		player2 = 0;
		player3 = 0;
		gridPanel = new JPanel();
		scorePanel = scorePanel();
		buttonPanel = buttonPanel();
		final int gridSize = 5;
		Font labelFont = new Font("Tahoma", Font.BOLD, 26);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		layout = new GridLayout(gridSize,gridSize);
		genreLabels = new JLabel[gridSize];
		gridButtons = new JButton[4][5];
		
		genreLabels[0] = new JLabel("Comedy", SwingConstants.CENTER);
		genreLabels[1] = new JLabel("Superhero", SwingConstants.CENTER);
		genreLabels[2] = new JLabel("Action", SwingConstants.CENTER);
		genreLabels[3] = new JLabel("Romance", SwingConstants.CENTER);
		genreLabels[4] = new JLabel("Sci-Fi", SwingConstants.CENTER);
		
		for(int col = 0; col < 5; col++) {
			genreLabels[col].setFont(labelFont);
			genreLabels[col].setBorder(blackLine);
			genreLabels[col].setOpaque(true);
			genreLabels[col].setBackground(new JButton().getBackground());
			gridPanel.add(genreLabels[col]);
		}
		
		for(int col = 0; col < 5; col++) {
			gridButtons[0][col] = new JButton("100");
		}
		for(int col = 0; col < 5; col++) {
			gridButtons[1][col] = new JButton("200");
		}
		for(int col = 0; col < 5; col++) {
			gridButtons[2][col] = new JButton("300");
		}
		for(int col = 0; col < 5; col++) {
			gridButtons[3][col] = new JButton("400");
		}
		
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 5; col++) {
				gridPanel.add(gridButtons[row][col]);
			}
		}
		
		
		
		
		
		gridPanel.setLayout(layout);
		startupFrame.add(gridPanel, BorderLayout.CENTER);
		startupFrame.add(scorePanel, BorderLayout.LINE_END);
		startupFrame.add(buttonPanel, BorderLayout.PAGE_END);
		startupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    startupFrame.pack();
	    startupFrame.setSize(1000, 600);
	    startupFrame.setLocationRelativeTo(null);
	    startupFrame.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == quit)
			dispose();
			System.exit(0);
	}
	
	public JPanel scorePanel() {
		JPanel scores = new JPanel();
		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);
				
		JLabel player1 = new JLabel("   Player 1:   ");
		JLabel player1Score = new JLabel("          " + getPlayer1() + "   ");
		JLabel player2 = new JLabel("   Player 2:   ");
		JLabel player2Score = new JLabel("          " + getPlayer2() + "   ");
		JLabel player3 = new JLabel("   Player 3:   ");
		JLabel player3Score = new JLabel("          " + getPlayer3() + "   ");
		player1.setFont(font1);
		player1Score.setFont(font1);
		player2.setFont(font1);
		player2Score.setFont(font1);
		player3.setFont(font1);
		player3Score.setFont(font1);
		scores.setLayout(new GridLayout(6, 1));
		
		scores.add(player1);
		scores.add(player1Score);
		scores.add(player2);
		scores.add(player2Score);
		scores.add(player3);
		scores.add(player3Score);
		
		return scores;
	}
	
//	public JPanel scorePanel() {
//		JPanel scores = new JPanel();
//		JLabel player1 = new JLabel("Player 1:\n" + getPlayer3());
//		JLabel player2 = new JLabel("Player 2:\n" + getPlayer3());
//		JLabel player3 = new JLabel("Player 3:\n" + getPlayer3());
//		scores.setLayout(new GridLayout(3, 1));
//		
//		scores.add(player1);
//		scores.add(player2);
//		scores.add(player3);
//		
//		return scores;
//	}
	
	public JPanel buttonPanel() {
		JPanel buttons = new JPanel();
		JButton quit = new JButton("Quit");
		quit.addActionListener(this);
		JButton reset = new JButton("Reset");
		JButton newGame = new JButton("New Game");
		buttons.add(quit);
		buttons.add(reset);
		buttons.add(newGame);
		
		return buttons;
	}
	
	public int getPlayer1() {
		return player1;
	}
	
	public int getPlayer2() {
		return player2;
	}
	
	public int getPlayer3() {
		return player3;
	}
	
	
	public static void main(String[] args) {
		TriviaGui game = new TriviaGui();
		
	}

}