package G12Y;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Game.Rules;
import HangmanA.hangmanA;
import HangmanB.hangman;
import MastermindA.MastermindGame;
import MastermindB.Main;
import SnakesAndLaddersA.MainS;
import SnakesAndLaddersB.SnakesLadders;

public class MainMenu {

	private static JButton HAbutton;
	private static JButton HBbutton;
	private static JButton SLAbutton;
	private static JButton SLBbutton;
	private static JButton MAbutton;
	private static JButton MBbutton;
	private static JButton BBbutton;
	private static ImageIcon LGO;
	private static ImageIcon BKG;
	private static JLabel BKGlabel;

	public static void main(String[] args) {

		Play();

	}

	public static void Play() {
		// Background and logo images
		LGO = new ImageIcon("group12logo.jpg");
		BKG = new ImageIcon("BumblebeeBackground.png");
		BKGlabel = new JLabel(BKG);
		BKGlabel.setSize(1280, 720);

		// Background audio. Reference from
		// http://www.moviesoundclips.net/sound.php?id=111
		File OutdoorAudio = new File("Main menu audio/Transformers Theme Song Original.wav");
		PlaySound(OutdoorAudio);

		JPanel gpanel = new JPanel();
		JFrame gframe = new JFrame("Group 12 Yellow: Main Menu");
		gframe.setSize(1200, 720); // the (x,y) lengths
		gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to make sure everything closes
		gframe.setLocationRelativeTo(null);
		gframe.setLayout(null);

		gpanel.setLayout(new GridLayout(7, 1, 0, 0));
		gpanel.setBounds(520, 50, 600, 600);

		// Hangman Variation A Button
		HAbutton = new JButton("Hangman Variation A");
		HAbutton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		HAbutton.setBackground(new Color(242, 229, 48)); // (new Color(80, 88, 242));
		HAbutton.setForeground(new Color(140, 96, 42));
		HAbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInternalMessageDialog(null, "View Anmol's code on Java Eclipse Console");
				hangmanA HangmanA = new hangmanA();
				HangmanA.main(null);

			}
		});
		gpanel.add(HAbutton);

		// Hangman Variation B Button
		HBbutton = new JButton("Hangman Variation B");
		HBbutton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		HBbutton.setBackground(new Color(242, 213, 65)); // (new Color(46, 52, 166));
		HBbutton.setForeground(Color.WHITE);
		HBbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInternalMessageDialog(null, "View Vivek's code on Java Eclipse Console");

				hangman HangmanB = new hangman();
				try {
					HangmanB.main(null);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});
		gpanel.add(HBbutton);

		// Snakes & Ladders Variation A Button
		SLAbutton = new JButton("Snakes & Ladders Variation A");
		SLAbutton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		SLAbutton.setBackground(new Color(166, 123, 45));// (new Color(195, 217, 23));
		SLAbutton.setForeground(Color.WHITE);
		SLAbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInternalMessageDialog(null, "View on Rayan's Java Eclipse Console");
				MainS SLAWindow = new MainS();
				SLAWindow.main(null);

			}
		});
		gpanel.add(SLAbutton);

		// Snakes & Ladders Variation B button
		SLBbutton = new JButton("Snakes & Ladders Variation B");
		SLBbutton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		SLBbutton.setBackground(new Color(140, 96, 42));// (new Color(52, 82, 23));
		SLBbutton.setForeground(Color.WHITE);
		SLBbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInternalMessageDialog(null, "View David's code on Java Eclipse Console");
				SnakesLadders SLBWindow = new SnakesLadders();
				SLBWindow.main(null);
			}
		});
		gpanel.add(SLBbutton);

		// Mastermind Variation A button
		MAbutton = new JButton("Mastermind Variation A");
		MAbutton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		MAbutton.setBackground(new Color(166, 123, 45)); // (new Color(242, 61, 61));
		MAbutton.setForeground(Color.WHITE);
		MAbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInternalMessageDialog(null, "View Yusuf's code on Java Eclipse Console");
				MastermindGame MastermindA = new MastermindGame();
				MastermindA.main(null);
			}
		});
		gpanel.add(MAbutton);

		// Mastermind Variation B button
		MBbutton = new JButton("Mastermind Variation B");
		MBbutton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		MBbutton.setBackground(new Color(242, 213, 65)); // (new Color(195, 217, 23));
		MBbutton.setForeground(Color.WHITE);
		MBbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInternalMessageDialog(null, "View Nehal's code on Java Eclipse Console");
				Main MastermindB = new Main();
				MastermindB.main(null);
			}
		});
		gpanel.add(MBbutton);

		// Battleship Variation B button
		BBbutton = new JButton("Battleship Variation B");
		BBbutton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		BBbutton.setBackground(new Color(242, 229, 48)); // (new Color(52, 82, 23));
		BBbutton.setForeground(new Color(140, 96, 42));
		BBbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Rules window = new Rules();
				window.showWindow();
			}
		});
		gpanel.add(BBbutton);

		/// Setting up frame///
		gframe.add(gpanel);
		gframe.add(BKGlabel);
		gframe.setIconImage(LGO.getImage());
		gframe.setResizable(false);
		gframe.setVisible(true);

	}

	public static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();

		} catch (Exception e) {

		}
	}

}
