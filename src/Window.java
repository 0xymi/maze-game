package mazegamegui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

public class Window extends JFrame {

	private static final long serialVersionUID = -5898704224798065935L;
	private static JLabel jLabel1 = new JLabel();
	private static JLabel jLabel2 = new JLabel();
	private static JLabel jLabel3 = new JLabel();
	private static JLabel jLabel4 = new JLabel();
	private static JLabel jLabel5 = new JLabel();
	private static JLabel jLabel6 = new JLabel();
	private static JLabel jLabel7 = new JLabel();
	private static JLabel jLabel8 = new JLabel();
	private static JLabel jLabel9 = new JLabel();
	private static JLabel jLabel10 = new JLabel();
	private static JLabel jLabel11 = new JLabel();
	private static JLabel jLabel12 = new JLabel();
	private static JLabel jLabel13 = new JLabel();
	private static JLabel jLabel14 = new JLabel();
	private static JLabel jLabel15 = new JLabel();
	private static JLabel jLabel16 = new JLabel();
	private static JLabel jLabel17 = new JLabel();
	private static JLabel counterLabel = new JLabel();

	public Window() {
		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Map map = new Map();
		Coord coord = new Coord(map);
		int width = 20 * (map.map[0].length() + 1) - 5; // 20 * (char+1) - 5
		int frameWidth = 20 * (map.map[0].length() + 1 + 12) - 5;
		int frameHeight = 432;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setTitle("Maze Game");
		setResizable(false);
		int fontSize = 28;
		Container cp = getContentPane();
		cp.setLayout(null);

		cp.setBackground(Color.BLACK);
		jLabel1.setBounds(0, 0, width, fontSize);
		jLabel1.setText("");
		jLabel1.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel1.setForeground(Color.WHITE);
		cp.add(jLabel1);
		jLabel2.setBounds(0, 23, width, fontSize);
		jLabel2.setText("");
		jLabel2.setEnabled(true);
		jLabel2.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel2.setForeground(Color.WHITE);
		cp.add(jLabel2);
		jLabel3.setBounds(0, 46, width, fontSize);
		jLabel3.setText("");
		jLabel3.setEnabled(true);
		jLabel3.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel3.setForeground(Color.WHITE);
		cp.add(jLabel3);
		jLabel4.setBounds(0, 69, width, fontSize);
		jLabel4.setText("");
		jLabel4.setEnabled(true);
		jLabel4.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel4.setForeground(Color.WHITE);
		cp.add(jLabel4);
		jLabel5.setBounds(0, 92, width, fontSize);
		jLabel5.setText("");
		jLabel5.setEnabled(true);
		jLabel5.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel5.setForeground(Color.WHITE);
		cp.add(jLabel5);
		jLabel6.setBounds(0, 115, width, fontSize);
		jLabel6.setText("");
		jLabel6.setEnabled(true);
		jLabel6.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel6.setForeground(Color.WHITE);
		cp.add(jLabel6);
		jLabel7.setBounds(0, 138, width, fontSize);
		jLabel7.setText("");
		jLabel7.setEnabled(true);
		jLabel7.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel7.setForeground(Color.WHITE);
		cp.add(jLabel7);
		jLabel8.setBounds(0, 161, width, fontSize);
		jLabel8.setText("");
		jLabel8.setEnabled(true);
		jLabel8.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel8.setForeground(Color.WHITE);
		cp.add(jLabel8);
		jLabel9.setBounds(0, 184, width, fontSize);
		jLabel9.setText("");
		jLabel9.setEnabled(true);
		jLabel9.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel9.setForeground(Color.WHITE);
		cp.add(jLabel9);
		jLabel10.setBounds(0, 207, width, fontSize);
		jLabel10.setText("");
		jLabel10.setEnabled(true);
		jLabel10.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel10.setForeground(Color.WHITE);
		cp.add(jLabel10);
		jLabel11.setBounds(0, 230, width, fontSize);
		jLabel11.setText("");
		jLabel11.setEnabled(true);
		jLabel11.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel11.setForeground(Color.WHITE);
		cp.add(jLabel11);
		jLabel12.setBounds(0, 253, width, fontSize);
		jLabel12.setText("");
		jLabel12.setEnabled(true);
		jLabel12.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel12.setForeground(Color.WHITE);
		cp.add(jLabel12);
		jLabel13.setBounds(0, 276, width, fontSize);
		jLabel13.setText("");
		jLabel13.setEnabled(true);
		jLabel13.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel13.setForeground(Color.WHITE);
		cp.add(jLabel13);
		jLabel14.setBounds(0, 299, width, fontSize);
		jLabel14.setText("");
		jLabel14.setEnabled(true);
		jLabel14.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel14.setForeground(Color.WHITE);
		cp.add(jLabel14);
		jLabel15.setBounds(0, 322, width, fontSize);
		jLabel15.setText("");
		jLabel15.setEnabled(true);
		jLabel15.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel15.setForeground(Color.WHITE);
		cp.add(jLabel15);
		jLabel16.setBounds(0, 345, width, fontSize);
		jLabel16.setText("");
		jLabel16.setEnabled(true);
		jLabel16.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel16.setForeground(Color.WHITE);
		cp.add(jLabel16);
		jLabel17.setBounds(0, 368, width, fontSize);
		jLabel17.setText("");
		jLabel17.setEnabled(true);
		jLabel17.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		jLabel17.setForeground(Color.WHITE);
		cp.add(jLabel17);

		counterLabel.setBounds(width, 0, 20 * (12 + 1) - 5, fontSize);
		counterLabel.setText("");
		counterLabel.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		counterLabel.setForeground(Color.WHITE);
		cp.add(counterLabel);

		setVisible(true);

		JLabel[] l = new JLabel[18];
		l[0] = jLabel1;
		l[1] = jLabel2;
		l[2] = jLabel3;
		l[3] = jLabel4;
		l[4] = jLabel5;
		l[5] = jLabel6;
		l[6] = jLabel7;
		l[7] = jLabel8;
		l[8] = jLabel9;
		l[9] = jLabel10;
		l[10] = jLabel11;
		l[11] = jLabel12;
		l[12] = jLabel13;
		l[13] = jLabel14;
		l[14] = jLabel15;
		l[15] = jLabel16;
		l[16] = jLabel17;
		l[17] = counterLabel;

		l[0].setText(map.map[0]);
		l[1].setText(map.map[1]);
		l[2].setText(map.map[2]);
		l[3].setText(map.map[3]);
		l[4].setText(map.map[4]);
		l[5].setText(map.map[5]);
		l[6].setText(map.map[6]);
		l[7].setText(map.map[7]);
		l[8].setText(map.map[8]);
		l[9].setText(map.map[9]);
		l[10].setText(map.map[10]);
		l[11].setText(map.map[11]);
		l[12].setText(map.map[12]);
		l[13].setText(map.map[13]);
		l[14].setText(map.map[14]);
		l[15].setText(map.map[15]);
		l[16].setText(map.map[16]);

		Event event = new Event(map, coord, l);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (event.canType) {
					int keyCode = e.getKeyCode();
					switch (keyCode) {
					case KeyEvent.VK_W:
						try {
							event.w(map, coord, event, l);
						} catch (IOException | InterruptedException e1) {
							e1.printStackTrace();
						}
						break;
					case KeyEvent.VK_A:
						try {
							event.a(map, coord, event, l);
						} catch (IOException | InterruptedException e1) {
							e1.printStackTrace();
						}
						break;
					case KeyEvent.VK_S:
						try {
							event.s(map, coord, event, l);
						} catch (IOException | InterruptedException e1) {
							e1.printStackTrace();
						}
						break;
					case KeyEvent.VK_D:
						try {
							event.d(map, coord, event, l);
						} catch (IOException | InterruptedException e1) {
							e1.printStackTrace();
						}
						break;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				event.canType = true;
			}

		});
	}

}
