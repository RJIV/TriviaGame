import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

//R.J. Hamilton

public class TriviaGui extends JFrame implements ActionListener {

	private JFrame startupFrame;
	private JPanel gridPanel;
	private JPanel scorePanel;
	private JPanel buttonPanel;
	private JButton[][] gridButtons;
	private JButton quit, newGame;
	private JLabel[] genreLabels;
	private JLabel player1Label;
	private JLabel player2Label;
	private JLabel player3Label;
	private JLabel player1Score;
	private JLabel player2Score;
	private JLabel player3Score;
	private GridLayout layout;
	private int[] playerScores;
	private Score scoreBoard;
	
	
	public TriviaGui() {
		
		
		scoreBoard = new Score();
		
		startupFrame = new JFrame("Trivia Game");
		playerScores = new int[3];
		gridPanel = gridPanel();
		buttonPanel = buttonPanel();
		scorePanel = new JPanel();
		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);
				
		player1Label = new JLabel("   Player 1:   ");
		player1Score = new JLabel("          " + scoreBoard.getplayer1() + "   ");
		player2Label = new JLabel("   Player 2:   ");
		player2Score = new JLabel("          " + scoreBoard.getplayer2() + "   ");
		player3Label = new JLabel("   Player 3:   ");
		player3Score = new JLabel("          " + scoreBoard.getplayer3() + "   ");
		player1Label.setFont(font1);
		player1Score.setFont(font1);
		player2Label.setFont(font1);
		player2Score.setFont(font1);
		player3Label.setFont(font1);
		player3Score.setFont(font1);
		scorePanel.setLayout(new GridLayout(6, 1));
		
		scorePanel.add(player1Label);
		scorePanel.add(player1Score);
		scorePanel.add(player2Label);
		scorePanel.add(player2Score);
		scorePanel.add(player3Label);
		scorePanel.add(player3Score);
		
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
		if(e.getSource() == quit) {
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
			if(response == 0) {
				dispose();
				System.exit(0);
			}
		}
		
		if(e.getSource() == newGame) {
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?");
			if(response == 0) {
				reloadUI();
			}
		}
		for(int row = 0; row < 4; row++){
			for(int col = 0; col < 5; col++){
				updateScore();
				if(e.getSource() == gridButtons[row][col]) {
					int index = 4*col + row;
					QuestionPanel q = new QuestionPanel(index, scoreBoard);	
					gridButtons[row][col].setEnabled(false);
				}
			}
		}
		updateScore();
	}
	
	
	public JPanel gridPanel() {
		JPanel gridPanel = new JPanel();
		final int gridSize = 5;
		Font labelFont = new Font("Tahoma", Font.BOLD, 26);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		layout = new GridLayout(gridSize,gridSize);
		genreLabels = new JLabel[gridSize];
		gridButtons = new JButton[4][5];
		
		genreLabels[0] = new JLabel("Marvel", SwingConstants.CENTER);
		genreLabels[1] = new JLabel("Animation", SwingConstants.CENTER);
		genreLabels[2] = new JLabel("Pirates", SwingConstants.CENTER);
		genreLabels[3] = new JLabel("Star Wars", SwingConstants.CENTER);
		genreLabels[4] = new JLabel("Fantasy", SwingConstants.CENTER);
		
		for(int col = 0; col < 5; col++) {
			genreLabels[col].setFont(labelFont);
			genreLabels[col].setBorder(blackLine);
			genreLabels[col].setOpaque(true);
			genreLabels[col].setBackground(new JButton().getBackground());
			gridPanel.add(genreLabels[col]);
		}
		
		for(int col = 0; col < 5; col++) {
			gridButtons[0][col] = new JButton("100");
			gridButtons[0][col].addActionListener(this);
		}
		for(int col = 0; col < 5; col++) {
			gridButtons[1][col] = new JButton("200");
			gridButtons[1][col].addActionListener(this);
		}
		for(int col = 0; col < 5; col++) {
			gridButtons[2][col] = new JButton("300");
			gridButtons[2][col].addActionListener(this);
		}
		for(int col = 0; col < 5; col++) {
			gridButtons[3][col] = new JButton("400");
			gridButtons[3][col].addActionListener(this);
		}
		
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 5; col++) {
				gridPanel.add(gridButtons[row][col]);
				
			}
		}
		return gridPanel;
	}

	public JPanel buttonPanel() {
		JPanel buttonsPanel = new JPanel();
		quit = new JButton("Quit");
		quit.addActionListener(this);
		//newGame = new JButton("New Game");
		//newGame.addActionListener(this);
		buttonsPanel.add(quit);
		//buttonsPanel.add(newGame);
		
		return buttonsPanel;
	}
	
	public void updateScore() {
		player1Score.setText("          " + scoreBoard.getplayer1() + "   ");
		player2Score.setText("          " + scoreBoard.getplayer2() + "   ");
		player3Score.setText("          " + scoreBoard.getplayer3() + "   ");
	}
	
	public void reloadUI() {
		scoreBoard.clearScore();
		gridPanel();
	}
	
	public static void main(String[] args) {
		TriviaGui game = new TriviaGui();
	}
}