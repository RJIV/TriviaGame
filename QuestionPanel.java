package edu.gvsu.cis350.triviaGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;


/**
 * @author Zhen Lu
 *
 * Class creates the UI dialog that handles the answering
 *  of the trivia questions.
 */
public class QuestionPanel extends JFrame implements
                                          ActionListener, KeyListener {

	/** Default Serial required for JFrame.*/
	private static final long serialVersionUID = 1L;
	/** JTextArea to hold question text.*/
	private JTextArea question;
	/**JLabel to display whose turn it is.*/
	private JLabel playerterm;
	/** int to hold whose turn it is.*/
	private int player;
	/** Jpanel that holds the question.*/
	private JPanel qpanel;
	/**JPanel that holds answer options.*/
	private JPanel cpanel;
	/**JPanel that holds submit button.*/
	private JPanel bpanel;
	/**Main JFrame that holds all panels.*/
	private JFrame frame;
	/**RadioButton for A option.*/
	private JRadioButton choiceA;
	/**RadioButton for B option.*/
	private JRadioButton choiceB;
	/**Radiobutton for C option.*/
	private JRadioButton choiceC;
	/**Radiobutton for D option.*/
	private JRadioButton choiceD;
	/**Progress Bar.*/
	private JProgressBar pBar;
	/**Button group to hold radio buttons.*/
	private ButtonGroup bG;
	/**Int to hold the question set index.*/
	private int index;
	
	/**QGenerator object that generates the question set.*/
	private QGenerator qGen;
	
	/**Score object to handle change in player points.*/
	private Score s;
	
	
	
	static Timer time;
	int count = 10;
	int delay = count * 1000;
	TriviaGui g;
	int nplayer=0;
	private InfoGui infor;
	/**
	 * Constructor for objects of type QuestionPanel, 
	 * that creates a frame and populates widgets.
	 * @param index Type: int. Stores index of question selected.
	 * @param scoreBoard Type: Score. Object created by TriviaGui to
	 * obtain  player scores.
	 */
	public QuestionPanel(final int index, final Score scoreBoard,TriviaGui game,int nplayer, QGenerator QGen) {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 600));
		
		this.nplayer = nplayer;
		this.qGen = QGen;
		
		s = scoreBoard;
		g = game;
		player = 0;
		this.index = index;
		//q = new QGenerator();
		//q.createQSet();

		qpanel = new JPanel();
		qpanel.setBounds(0, 0, 778, 213);
		cpanel = new JPanel();
		cpanel.setBounds(28, 216, 722, 186);
		bpanel = new JPanel();
		bpanel.setBounds(0, 468, 778, 60);
		bG = new ButtonGroup();

		pBar = new JProgressBar();
		pBar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pBar.setValue(100);
		pBar.setPreferredSize(new Dimension(500, 30));
		bpanel.add(pBar,BorderLayout.CENTER);

		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);

		question = new JTextArea(10, 40);
		question.setFocusTraversalKeysEnabled(false);
		question.setFocusable(false);
		question.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		question.setRequestFocusEnabled(false);
		question.setVerifyInputWhenFocusTarget(false);
		question.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		question.setBounds(28, 16, 722, 194);
		question.setFont(new Font("Tahoma", Font.PLAIN, 20));
		question.setText(qGen.getQuestionAt(index).getQue());
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setEditable(false);
		
		choiceA = new JRadioButton(qGen.getQuestionAt(index).getAChoice());
		choiceA.setHorizontalAlignment(SwingConstants.LEFT);
		choiceB = new JRadioButton(qGen.getQuestionAt(index).getBChoice());
		choiceB.setHorizontalAlignment(SwingConstants.LEFT);
		choiceC = new JRadioButton(qGen.getQuestionAt(index).getCChoice());
		choiceC.setHorizontalAlignment(SwingConstants.LEFT);
		choiceD = new JRadioButton(qGen.getQuestionAt(index).getDChoice());
		choiceD.setHorizontalAlignment(SwingConstants.LEFT);
		choiceA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		choiceB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		choiceC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		choiceD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		choiceA.addActionListener(this);
		choiceB.addActionListener(this);
		choiceC.addActionListener(this);
		choiceD.addActionListener(this);

		bG.add(choiceA);
		bG.add(choiceB);
		bG.add(choiceC);
		bG.add(choiceD);
		qpanel.setLayout(null);

		qpanel.add(question);
		cpanel.setLayout(new GridLayout(4, 1, 0, 10));
		cpanel.add(choiceA);
		cpanel.add(choiceB);
		cpanel.add(choiceC);
		cpanel.add(choiceD);
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(qpanel);
		frame.getContentPane().add(cpanel);
		frame.getContentPane().add(bpanel);

		frame.pack();
		frame.setSize(800, 598);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		choiceA.setEnabled(false);
		choiceB.setEnabled(false);
		choiceC.setEnabled(false);
		choiceD.setEnabled(false);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		pBar.setStringPainted(false);
		playerterm = new JLabel();
		playerterm.setHorizontalAlignment(SwingConstants.CENTER);
		playerterm.setBounds(303, 415, 169, 48);
		frame.getContentPane().add(playerterm);
		playerterm.setFont(font1);
		frame.setDefaultCloseOperation(0);
		countdown();	
	}

	@Override
	public void keyPressed(final KeyEvent e) {
		

		if (nplayer==1) {
			if(e.getKeyCode() == KeyEvent.VK_Z){
			setup();
			playerterm.setText("Player 1");
			player = 1;			
			}
		}
		if (nplayer==2) {
			if(e.getKeyCode() == KeyEvent.VK_Z){
				setup();
				playerterm.setText("Player 1");
				player = 1;			
				}
			if(e.getKeyCode() == KeyEvent.VK_M){
			setup();
			playerterm.setText("Player 2");
			player = 2;
			}
		}

		if (nplayer==3)
		{
			if(e.getKeyCode() == KeyEvent.VK_Z){
				setup();
				playerterm.setText("Player 1");
				player = 1;		
				}
			if(e.getKeyCode() == KeyEvent.VK_M){
			setup();
			playerterm.setText("Player 2");
			player = 2;
			}
			if( e.getKeyCode() == KeyEvent.VK_Q){
			setup();
			playerterm.setText("Player 3");
			player = 3;
			}
		}
	}

	@Override
	public void actionPerformed(final ActionEvent e) {

	}

	@Override
	public void keyReleased(final KeyEvent e) {
	}

	@Override
	public void keyTyped(final KeyEvent e) {
	}


	/**
	 * Method handles the radio buttons and correct or incorrect
	 * answers.
	 */
	private void answer() {
		if (choiceA.isSelected()) {
			qGen.getQuestionAt(index).setUserAns("A");
		} else if (choiceB.isSelected()) {
			qGen.getQuestionAt(index).setUserAns("B");
		} else if (choiceC.isSelected()) {
			qGen.getQuestionAt(index).setUserAns("C");
		} else if (choiceD.isSelected()) {
			qGen.getQuestionAt(index).setUserAns("D");
		} else
			qGen.getQuestionAt(index).setUserAns("F");
		
		
		if (qGen.getQuestionAt(index).checkAnswer()) {
			//System.out.println("correct");
			JOptionPane.showMessageDialog(frame, "Correct");

			if (player == 1) {
				// change: the score that worth of value
				s.setplayer1(qGen.getQuestionAt(index).getScore());
			} else if (player == 2) {
				s.setplayer2(qGen.getQuestionAt(index).getScore());
			} else if (player == 3) {
				s.setplayer3(qGen.getQuestionAt(index).getScore());
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Incorrect");
		// pass the score
			
			if (player == 1) {
				if(s.getplayer1()>0)
				s.setplayer1(qGen.getQuestionAt(index).getScore() * -1);
			} else if (player == 2) {
				if(s.getplayer2()>0)
				s.setplayer2(qGen.getQuestionAt(index).getScore() * -1);
			} else { 
				if(s.getplayer3()>0)
				s.setplayer3(qGen.getQuestionAt(index).getScore() * -1);
			}
		}
		
		g.player1Score.setText("" + s.getplayer1());
		g.player2Score.setText("" + s.getplayer2());
		g.player3Score.setText("" + s.getplayer3());
		
		infor = new InfoGui(qGen.getQuestionAt(index).getStats());
	}
	
	private void setup() {
		choiceA.setEnabled(true);
		choiceB.setEnabled(true);
		choiceC.setEnabled(true);
		choiceD.setEnabled(true);
		frame.setFocusable(false);
	}

	private void countdown() {
		time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				count--;
				pBar.setValue(count*10);
				//System.out.println(count);
				if (count == 0) {
					time.stop();
					answer();
					frame.setVisible(false);
				}
			}
		});
		time.setRepeats(true);
		time.start();
	}
}
