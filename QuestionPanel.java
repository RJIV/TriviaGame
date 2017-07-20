package edu.gvsu.cis350.triviaGame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


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
	/**JPanel that holds whose turn it is. */
	private JPanel wpanel;
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
	/**Submit button.*/
	private JButton submit;
	/**Button group to hold radio buttons.*/
	private ButtonGroup bG;
	/**Int to hold the question set index.*/
	private int index;
	
	/**QGenerator object that generates the question set.*/
	private QGenerator q;
	
	/**Score object to handle change in player points.*/
	private Score s;

	/**
	 * Constructor for objects of type QuestionPanel, 
	 * that creates a frame and populates widgets.
	 * @param index Type: int. Stores index of question selected.
	 * @param scoreBoard Type: Score. Object created by TriviaGui to
	 * obtain  player scores.
	 */
	public QuestionPanel(final int index, final Score scoreBoard) {
		frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "Player Buzzers\n\n "
				+ " Player 1: Z\n  Player 2: M\n  Player 3: Q ");
		
		s = scoreBoard;
		
		player = 0;
		this.index = index;
		q = new QGenerator();
		q.createQSet();

		qpanel = new JPanel();
		cpanel = new JPanel();
		bpanel = new JPanel();
		wpanel = new JPanel();
		bG = new ButtonGroup();
		playerterm = new JLabel();

		submit = new JButton("Submit");
		submit.addActionListener(this);
		bpanel.add(submit);

		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);
		Font font2 = new Font("Tahoma", Font.CENTER_BASELINE, 28);

		question = new JTextArea(10, 40);
		question.setFont(font1);
		question.setText(q.getQuestionAt(index).getQue());
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setBackground(frame.getBackground());
		question.setEditable(false);
		playerterm.setFont(font1);
		wpanel.add(playerterm);

		choiceA = new JRadioButton(q.getQuestionAt(index).getAChoice());
		choiceB = new JRadioButton(q.getQuestionAt(index).getBChoice());
		choiceC = new JRadioButton(q.getQuestionAt(index).getCChoice());
		choiceD = new JRadioButton(q.getQuestionAt(index).getDChoice());
		choiceA.setFont(font2);
		choiceB.setFont(font2);
		choiceC.setFont(font2);
		choiceD.setFont(font2);
		choiceA.addActionListener(this);
		choiceB.addActionListener(this);
		choiceC.addActionListener(this);
		choiceD.addActionListener(this);

		bG.add(choiceA);
		bG.add(choiceB);
		bG.add(choiceC);
		bG.add(choiceD);

		qpanel.add(question);
		cpanel.add(choiceA);
		cpanel.add(choiceB);
		cpanel.add(choiceC);
		cpanel.add(choiceD);

		frame.add(qpanel, BorderLayout.NORTH);
		frame.add(cpanel, BorderLayout.SOUTH);
		frame.add(wpanel, BorderLayout.WEST);
		frame.add(bpanel, BorderLayout.CENTER);

		frame.pack();
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		choiceA.setEnabled(false);
		choiceB.setEnabled(false);
		choiceC.setEnabled(false);
		choiceD.setEnabled(false);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		submit.setEnabled(false);
		frame.setDefaultCloseOperation(0);
	}

	@Override
	public void keyPressed(final KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			choiceA.setEnabled(true);
			choiceB.setEnabled(true);
			choiceC.setEnabled(true);
			choiceD.setEnabled(true);
			playerterm.setText("Player 1");
			player = 1;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			choiceA.setEnabled(true);
			choiceB.setEnabled(true);
			choiceC.setEnabled(true);
			choiceD.setEnabled(true);
			playerterm.setText("Player 2");
			player = 2;
		}

		if (e.getKeyCode() == KeyEvent.VK_Q) {
			choiceA.setEnabled(true);
			choiceB.setEnabled(true);
			choiceC.setEnabled(true);
			choiceD.setEnabled(true);
			playerterm.setText("Player 3");
			player = 3;
		}
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		submit.setEnabled(true);
		if (e.getSource() == submit) {
			answer();
			frame.setVisible(false);
		}
		

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
			q.getQuestionAt(index).setUserAns("A");
		} else if (choiceB.isSelected()) {
			q.getQuestionAt(index).setUserAns("B");
		} else if (choiceC.isSelected()) {
			q.getQuestionAt(index).setUserAns("C");
		} else if (choiceD.isSelected()) {
			q.getQuestionAt(index).setUserAns("D");
		}
		
		
		if (q.getQuestionAt(index).checkAnswer()) {
			//System.out.println("correct");
			JOptionPane.showMessageDialog(frame, "Correct");

			if (player == 1) {
				// change: the score that worth of value
				s.setplayer1(q.getQuestionAt(index).getScore());
			} else if (player == 2) {
				s.setplayer2(q.getQuestionAt(index).getScore());
			} else if (player == 3) {
				s.setplayer3(q.getQuestionAt(index).getScore());
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Incorrect");
		// pass the score
			
			if (player == 1) {
				// change: the score that worth of value
				s.setplayer1(q.getQuestionAt(index).getScore() * -1);
			} else if (player == 2) {
				s.setplayer2(q.getQuestionAt(index).getScore() * -1);
			} else { 
				s.setplayer3(q.getQuestionAt(index).getScore() * -1);
			}
		}
		
	}

}
