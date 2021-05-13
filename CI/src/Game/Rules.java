package Game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Rules {
	private static JButton Button;
	private static ImageIcon Icon1;
	private static JLabel myLabel;
	private static ImageIcon Icon2;
	private static JLabel myLabel2;
	private static ImageIcon LGO;

	public static void main(String[] args) {

		showWindow();

	}

	public static void showWindow() {

		Icon1 = new ImageIcon("Battleship UI/RulesImages_01.jpg");
		Icon2 = new ImageIcon("Battleship UI/RulesImages_02.jpg");
		myLabel = new JLabel(Icon1);
		myLabel.setSize(1280, 720);
		myLabel2 = new JLabel(Icon2);
		myLabel2.setSize(1280, 720);
		LGO = new ImageIcon("group12logo.jpg");

		// The application window.
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("USEN'S Battleship Sea Monsters: Rules");
		frame.setSize(1280, 720); // the (x,y) lengths
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // to make sure everything closes
		frame.setLocationRelativeTo(null);

		JScrollPane scroller = new JScrollPane(panel);
		scroller.setViewportView(panel);

		panel.setLayout(new GridLayout(2, 1, 70, 0));
		panel.setSize(1280, 720);
		panel.add(myLabel);
		panel.add(myLabel2);

		frame.setLocationRelativeTo(null);
		frame.add(scroller);
		frame.setIconImage(LGO.getImage());

		// the button
		Button = new JButton("START");
		Button.setBounds(140, 50, 300, 50);
		Button.setFont(new Font("Stencil", Font.BOLD, 30));
		Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				File paper_crumble = new File("Battleship Audio/Paper crumble.wav");
				PlaySound(paper_crumble);

				frame.setVisible(false);
				BattleshipSeaMonsters window = new BattleshipSeaMonsters();
				window.showWindow();
			}
		});
		frame.add(BorderLayout.SOUTH, Button);
		frame.setResizable(false);

		frame.setVisible(true);
	}

	public static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();

			Thread.sleep(clip.getMicrosecondLength() / 1000);
		} catch (Exception e) {

		}
	}
}
