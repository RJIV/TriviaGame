<<<<<<< HEAD
//package test;
=======
package project;
>>>>>>> 6fe12f74120f33237a713d99dcdaed7e409fb28b

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import java.awt.Dimension;

/**
 * TriviaGui extends JFrame implements ActionListener. Generates the UI
 * containing button grid and score labels. Creates score object to hold player
 * score information. Creates QuestionPanel object to initiate user question
 * interaction.
 * 
 * @author R.J. Hamilton
 */
public class TriviaGui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** startupFrame- Frame that contains all UI panels. */
	private JFrame startupFrame;

	/**
	 * gridPanel- contains the grid of question buttons. A 5x5 grid of 20
	 * buttons with 5 column headers.
	 */
	private JPanel gridPanel;

	/** scorePane - contains 1x6 array of JLabels that display user scores. */
	private JPanel scorePanel;

	/**
	 * buttonPanel - contains two buttons, for quitting and reseting the game.
	 */
	private JPanel buttonPanel;

	/** gridButtons - 2D array of buttons contained in gridPanel. Size 5x5 */
	private JButton[][] gridButtons;

	/**
	 * quit, newGame - JButtons to quit/reset game. Contained in buttonPanel.
	 */
	private JButton quit, newGame;

	/**
	 * JLabel[] -Array of JLabels which form the column headers of gridPanel.
	 */
	private JLabel[] genreLabels;

	/** JLabel notifying where the score is for player 1. */
	private JLabel player1Label;

	/** JLabel notifying where the score is for player 2. */
	private JLabel player2Label;

	/** JLabel notifying where the score is for player 3. */
	private JLabel player3Label;

	/** JLabel displaying the score is for player 1. */
	protected JLabel player1Score;

	/** JLabel displaying the score is for player 2. */
	protected JLabel player2Score;

	/** JLabel displaying the score is for player 3. */
	protected JLabel player3Score;

	/** GridLayout - created to contain layout of gridPanel. */
	private GridLayout layout;

	/** Score entity object created to hold player scores for this game. */
	protected Score scoreBoard;

	static TriviaGui game;

	private JFrame welcomeframe;

	private JTextField greeting;

	private ButtonGroup bG;

	private int nplayer = 0;

	private JMenuItem Back;

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
		
		player2Label = new JLabel("Player 2:");
		player2Label.setHorizontalAlignment(SwingConstants.CENTER);
		player2Label.setFont(font1);

		player3Label = new JLabel("Player 3:");
		player3Label.setHorizontalAlignment(SwingConstants.CENTER);
		player3Label.setFont(font1);

		
		welcomeframe = new JFrame();
		welcomeframe.setBounds(100, 100, 450, 300);
		welcomeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bG = new ButtonGroup();

		JPanel bpanel1 = new JPanel();
		welcomeframe.getContentPane().add(bpanel1, BorderLayout.CENTER);
		bpanel1.setLayout(null);

		JRadioButton solo = new JRadioButton("Solo");
		solo.setForeground(Color.RED);
		solo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		solo.setBounds(106, 117, 81, 38);

		bpanel1.add(solo);

		JRadioButton dual = new JRadioButton("Dual");
		dual.setForeground(Color.BLUE);
		dual.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dual.setBounds(189, 117, 82, 38);
		dual.addActionListener(this);
		bpanel1.add(dual);

		JRadioButton multi = new JRadioButton("Three");
		multi.setForeground(Color.GREEN);
		multi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		multi.setBounds(273, 117, 111, 38);
		multi.addActionListener(this);
		bpanel1.add(multi);

		JPanel bpanel2 = new JPanel();
		bpanel2.setBounds(0, 175, 434, 77);
		bpanel1.add(bpanel2);
		bpanel2.setLayout(null);

		JButton begin = new JButton("Begin");
		begin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		begin.setBounds(86, 26, 93, 23);
		bpanel2.add(begin);

		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cancel.setBounds(247, 27, 93, 23);

		bpanel2.add(cancel);

		JPanel lpanel = new JPanel();
		lpanel.setBackground(Color.BLUE);
		lpanel.setBounds(0, 0, 434, 77);
		bpanel1.add(lpanel);
		lpanel.setLayout(null);

		bG.add(solo);
		bG.add(dual);
		bG.add(multi);

		greeting = new JTextField();
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setFont(new Font("Times New Roman", Font.BOLD, 26));
		greeting.setForeground(Color.YELLOW);
		greeting.setBackground(Color.BLUE);
		greeting.setBounds(10, 5, 414, 62);
		greeting.setText("Welcome to Trivia Game");
		greeting.setEditable(false);
		lpanel.add(greeting);
		greeting.setColumns(10);
		startupFrame.getContentPane().setLayout(null);
		welcomeframe.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		startupFrame.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		Back = new JMenuItem("Go back");
		mnMenu.add(Back);
		Back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==Back){
					startupFrame.setVisible(false);
					welcomeframe.setVisible(true);
					//reloadUI();
					
				}
			}
			
		});
		
		
		
		
		solo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nplayer = 1;
			}

		});

		dual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nplayer = 2;
			}

		});

		multi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nplayer = 3;
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				System.exit(0);
			}

		});

		begin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if (e.getSource() == begin) {	
					

					// Add score labels to scorePanel
					switch (nplayer) {
					case 1:
						scorePanel.add(player1Label);
						scorePanel.add(player1Score);
						break;
					case 2:
						scorePanel.add(player1Label);
						scorePanel.add(player1Score);
						scorePanel.add(player2Label);
						scorePanel.add(player2Score);
						break;
					case 3:
						scorePanel.add(player1Label);
						scorePanel.add(player1Score);
						scorePanel.add(player2Label);
						scorePanel.add(player2Score);
						scorePanel.add(player3Label);
						scorePanel.add(player3Score);
						break;
					}
				
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
				welcomeframe.setVisible(false);
			}
			}
		});
		
	
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		int response = 0;
		if (e.getSource() == quit) {
			// Prompt confirmation
			response = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
			// If confirmed exit
			if (response == 0) {
				dispose();
				System.exit(0);
			}
			
		}

		if (e.getSource() == newGame) {
			// Prompt confirmation
			response = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?");
			// If confirmed reload
			if (response == 0) {
				reloadUI();
			}
			
		}
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 5; col++) {
				if (e.getSource() == gridButtons[row][col]) {
					int index = 4 * col + row;
					QuestionPanel q = new QuestionPanel(index, scoreBoard, game, nplayer);
					gridButtons[row][col].setEnabled(false);
				}
			}
		}
	}

	/**
	 * gridPanel method generates the column headers and question buttons used
	 * to access each question UI.
	 * 
	 * @return gridPanel Type: JPanel. This panel contains all the buttons to
	 *         access questions and can be added to the main layout frame.
	 */
	public JPanel gridPanel() {
		// Create panel
		JPanel gridPanel = new JPanel();
		gridPanel.setBounds(15, 16, 857, 533);

		// Set size of grid.
		final int gridSize = 5;

		// Set styles of labels
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
	 * 
	 * @return buttonPanel Type: JPanel To be added to main layout frame.
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
		player1Score.setText("" + scoreBoard.getplayer1());
		player2Score.setText("" + scoreBoard.getplayer2());
		player3Score.setText("" + scoreBoard.getplayer3());
	}

	/**
	 * 
	 */
	public void reloadUI() {
		scoreBoard.clearScore();
		updateScore();
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 5; col++) {
				gridButtons[row][col].setEnabled(true);
			}
		}
	}

	/**
	 * Main method is the primary executable. By running this method the game UI
	 * is created and the game can be played.
	 * 
	 * @param args
	 *            default parameter to main method.
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