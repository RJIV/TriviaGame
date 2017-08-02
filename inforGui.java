package project;

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

public class inforGui {

	private JFrame inforframe;

	/**
	 * Create the application.
	 */
	public inforGui(MovieStats stats) {
		inforframe = new JFrame("Information");
		inforframe.setResizable(false);
		inforframe.setPreferredSize(new Dimension(900, 750));
		inforframe.setBounds(100, 100, 820, 483);
		//inforframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inforframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 814, 455);
		panel.setAutoscrolls(true);
		inforframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel moviename = new JLabel(stats.getMovieTitle());
		moviename.setHorizontalAlignment(SwingConstants.CENTER);
		moviename.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		moviename.setBounds(384, 10, 394, 56);
		panel.add(moviename);
		
		JLabel movieposter = new JLabel();
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
		movieposter.setBounds(36, 34, 312, 386);
		panel.add(movieposter);
		
		JTextArea overview = new JTextArea(stats.getMovieOverview());
		overview.setEditable(false);
		overview.setLineWrap(true);
		overview.setWrapStyleWord(true);
		overview.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		overview.setBounds(384, 87, 394, 129);
		panel.add(overview);
		
		String[] Colomn = {"Actor","Character"};
		JTable actor = new JTable(stats.getCastArray(),Colomn);
		//JTable actor = new JTable();
		actor.setDragEnabled(true);
		actor.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		actor.getTableHeader().setReorderingAllowed(false);
		actor.setFocusable(false);
		panel.add(actor);
		actor.setPreferredScrollableViewportSize(new Dimension(500,50));
		actor.setFillsViewportHeight(true);
		actor.setBounds(386, 266, 392, 154);
		
		
		//JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane = new JScrollPane(actor);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(384, 266, 394, 156);
		panel.add(scrollPane);
		inforframe.getContentPane().add(panel);

		inforframe.setVisible(true);
	}
}
