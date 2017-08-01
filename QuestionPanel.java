<<<<<<< HEAD
//package test;
=======
package project;
>>>>>>> 6fe12f74120f33237a713d99dcdaed7e409fb28b

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
<<<<<<< HEAD
=======
import javax.swing.ImageIcon;
import javax.swing.JButton;
>>>>>>> 6fe12f74120f33237a713d99dcdaed7e409fb28b
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.awt.GridLayout;
<<<<<<< HEAD
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;
=======
import java.awt.Image;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.UIManager;
>>>>>>> 6fe12f74120f33237a713d99dcdaed7e409fb28b


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
	private QGenerator q;
	
	/**Score object to handle change in player points.*/
	private Score s;
	
	static Timer time;
	int count = 10;
	int delay = count * 1000;
	TriviaGui g;
	int nplayer=0;
	/**
	 * Constructor for objects of type QuestionPanel, 
	 * that creates a frame and populates widgets.
	 * @param index Type: int. Stores index of question selected.
	 * @param scoreBoard Type: Score. Object created by TriviaGui to
	 * obtain  player scores.
	 */
	public QuestionPanel(final int index, final Score scoreBoard,TriviaGui game,int nplayer) {
		frame = new JFrame();
		frame.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		frame.setPreferredSize(new Dimension(800, 600));
		
		this.nplayer = nplayer;
		if(nplayer==1)
			JOptionPane.showMessageDialog(frame, "Player Buzzers\n\n "
					+ " Player 1: Z\n");
		else if(nplayer ==2)
			JOptionPane.showMessageDialog(frame, "Player Buzzers\n\n "
					+ " Player 1: Z\n  Player 2: M\n");
		else
		JOptionPane.showMessageDialog(frame, "Player Buzzers\n\n "
				+ " Player 1: Z\n  Player 2: M\n  Player 3: Q ");
		
		s = scoreBoard;
		g = game;
		player = 0;
		this.index = index;
		q = new QGenerator();
		q.createQSet();
		
		qpanel = new JPanel();
<<<<<<< HEAD
		qpanel.setBounds(0, 0, 778, 213);
		cpanel = new JPanel();
		cpanel.setBounds(67, 221, 683, 97);
		bpanel = new JPanel();
		bpanel.setBounds(0, 368, 778, 60);
=======
		qpanel.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		qpanel.setBounds(0, 0, 778, 311);
		bpanel = new JPanel();
		bpanel.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		bpanel.setBounds(0, 352, 778, 60);
>>>>>>> 6fe12f74120f33237a713d99dcdaed7e409fb28b
		bG = new ButtonGroup();

		pBar = new JProgressBar();
		pBar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pBar.setValue(100);
		pBar.setPreferredSize(new Dimension(500, 30));
		bpanel.add(pBar,BorderLayout.CENTER);

		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);

		question = new JTextArea(10, 40);
<<<<<<< HEAD
		question.setFocusTraversalKeysEnabled(false);
		question.setFocusable(false);
		question.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		question.setRequestFocusEnabled(false);
		question.setVerifyInputWhenFocusTarget(false);
		question.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		question.setBounds(25, 16, 726, 194);
=======
		question.setForeground(Color.BLACK);
		question.setLineWrap(true);
		question.setEditable(false);
		question.setBorder(null);
		question.setBounds(308, 10, 470, 194);
>>>>>>> 6fe12f74120f33237a713d99dcdaed7e409fb28b
		question.setFont(new Font("Tahoma", Font.PLAIN, 20));
		question.setText(q.getQuestionAt(index).getQue());
		question.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		question.setWrapStyleWord(true);
<<<<<<< HEAD
		question.setEditable(false);
		
		choiceA = new JRadioButton(q.getQuestionAt(index).getAChoice());
		choiceA.setHorizontalAlignment(SwingConstants.LEFT);
		choiceB = new JRadioButton(q.getQuestionAt(index).getBChoice());
		choiceB.setHorizontalAlignment(SwingConstants.LEFT);
		choiceC = new JRadioButton(q.getQuestionAt(index).getCChoice());
		choiceC.setHorizontalAlignment(SwingConstants.LEFT);
		choiceD = new JRadioButton(q.getQuestionAt(index).getDChoice());
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
=======
		question.setFocusable(false);
>>>>>>> 6fe12f74120f33237a713d99dcdaed7e409fb28b
		qpanel.setLayout(null);

		qpanel.add(question);
		frame.getContentPane().setLayout(null);
		cpanel = new JPanel();
		cpanel.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		cpanel.setBounds(304, 214, 474, 97);
		
				
				
				choiceA = new JRadioButton(q.getQuestionAt(index).getAChoice());
				choiceA.setHorizontalAlignment(SwingConstants.CENTER);
				choiceB = new JRadioButton(q.getQuestionAt(index).getBChoice());
				choiceB.setHorizontalAlignment(SwingConstants.CENTER);
				choiceC = new JRadioButton(q.getQuestionAt(index).getCChoice());
				choiceC.setHorizontalAlignment(SwingConstants.CENTER);
				choiceD = new JRadioButton(q.getQuestionAt(index).getDChoice());
				choiceD.setHorizontalAlignment(SwingConstants.CENTER);
				choiceA.setFont(new Font("Tahoma", Font.PLAIN, 24));
				choiceB.setFont(new Font("Tahoma", Font.PLAIN, 24));
				choiceC.setFont(new Font("Tahoma", Font.PLAIN, 24));
				choiceD.setFont(new Font("Tahoma", Font.PLAIN, 24));
				choiceA.setOpaque(false);
				choiceC.setOpaque(false);
				choiceA.addActionListener(this);
				choiceB.addActionListener(this);
				choiceC.addActionListener(this);
				choiceD.addActionListener(this);
				
						bG.add(choiceA);
						bG.add(choiceB);
						bG.add(choiceC);
						bG.add(choiceD);
						cpanel.setLayout(new GridLayout(2, 2, 0, 0));
						cpanel.add(choiceA);
						cpanel.add(choiceB);
						cpanel.add(choiceC);
						cpanel.add(choiceD);
						
						frame.getContentPane().add(cpanel);
						
								choiceA.setEnabled(false);
								choiceB.setEnabled(false);
								choiceC.setEnabled(false);
								choiceD.setEnabled(false);

		frame.getContentPane().add(qpanel);
<<<<<<< HEAD
		frame.getContentPane().add(cpanel);
=======
		
		
		JLabel moviePoster = new JLabel("");
		URL img;
		BufferedImage imag = null;
		try {
			img = new URL("http://image.tmdb.org/t/p/original/"+q.getQuestionAt(index).getMoviePoster());
			imag = ImageIO.read(img);
			Image scaled = imag.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(scaled);
			moviePoster.setIcon(image);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Image image=GenerateImage.toImage(true);  //this generates an image file
		//ImageIcon icon = new ImageIcon(""+q.getQuestionAt(index).getMoviePoster()); 
		System.out.println(q.getQuestionAt(index).getMoviePoster());
		
		moviePoster.setVisible(true);
		
		moviePoster.setBounds(0, 0, 300, 301);
		qpanel.add(moviePoster);
>>>>>>> 6fe12f74120f33237a713d99dcdaed7e409fb28b
		frame.getContentPane().add(bpanel);

		frame.pack();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		pBar.setStringPainted(false);
		playerterm = new JLabel();
		playerterm.setHorizontalAlignment(SwingConstants.CENTER);
		playerterm.setBounds(297, 316, 169, 48);
		frame.getContentPane().add(playerterm);
		playerterm.setFont(font1);
		frame.setDefaultCloseOperation(0);
	}

	@Override
	public void keyPressed(final KeyEvent e) {
		

		if (nplayer==1) {
			if(e.getKeyCode() == KeyEvent.VK_Z){
			setup();
			playerterm.setText("Player 1");
			player = 1;
			countdown();			
			}
		}
		if (nplayer==2) {
			if(e.getKeyCode() == KeyEvent.VK_Z){
				setup();
				playerterm.setText("Player 1");
				player = 1;
				countdown();			
				}
			if(e.getKeyCode() == KeyEvent.VK_M){
			setup();
			playerterm.setText("Player 2");
			player = 2;
			countdown();
			}
		}

		if (nplayer==3)
		{
			if(e.getKeyCode() == KeyEvent.VK_Z){
				setup();
				playerterm.setText("Player 1");
				player = 1;
				countdown();			
				}
			if(e.getKeyCode() == KeyEvent.VK_M){
			setup();
			playerterm.setText("Player 2");
			player = 2;
			countdown();
			}
			if( e.getKeyCode() == KeyEvent.VK_Q){
			setup();
			playerterm.setText("Player 3");
			player = 3;
			countdown();
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
			q.getQuestionAt(index).setUserAns("A");
		} else if (choiceB.isSelected()) {
			q.getQuestionAt(index).setUserAns("B");
		} else if (choiceC.isSelected()) {
			q.getQuestionAt(index).setUserAns("C");
		} else if (choiceD.isSelected()) {
			q.getQuestionAt(index).setUserAns("D");
		} else
			q.getQuestionAt(index).setUserAns("F");
		
		
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
				if(s.getplayer1()>0)
				s.setplayer1(q.getQuestionAt(index).getScore() * -1);
			} else if (player == 2) {
				if(s.getplayer2()>0)
				s.setplayer2(q.getQuestionAt(index).getScore() * -1);
			} else { 
				if(s.getplayer3()>0)
				s.setplayer3(q.getQuestionAt(index).getScore() * -1);
			}
		}
		
		g.player1Score.setText("" + s.getplayer1());
		g.player2Score.setText("" + s.getplayer2());
		g.player3Score.setText("" + s.getplayer3());
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
				if (count <= 0) {
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
