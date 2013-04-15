package zing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import zing.model.Song;
import zing.sites.MusicSite;


public class FrameLyric extends JFrame {
	private static final long serialVersionUID = -2675197512423718784L;
	JTextPane lyric;
	JScrollPane scrollPane;
	MusicSite musicSite;
	
	public FrameLyric(MusicSite musicSite) {
		this.musicSite = musicSite;
		
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("/images/lyrics.png"))));
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(Box.createRigidArea(new Dimension(5, 0)), BorderLayout.WEST);
		container.add(Box.createRigidArea(new Dimension(5, 0)), BorderLayout.EAST);
		container.add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.NORTH);
		container.add(scrollPane = new JScrollPane(lyric = new JTextPane()));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		lyric.setEditable(false);
		lyric.setContentType("text/html");
		container.add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.SOUTH);
	}
	
	public void setLyric(final Song song){
		if (song.link.equals("")){
			lyric.setText("<h1 style='color: blue; text-align:center;'>Not found lyric<h1>");
			return;
		}
		lyric.setText("<h1 style='color: blue; text-align:center;'>Searching lyric...</h1");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					List<String> lyrics = musicSite.getLyric(song);
					if (lyrics.isEmpty()){
						lyric.setText("<h1 style='text-align:center; color: blue;'>Not found lyric<h1>");
						return; 
					}
					lyric.setText(getLyric(lyrics));
//					System.out.println(lyrics);
//					for (String str : lyrics){
//						lyric.setText(str);
//					}
					lyric.setCaretPosition(0);
				} catch (IOException e) {
					lyric.setText("<h1 style='text-align:center; color: blue;'>Error connect to server<h1>");
					e.printStackTrace();
				}
			}
		});
		
	}

	private String getLyric(List<String> lyrics) {
		String ret = "";
		int index = 0;
		for (String lyric: lyrics){
			if (index % 2 == 0){
				ret += "<p style='padding:0; margin:0; font-size: 16px;'>" + lyric + "</p>";
			}else{
				ret += "<p style='padding:0; margin:0; background: #eeeeee; font-size: 16px;'>" + lyric + "</p>";
			}
			index++;
		}
		return ret;
	}
}
