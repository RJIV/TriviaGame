//package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import java.awt.Dimension;


/**
 * TriviaGui extends JFrame implements ActionListener.
 * Generates the UI containing button grid and score labels.
 * Creates score object to hold player score information.
 * Creates QuestionPanel object to initiate user question interaction.
 * @author R.J. Hamilton
 */
public class TriviaGui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**startupFrame- Frame that contains all UI panels. */
	private JFrame startupFrame;
	
	/**gridPanel- contains the grid of question buttons.
	 * A 5x5 grid of 20 buttons with 5 column headers.
	 */
	private JPanel gridPanel;
	
	/**scorePane - contains 1x6 array of JLabels that display user scores. */
	private JPanel scorePanel;
	
	/**buttonPanel - contains two buttons, for quitting and reseting the game.*/
	private JPanel buttonPanel;
	
	/**gridButtons - 2D array of buttons contained in gridPanel. Size 5x5*/
	private JButton[][] gridButtons;
	
	/**quit, newGame - JButtons to quit/reset game. Contained in buttonPanel. */
	private JButton quit, newGame;
	
	/**JLabel[] -Array of JLabels which form the column headers of gridPanel. */
	private JLabel[] genreLabels;
	
	/**JLabel notifying where the score is for player 1. */
	private JLabel player1Label;
	
	/**JLabel notifying where the score is for player 2. */
	private JLabel player2Label;
	
	/**JLabel notifying where the score is for player 3. */
	private JLabel player3Label;
	
	/**JLabel displaying the score is for player 1. */
	protected JLabel player1Score;
	
	/**JLabel displaying the score is for player 2. */
	protected JLabel player2Score;
	
	/**JLabel displaying the score is for player 3. */
	protected JLabel player3Score;
	
	/**GridLayout - created to contain layout of gridPanel. */
	private GridLayout layout;
	
	/**Score entity object created to hold player scores for this game.*/
	protected Score scoreBoard;
	
	static TriviaGui game;
	
	/**
	 * Constructor creates Score object, and
	 * generates the user interface and adds action listeners to widgets.
	 */
	public TriviaGui() {
		//Create score object
		scoreBoard = new Score();
		
		//Create JFrame object
		startupFrame = new JFrame("Trivia Game");
		startupFrame.setPreferredSize(new Dimension(900, 750));
		startupFrame.setResizable(false);

		gridPanel = gridPanel();
		buttonPanel = buttonPanel();
		scorePanel = new JPanel();
		scorePanel.setPreferredSize(new Dimension(10, 700));
		scorePanel.setBounds(107, 565, 684, 64);
		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);
				
		player1Label = new JLabel("Player 1:");
		player1Label.setHorizontalAlignment(SwingConstants.CENTER);
		player1Score = 
				new JLabel("0");
		player1Score.setHorizontalAlignment(SwingConstants.CENTER);
		player2Score = 
				new JLabel("0");
		player2Score.setHorizontalAlignment(SwingConstants.CENTER);
		player3Score = 
				new JLabel("0");
		player3Score.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Label fonts
		player1Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		player1Score.setFont(font1);
		player2Score.setFont(font1);
		player3Score.setFont(font1);
		scorePanel.setLayout(new GridLayout(2, 3));
		
		//Add score labels to scorePanel
		scorePanel.add(player1Label);
		player2Label = new JLabel("Player 2:");
		player2Label.setHorizontalAlignment(SwingConstants.CENTER);
		player2Label.setFont(font1);
		scorePanel.add(player2Label);
		player3Label = new JLabel("Player 3:");
		player3Label.setHorizontalAlignment(SwingConstants.CENTER);
		player3Label.setFont(font1);
		scorePanel.add(player3Label);
		scorePanel.add(player1Score);
		scorePanel.add(player2Score);
		scorePanel.add(player3Score);
		startupFrame.getContentPane().setLayout(null);
		
		//Add panels to primary frame (startupFrame)
		gridPanel.setLayout(layout);
		startupFrame.getContentPane().add(gridPanel);
		startupFrame.getContentPane().add(scorePanel);
		startupFrame.getContentPane().add(buttonPanel);
		startupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    startupFrame.pack();
	    
	    //Set size of frame
	    startupFrame.setLocationRelativeTo(null);
	    
	    //Make UI visible
	    startupFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == quit) {
			//Prompt confirmation
			int response = JOptionPane.showConfirmDialog(null,
					"Are you sure you want to quit?");
			//If confirmed exit
			if (response == 0) {
				dispose();
				System.exit(0);
			}
		}
		
		if (e.getSource() == newGame) {
			//Prompt confirmation
			int response = JOptionPane.showConfirmDialog(null,
					"Are you sure you want to start a new game?");
			//If confirmed reload
			if (response == 0) {
				reloadUI();
			}
		}
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 5; col++) {
				if (e.getSource() == gridButtons[row][col]) {
					int index = 4 * col + row;
					QuestionPanel q = new QuestionPanel(index, scoreBoard,game);	
					gridButtons[row][col].setEnabled(false);
				}
			}
		}
		
	}
	
	/**
	 * gridPanel method generates the column headers and question buttons
	 * used to access each question UI.
	 * 
	 * @return gridPanel Type: JPanel. 
	 * This panel contains all the buttons to access questions and can
	 * be added to the main layout frame.
	 */
	public JPanel gridPanel() {
		//Create panel
		JPanel gridPanel = new JPanel();
		gridPanel.setBounds(15, 16, 857, 533);
		
		//Set size of grid.
		final int gridSize = 5;
		
		//Set styles of labels
		Font labelFont = new Font("Tahoma", Font.BOLD, 26);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		layout = new GridLayout(gridSize, gridSize);
		genreLabels = new JLabel[gridSize];
		gridButtons = new JButton[4][5];
		
		genreLabels[0] = new JLabel("Marvel", SwingConstants.CENTER);
		genreLabels[1] = new JLabel("Animation", SwingConstants.CENTER);
		genreLabels[2] = new JLabel("Pirates", SwingConstants.CENTER);
		genreLabels[3] = new JLabel("Star Wars", SwingConstants.CENTER);
		genreLabels[4] = new JLabel("Fantasy", SwingConstants.CENTER);
		
		for (int col = 0; col < 5; col++) {
			genreLabels[col].setFont(labelFont);
			genreLabels[col].setBorder(blackLine);
			genreLabels[col].setOpaque(true);
			genreLabels[col].setBackground(new JButton().getBackground());
			gridPanel.add(genreLabels[col]);
		}
		
		for (int col = 0; col < 5; col++) {
			gridButtons[0][col] = new JButton("100");
			gridButtons[0][col].addActionListener(this);
		}
		for (int col = 0; col < 5; col++) {
			gridButtons[1][col] = new JButton("200");
			gridButtons[1][col].addActionListener(this);
		}
		for (int col = 0; col < 5; col++) {
			gridButtons[2][col] = new JButton("300");
			gridButtons[2][col].addActionListener(this);
		}
		for (int col = 0; col < 5; col++) {
			gridButtons[3][col] = new JButton("400");
			gridButtons[3][col].addActionListener(this);
		}
		
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 5; col++) {
				gridPanel.add(gridButtons[row][col]);
				
			}
		}
		return gridPanel;
	}

	/**
	 * buttonPanel method creates and populates a JPanel that contains the quit
	 * and new game buttons.
	 * @return buttonPanel Type: JPanel 
	 * To be added to main layout frame.
	 */
	public JPanel buttonPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(0, 645, 900, 39);
		quit = new JButton("Quit");
		quit.addActionListener(this);
		newGame = new JButton("New Game");
		newGame.addActionListener(this);
		buttonsPanel.add(quit);
		buttonsPanel.add(newGame);
		
		return buttonsPanel;
	}
	
	/**
	 * 
	 */
	public void updateScore() {
		player1Score.setText("          " + scoreBoard.getplayer1() + "   ");
		player2Score.setText("          " + scoreBoard.getplayer2() + "   ");
		player3Score.setText("          " + scoreBoard.getplayer3() + "   ");
	}
	
	/**
	 * 
	 */
	public void reloadUI() {
		scoreBoard.clearScore();
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 5; col++) {
				gridButtons[row][col].setEnabled(true);
			}
		}
	}

	/**
	 * Main method is the primary executable. By running this method the 
	 * game UI is created and the game can be played.
	 * @param args default parameter to main method.
	 */
	public static void main(final String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, fall back to cross-platform
		    try {
		        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    } catch (Exception ex) {
		    }
		}
		game = new TriviaGui();
	}
}