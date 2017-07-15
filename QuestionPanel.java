package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class QuestionPanel extends JFrame implements ActionListener,KeyListener {

	private JTextArea question;
	private JLabel playerterm;
	private int[] player;
	private JPanel Qpanel;
	private JPanel Cpanel;
	private JFrame frame;
	private JLabel timer;
	private JRadioButton choiceA;
	private JRadioButton choiceB;
	private JRadioButton choiceC;
	private JRadioButton choiceD;
	private JButton submit;
	private  ButtonGroup bG;
	QGenerator q;
	Countdown count;
	
	public QuestionPanel(int index){
		JOptionPane.showMessageDialog(frame,"Player1 press z player 2 press m");
		player = new int[2];
		q = new QGenerator();
		q.createQSet();
		frame = new JFrame();
		Qpanel = new JPanel();
		Cpanel = new JPanel();
		bG = new ButtonGroup();
		playerterm = new JLabel();
		submit = new JButton();
		submit.addActionListener(this);

		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);
		
		
		question = new JTextArea(10,40);
		question.setFont(font1);
		question.setText(q.getQuestionAt(index).getQue());
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setBackground(Color.LIGHT_GRAY);
		question.setEditable(false);
		timer = new JLabel();

		
		choiceA = new JRadioButton(q.getQuestionAt(index).getAChoice());
		choiceB = new JRadioButton(q.getQuestionAt(index).getBChoice());
		choiceC = new JRadioButton(q.getQuestionAt(index).getCChoice());
		choiceD = new JRadioButton(q.getQuestionAt(index).getDChoice());
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
		
		frame.add(Qpanel,BorderLayout.NORTH);
		frame.add(Cpanel,BorderLayout.SOUTH);		
	    frame.pack();
	    frame.setSize(1000, 600);
	    frame.setLocationRelativeTo(null);
	    frame.add(submit);
	    
	    frame.setVisible(true);
	    choiceA.setEnabled(false);
	    choiceB.setEnabled(false);
	    choiceC.setEnabled(false);
	    choiceD.setEnabled(false);
	    frame.addKeyListener(this); 
	    frame.setFocusable(true);
	    //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    
	    }
	    
	@Override
	 public void keyTyped( KeyEvent e ) {
     }
	 
	 @Override
     public void keyPressed( KeyEvent e ) {
     	if(e.getKeyCode() == KeyEvent.VK_Z){
    	    choiceA.setEnabled(true);
    	    choiceB.setEnabled(true);
    	    choiceC.setEnabled(true);
    	    choiceD.setEnabled(true);
    	    playerterm.setText("Player 1");
    	    
     	}
     	 if(e.getKeyCode() == KeyEvent.VK_M){
    	    choiceA.setEnabled(true);
    	    choiceB.setEnabled(true);
    	    choiceC.setEnabled(true);
    	    choiceD.setEnabled(true);
    	    playerterm.setText("Player 2");
     	}
     		
     	 if(e.getKeyCode() == KeyEvent.VK_Q){
     	    choiceA.setEnabled(true);
     	    choiceB.setEnabled(true);
     	    choiceC.setEnabled(true);
     	    choiceD.setEnabled(true);
     	    playerterm.setText("Player 3");
      	}
     }
	 
	 @Override
     public void keyReleased( KeyEvent e ) {

     }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			player[0]=100;
		}
	}
	
	public int getPlayerScore(){
		return player[0];
	}

	
	public static void main(String arg[]) {
		QuestionPanel gui = new QuestionPanel(10);

	}

}
