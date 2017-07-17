import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class QuestionPanel extends JFrame implements ActionListener, KeyListener {

	private JTextArea question;
	private JLabel playerterm;
	private int player;
	private int[] score;
	private JPanel Qpanel;
	private JPanel Wpanel;
	private JPanel Cpanel;
	private JPanel Bpanel;
	private JFrame frame;
	private JLabel timer;
	private JRadioButton choiceA;
	private JRadioButton choiceB;
	private JRadioButton choiceC;
	private JRadioButton choiceD;
	private JButton submit;
	private ButtonGroup bG;
	private int index;
	QGenerator q;
	Countdown count;
	Score s;

	public QuestionPanel(int index, Score ScoreBoard) {
		JOptionPane.showMessageDialog(frame, "Player Buzzers\n\n  Player 1: Z\n  Player 2: M\n  Player 3: Q ");
		
		s = ScoreBoard;
		
		player = 0;
		score = new int[3];
		this.index = index;
		q = new QGenerator();
		q.createQSet();
		frame = new JFrame();
		Qpanel = new JPanel();
		Cpanel = new JPanel();
		Bpanel = new JPanel();
		Wpanel = new JPanel();
		bG = new ButtonGroup();
		playerterm = new JLabel();

		submit = new JButton("Submit");
		submit.addActionListener(this);
		Bpanel.add(submit);

		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);
		Font font2 = new Font("Tahoma", Font.CENTER_BASELINE, 28);

		question = new JTextArea(10, 40);
		question.setFont(font1);
		question.setText(q.getQuestionAt(index).getQue());
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setBackground(frame.getBackground());
		question.setEditable(false);
		timer = new JLabel();
		playerterm.setFont(font1);
		Wpanel.add(playerterm);

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

		Qpanel.add(question);
		Cpanel.add(choiceA);
		Cpanel.add(choiceB);
		Cpanel.add(choiceC);
		Cpanel.add(choiceD);

		frame.add(Qpanel, BorderLayout.NORTH);
		frame.add(Cpanel, BorderLayout.SOUTH);
		frame.add(Wpanel, BorderLayout.WEST);
		frame.add(Bpanel, BorderLayout.CENTER);

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
		// frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			choiceA.setEnabled(true);
			choiceB.setEnabled(true);
			choiceC.setEnabled(true);
			choiceD.setEnabled(true);
			playerterm.setText("Player 1");
			player =1;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			choiceA.setEnabled(true);
			choiceB.setEnabled(true);
			choiceC.setEnabled(true);
			choiceD.setEnabled(true);
			playerterm.setText("Player 2");
			player =2;
		}

		if (e.getKeyCode() == KeyEvent.VK_Q) {
			choiceA.setEnabled(true);
			choiceB.setEnabled(true);
			choiceC.setEnabled(true);
			choiceD.setEnabled(true);
			playerterm.setText("Player 3");
			player =3 ;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		submit.setEnabled(true);
		if (e.getSource() == submit) {
			answer();
			frame.setVisible(false);
		}
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	/*public static void main(String[] args) {
		QuestionPanel game = new QuestionPanel(5);
	}*/
	
	private void answer() {
		if(choiceA.isSelected()){
			q.getQuestionAt(index).setUserAns("A");
		}
		else if(choiceB.isSelected()) {
			q.getQuestionAt(index).setUserAns("B");
		}
		else if(choiceC.isSelected()) {
			q.getQuestionAt(index).setUserAns("C");
		}
		else if(choiceD.isSelected()) {
			q.getQuestionAt(index).setUserAns("D");
		}
		
		//System.out.println(""+q.getQuestionAt(index).getCorrectAns());
		
		if(q.getQuestionAt(index).checkAnswer()) {
			//System.out.println("correct");
			JOptionPane.showMessageDialog(frame, "Correct");

			if(player == 1)
				// change: the score that worth of value
				s.setplayer1(q.getQuestionAt(index).getScore());
			else if(player ==2)
				s.setplayer2(q.getQuestionAt(index).getScore());
			else if(player == 3)
				s.setplayer3(q.getQuestionAt(index).getScore());
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Incorrect");
		// pass the score
			
			if(player == 1)
				// change: the score that worth of value
				s.setplayer1(q.getQuestionAt(index).getScore()*-1);
			else if(player ==2)
				s.setplayer2(q.getQuestionAt(index).getScore()*-1);
			else 
				s.setplayer3(q.getQuestionAt(index).getScore()*-1);
		}
		
	}

}
