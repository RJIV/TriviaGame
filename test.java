package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class test {

	private JFrame welcomeframe;
	private JTextField greeting;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.welcomeframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		welcomeframe = new JFrame();
		welcomeframe.setBounds(100, 100, 450, 300);
		welcomeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		bpanel1.add(dual);
		
		JRadioButton multi = new JRadioButton("Three");
		multi.setForeground(Color.GREEN);
		multi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		multi.setBounds(273, 117, 111, 38);
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
		
		greeting = new JTextField();
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setFont(new Font("Times New Roman", Font.BOLD, 26));
		greeting.setForeground(Color.YELLOW);
		greeting.setBackground(Color.BLUE);
		greeting.setBounds(10, 5, 414, 62);
		greeting.setText("Welcome to Trivia Game");
		lpanel.add(greeting);
		greeting.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		welcomeframe.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmGoBack = new JMenuItem("Go back");
		mnMenu.add(mntmGoBack);
	}
}
