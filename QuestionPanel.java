package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class QuestionPanel extends JFrame implements ActionListener,KeyListener {

	private JLabel question;
	private JPanel Qpanel;
	private JPanel Cpanel;
	private JFrame frame;
	private JLabel timer;
	private JRadioButton choiceA;
	private JRadioButton choiceB;
	private JRadioButton choiceC;
	private JRadioButton choiceD;
	private  ButtonGroup bG;
	Questions q;
	Countdown count;
	
	public QuestionPanel(){
		JOptionPane.showMessageDialog(frame,"Player1 press z player 2 press m");
		q = new Questions();
		frame = new JFrame();
		Qpanel = new JPanel();
		Cpanel = new JPanel();
		bG = new ButtonGroup();
		
		
		Font font1 = new Font("Tahoma", Font.CENTER_BASELINE, 18);
		
		
		question = new JLabel(q.getQue());
		question.setFont(font1);
		timer = new JLabel();

		
		choiceA = new JRadioButton(q.getAChoice());
		choiceB = new JRadioButton(q.getBChoice());
		choiceC = new JRadioButton(q.getCChoice());
		choiceD = new JRadioButton(q.getDChoice());
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
	    frame.setSize(600, 200);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    choiceA.setEnabled(false);
	    choiceB.setEnabled(false);
	    choiceC.setEnabled(false);
	    choiceD.setEnabled(false);
	    
	    frame.addKeyListener(this); 
	    frame.setFocusable(true);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
    	    
     	}
     	 if(e.getKeyCode() == KeyEvent.VK_M){
    	    choiceA.setEnabled(true);
    	    choiceB.setEnabled(true);
    	    choiceC.setEnabled(true);
    	    choiceD.setEnabled(true);
     	}
     		 
     }
	 
	 @Override
     public void keyReleased( KeyEvent e ) {

     }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String arg[]) {
		QuestionPanel gui = new QuestionPanel();


	}

}
