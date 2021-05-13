package Game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver {
	private static JButton Button2;
	private static ImageIcon BKG;
	private static ImageIcon LGO;
	private static JLabel myLabel;
	private static JLabel SLabel2;

	public static void main(String[] args) {
		showWindow();
	}

	@SuppressWarnings("removal")
	public static void showWindow() {
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BKG = new ImageIcon("Battleship UI/QuiteBackground.jpg");
		myLabel = new JLabel(BKG, JLabel.CENTER);
		myLabel.setSize(1280, 720);
		LGO = new ImageIcon("group12logo.jpg");

		// The application window.
		JFrame frame = new JFrame("Battleship Sea Monsters: GameOver");
		frame.setSize(1280, 720); // the (x,y) lengths
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // to make sure everything closes
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);

		// Score Label
		JPanel Scontainer = new JPanel();
		Scontainer.setBounds(430, 210, 410, 250);
		SLabel2 = new JLabel();
		SLabel2 = BattleshipSeaMonsters.ScLabel;
		SLabel2.setBounds(500, 500, 350, 250);
		SLabel2.setFont(new Font("Stencil", Font.PLAIN, 300));
		Scontainer.add(SLabel2);

		// the button2
		Button2 = new JButton("Play Again");
		Button2.setBounds(470, 530, 300, 50);
		Button2.setFont(new Font("Stencil", Font.PLAIN, 30));
		Button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Rules window = new Rules();
				window.showWindow();
			}
		});

		////// constructing the frame/////
		frame.setIconImage(LGO.getImage());
		frame.add(Button2);
		frame.add(Scontainer);
		frame.add(myLabel);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
