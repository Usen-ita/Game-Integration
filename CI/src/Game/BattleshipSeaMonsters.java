package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BattleshipSeaMonsters {
	private static JButton Button2;
	private static JButton Button;
	private static ImageIcon BKG;
	private static JLabel myLabel;
	private static ImageIcon LGO;
	public static JLabel ScLabel;
	private static JLabel MLabel;
	private static JLabel label;
	private static JLabel Label2;
	//// battleship variables////
	private static Random random = new Random();
	static JButton[][] buttons = new JButton[10][10];
	private static int score = 0;
	private static int moves = 0;
	private static int X = 0;
	private static int Y = 0;
	private static int board_output;
	private static int[][] board = new int[10][10];
	private static int[][] ships = new int[10][10];
	private static int[] shipsLengths = { 2, 3, 3, 4, 5 };
	private static int[][] Kraken = new int[10][10];
	private static int[][] Cetus = new int[10][10];
	private static int[] Monsters = { 1, 2 };
	private static int kill = 0;
	//// ships States////
	private static JLabel ALabel;
	private static JLabel BLabel;
	private static JLabel SLabel;
	private static JLabel DLabel;
	private static JLabel PLabel;
	//// monster States////
	private static JLabel KLabel;
	private static JLabel CLabel;

	public static void main(String[] args) {
		showWindow();
	}

	public static void showWindow() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Audio files
		File backgroundNoise = new File("Battleship Audio/Ocean shore.wav");
		PlaySound(backgroundNoise);

		// Background and icon image
		BKG = new ImageIcon("Battleship UI/GameBackground_03.png");
		myLabel = new JLabel(BKG);
		myLabel.setSize(1280, 720);
		LGO = new ImageIcon("group12logo.jpg");

		// The board
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(10, 10));
		button_panel.setBackground(Color.BLACK);
		button_panel.setBounds(120, 110, 500, 400);

		// The application window.
		JFrame frame = new JFrame("Battleship Sea Monsters");
		frame.setSize(1280, 740); // the (x,y) lengths
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // to make sure closes current JFrame
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setIconImage(LGO.getImage());

		// the Quit button
		Button = new JButton("Quit");
		Button.setBounds(940, 550, 300, 50);
		Button.setFont(new Font("Stencil", Font.PLAIN, 30));
		Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				File click = new File("Battleship Audio/Light switch.wav");
				PlaySound(click);

				frame.setVisible(false);
				GameOver window = new GameOver();
				window.showWindow();
			}
		});

		// Mute button
		/*
		 * Button2 = new JButton("Mute"); Button2.setBounds(940, 600, 200, 50);
		 * Button2.setFont(new Font("Stencil", Font.PLAIN, 30));
		 * Button.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent arg0) { StopSound(backgroundNoise); }
		 * });
		 */

		// Moves Label
		JPanel Mcontainer = new JPanel();
		Mcontainer.setBounds(240, 560, 90, 30);
		MLabel = new JLabel("0");
		MLabel.setBounds(500, 500, 100, 100);
		MLabel.setFont(new Font("Stencil", Font.PLAIN, 30));
		Mcontainer.add(MLabel);

		// Score Label
		JPanel Scontainer = new JPanel();
		Scontainer.setBounds(240, 520, 90, 30);
		ScLabel = new JLabel("0");
		ScLabel.setBounds(500, 500, 100, 100);
		ScLabel.setFont(new Font("Stencil", Font.PLAIN, 30));
		Scontainer.add(ScLabel);

		// The Comment label ("you missed!","My ships was hit!")
		label = new JLabel("");
		label.setBounds(440, 520, 270, 45); // the (x, y, width, height)
		label.setFont(new Font("Stencil", Font.PLAIN, 30));
		label.setForeground(Color.WHITE);

		// The Comment label ("you sank my <ship type>")
		Label2 = new JLabel("");
		Label2.setBounds(440, 560, 540, 45); // the (x, y, width, height)
		Label2.setFont(new Font("Stencil", Font.PLAIN, 15));
		Label2.setForeground(Color.WHITE);

		// killed ships
		PLabel = new JLabel("");
		PLabel.setBounds(820, 430, 60, 40);
		PLabel.setFont(new Font("Stencil", Font.PLAIN, 40));

		DLabel = new JLabel("");
		DLabel.setBounds(820, 365, 100, 40);
		DLabel.setFont(new Font("Stencil", Font.PLAIN, 40));

		SLabel = new JLabel("");
		SLabel.setBounds(820, 300, 100, 40);
		SLabel.setFont(new Font("Stencil", Font.PLAIN, 40));

		BLabel = new JLabel("");
		BLabel.setBounds(820, 240, 140, 40);
		BLabel.setFont(new Font("Stencil", Font.PLAIN, 40));

		ALabel = new JLabel("");
		ALabel.setBounds(820, 160, 180, 40);
		ALabel.setFont(new Font("Stencil", Font.PLAIN, 40));

		// Killed Monsters
		KLabel = new JLabel("");
		KLabel.setBounds(1060, 190, 60, 40);
		KLabel.setFont(new Font("Stencil", Font.PLAIN, 40));

		CLabel = new JLabel("");
		CLabel.setBounds(1060, 260, 60, 40);
		CLabel.setFont(new Font("Stencil", Font.PLAIN, 40));

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttons[i][j] = new JButton();
				button_panel.add(buttons[i][j]);
				buttons[i][j].setFocusable(false);
				buttons[i][j].setBackground(Color.WHITE);
				buttons[i][j].setFont(new Font("Stencil", Font.PLAIN, 10));
				buttons[i][j].addActionListener(new ActionListener() {

					/**
					 *
					 */
					/**
					 *
					 */
					public void actionPerformed(ActionEvent arg0) {

						for (int i = 0; i < 10; i++) {
							for (int j = 0; j < 10; j++) {
								if (arg0.getSource() == buttons[i][j]) {
									if (buttons[i][j].getText() == "") {
										if ((board_output == 0 && ships[i][j] == 0)
												&& (Kraken[i][j] == 0 && Cetus[i][j] == 0)) {

											buttons[i][j].setText("M");
											label.setText("You Missed!");
											score--;
											ScLabel.setText(String.valueOf(score));
											moves++;
											MLabel.setText(String.valueOf(moves));
										} else if (board_output == 1 || ships[i][j] == 1) {

											buttons[i][j].setText("H");
											buttons[i][j].setFont(new Font("Stencil", Font.PLAIN, 20));
											label.setText("My Ship was hit!");
											int x = score;
											x++;
											kill++;
											if (kill == 5) {
												File killsound = new File("Battleship Audio/Rocks.wav");
												PlaySound(killsound);
												ALabel.setText("X X X X X");
												Label2.setText("You sank my Aircraft Crarrier!");
												frame.setVisible(false);
												GameOver window = new GameOver();
												window.showWindow();
												score = x + 10;
											} else if (kill == 4) {
												File killsound = new File("Battleship Audio/Rocks.wav");
												PlaySound(killsound);
												BLabel.setText("X X X X");
												Label2.setText("You sank my Battleship!");
												score = x + 8;
											} else if (kill == 3) {
												File killsound = new File("Battleship Audio/Rocks.wav");
												PlaySound(killsound);
												DLabel.setText("X X X");
												Label2.setText("You sank my Destroyer!");
												score = x + 6;
											} else if (kill == 2) {
												File killsound = new File("Battleship Audio/Rocks.wav");
												PlaySound(killsound);
												SLabel.setText("X X X");
												Label2.setText("You sank my Submarine!");
												score = x + 6;
											} else if (kill == 1) {
												File killsound = new File("Battleship Audio/Rocks.wav");
												PlaySound(killsound);
												PLabel.setText("X X");
												Label2.setText("You sank my Patrol Boat!");
												score = x + 4;
											}
											ScLabel.setText(String.valueOf(score));
											moves++;
											MLabel.setText(String.valueOf(moves));

										} else if (board_output == -1 || Kraken[i][j] == 1) {

											buttons[i][j].setText("K");
											label.setText("Kraken hit!");
											KLabel.setText("X");
											int x = score;
											score = x * 0;
											ScLabel.setText(String.valueOf(score));
											moves++;
											MLabel.setText(String.valueOf(moves));
										} else if (board_output == -2 || Cetus[i][j] == 1) {

											buttons[i][j].setText("C");
											label.setText("Cetus hit!");
											Label2.setText("All ships revived!");
											CLabel.setText("X");
											int x = kill;
											kill = x * 0;
											ALabel.setText("");
											BLabel.setText("");
											DLabel.setText("");
											SLabel.setText("");
											PLabel.setText("");
											// #method for ship placement//
											Formships(X, Y);
											moves++;
											MLabel.setText(String.valueOf(moves));

										}

									}
								}
							}
						}

					}
				});
				board[i][j] = -3;
				buttons[i][j].setText(String.valueOf(board[i][j]));

			}
		}

		////// constructing the frame/////
		frame.add(label); // comments label
		frame.add(Label2);// kill comment
		frame.add(ALabel); // aircraft carrier state label
		frame.add(BLabel); // Battleship state label
		frame.add(DLabel); // Destroyer state label
		frame.add(SLabel); // Submarine state label
		frame.add(PLabel); // Patrol boat state label
		frame.add(KLabel); // Kraken state label
		frame.add(CLabel); // Cetus state label
		frame.add(Mcontainer); // moves panel
		frame.add(Scontainer); // score panel
		frame.add(button_panel); // battleship board
		frame.add(Button); // Quit button
		// frame.add(Button2);// mute button
		frame.add(myLabel); // game background image
		frame.setResizable(false);
		frame.setVisible(true);

		initboard(button_panel);

		Formships(X, Y);

		FormMonsters(X, Y);

	}

	public static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();

		} catch (Exception e) {

		}
	}

	public static void StopSound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.stop();

			JOptionPane.showMessageDialog(null, "Pree OK to Stop sound");
		} catch (Exception e) {

		}
	}

	public static void initboard(JPanel button_panel) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] == -3) {
					buttons[i][j].setText("");
				} else if (board[i][j] == -2) {
					buttons[i][j].setText("C");
					board_output = -2;
					Cetus[i][j] = 1;
				} else if (board[i][j] == -1) {
					buttons[i][j].setText("K");
					board_output = -1;
					Kraken[i][j] = 1;
				} else if (board[i][j] == 0) {
					buttons[i][j].setText("M");
					board_output = 0;
					ships[i][j] = 0;
					Kraken[i][j] = 0;
					Cetus[i][j] = 0;
				} else if (board[i][j] == 1) {
					buttons[i][j].setText("H");
					board_output = 1;
					ships[i][j] = 1;
				}

			}
		}
	}

	public static void Formships(int X, int Y) {

		int shipLength = shipsLengths[4];

		for (int i = 0; i <= shipLength;) {
			X = random.nextInt(10);
			Y = random.nextInt(10);

			if ((X >= 0 && X < 10) && (Y >= 0 && Y < 10) && (board[X][Y] == -3)) {
				ships[X][Y] = 1;
				i++;
			}
		}
	}

	public static void FormMonsters(int X, int Y) {
		int MonstersLength = Monsters[1];

		for (int i = 0; i < MonstersLength;) {
			X = random.nextInt(10);
			Y = random.nextInt(10);

			if ((X >= 0 && X < 10) && (Y >= 0 && Y < 10) && (board[X][Y] == -3)) {

				if (i == 0) {
					Kraken[X][Y] = 1;
				} else if (i == 1) {
					Cetus[X][Y] = 1;
				}

				i++;
			}
		}
	}

}
