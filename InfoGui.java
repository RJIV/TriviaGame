//package edu.gvsu.cis350.triviaGame;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import info.movito.themoviedbapi.model.Video;

import java.awt.Color;
import javax.swing.JButton;

public class InfoGui implements ActionListener {

	private JFrame inforframe;
	private JButton quitButton;
	private JButton trailerButton;
	private JPanel panel;
	private JLabel movieName;
	private JLabel moviePoster;
	private JScrollPane scrollPane;
	private JTable actor;
	private JTextArea overview;
	private MovieStats stats;
	/**
	 * Create the application.
	 */
	public InfoGui (MovieStats stats) {
		this.stats = stats;
		inforframe = new JFrame("Information");
		inforframe.setResizable(false);
		inforframe.setPreferredSize(new Dimension(900, 750));
		inforframe.setBounds(100, 100, 820, 626);
		inforframe.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 16, 814, 505);
		panel.setAutoscrolls(true);
		inforframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		movieName = new JLabel(stats.getMovieTitle());
		movieName.setHorizontalAlignment(SwingConstants.CENTER);
		movieName.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		movieName.setBounds(66, 0, 682, 73);
		panel.add(movieName);
		
		moviePoster = new JLabel();
		moviePoster.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		URL img;
		BufferedImage imag = null;
		try {
			img = new URL("http://image.tmdb.org/t/p/original/"+stats.getMoviePoster());
			imag = ImageIO.read(img);
			Image scaled = imag.getScaledInstance(312, 386, Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(scaled);
			moviePoster.setIcon(image);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		moviePoster.setVisible(true);
		moviePoster.setBounds(36, 100, 312, 368);
		panel.add(moviePoster);
		
		overview = new JTextArea(stats.getMovieOverview());
		overview.setEditable(false);
		overview.setLineWrap(true);
		overview.setWrapStyleWord(true);
		overview.setFont(new Font("Tahoma", Font.PLAIN, 18));
		overview.setBounds(384, 100, 394, 164);
		panel.add(overview);
		
		String[] Colomn = {"Actor","Character"};
		
		
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(384, 280, 394, 188);
		panel.add(scrollPane);
		actor = new JTable(stats.getCastArray(),Colomn);
		actor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(actor);
		actor.setDragEnabled(true);
		actor.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		actor.getTableHeader().setReorderingAllowed(false);
		actor.setFocusable(false);
		actor.setPreferredScrollableViewportSize(new Dimension(500,50));
		actor.setFillsViewportHeight(true);
		inforframe.getContentPane().add(panel);
		
		trailerButton = new JButton("View Trailer");
		trailerButton.setBounds(112, 523, 161, 33);
		trailerButton.addActionListener(this);
		inforframe.getContentPane().add(trailerButton);
		
		quitButton = new JButton("Close Window");
		quitButton.setBounds(501, 523, 161, 33);
		quitButton.addActionListener(this);
		inforframe.getContentPane().add(quitButton);

		inforframe.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == quitButton){
			inforframe.dispose();
		}
		if (e.getSource() == trailerButton){
			List<Video> trailer = stats.getTrailers();
			String videoURL = "http://www.youtube.com/watch?v=" + trailer.get(0).getKey();
			System.out.println(videoURL);
			URL url = null;
			try {
				url = new URL(videoURL);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			YouTubeViewer trailerWindow = new YouTubeViewer(videoURL);
			
		}
	}
}
