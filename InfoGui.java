package edu.gvsu.cis350.triviaGame;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class InfoGui {

	private JFrame inforframe;

	/**
	 * Create the application.
	 */
	public InfoGui(MovieStats stats) {
		inforframe = new JFrame("Information");
		inforframe.setResizable(false);
		inforframe.setPreferredSize(new Dimension(900, 750));
		inforframe.setBounds(100, 100, 820, 626);
		//inforframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inforframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 16, 814, 505);
		panel.setAutoscrolls(true);
		inforframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel moviename = new JLabel(stats.getMovieTitle());
		moviename.setHorizontalAlignment(SwingConstants.CENTER);
		moviename.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		moviename.setBounds(66, 0, 682, 73);
		panel.add(moviename);
		
		JLabel movieposter = new JLabel();
		movieposter.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		URL img;
		BufferedImage imag = null;
		try {
			img = new URL("http://image.tmdb.org/t/p/original/"+stats.getMoviePoster());
			imag = ImageIO.read(img);
			Image scaled = imag.getScaledInstance(312, 386, Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(scaled);
			movieposter.setIcon(image);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(stats.getMoviePoster());
		
		movieposter.setVisible(true);
		movieposter.setBounds(36, 100, 312, 368);
		panel.add(movieposter);
		
		JTextArea overview = new JTextArea(stats.getMovieOverview());
		overview.setEditable(false);
		overview.setLineWrap(true);
		overview.setWrapStyleWord(true);
		overview.setFont(new Font("Tahoma", Font.PLAIN, 20));
		overview.setBounds(384, 100, 394, 164);
		panel.add(overview);
		
		String[] Colomn = {"Actor","Character"};
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(384, 280, 394, 188);
		panel.add(scrollPane);
		JTable actor = new JTable(stats.getCastArray(),Colomn);
		actor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(actor);
		actor.setDragEnabled(true);
		actor.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		actor.getTableHeader().setReorderingAllowed(false);
		actor.setFocusable(false);
		actor.setPreferredScrollableViewportSize(new Dimension(500,50));
		actor.setFillsViewportHeight(true);
		inforframe.getContentPane().add(panel);

		inforframe.setVisible(true);
	}
}
