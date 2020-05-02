import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

public class Skaler {

	private JFrame frmSkaler;
	private JTextField text_result;
	private JSpinner spinner_is;
	private JSpinner spinner_goal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Skaler window = new Skaler();
					window.frmSkaler.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Skaler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSkaler = new JFrame();
		frmSkaler.setTitle("Skaler");
		frmSkaler.setBounds(100, 100, 216, 199);
		frmSkaler.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		frmSkaler.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmInfo = new JMenuItem("Info");
		mntmInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infowindow();
			}
		});
		mnNewMenu.add(mntmInfo);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mnNewMenu.add(mntmExit);
		frmSkaler.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Is:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 11, 46, 14);
		frmSkaler.getContentPane().add(lblNewLabel);

		JLabel lblZiel = new JLabel("Goal:");
		lblZiel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZiel.setBounds(10, 36, 46, 14);
		frmSkaler.getContentPane().add(lblZiel);

		JLabel lblNewLabel_1 = new JLabel("1:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(66, 11, 20, 14);
		frmSkaler.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("1:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(66, 36, 20, 14);
		frmSkaler.getContentPane().add(lblNewLabel_1_1);

		spinner_is = new JSpinner();
		spinner_is.setModel(new SpinnerNumberModel(new Integer(10), new Integer(1), null, new Integer(1)));
		spinner_is.setBounds(97, 8, 57, 20);
		frmSkaler.getContentPane().add(spinner_is);
		spinner_is.setValue(10);

		spinner_goal = new JSpinner();
		spinner_goal.setModel(new SpinnerNumberModel(new Integer(20), new Integer(1), null, new Integer(1)));
		spinner_goal.setBounds(97, 33, 57, 20);
		frmSkaler.getContentPane().add(spinner_goal);
		spinner_goal.setValue(20);

		JButton btnNewButton = new JButton("Calculate!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				berechne();
			}
		});
		btnNewButton.setBounds(20, 61, 134, 23);
		frmSkaler.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Scaling:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 95, 76, 14);
		frmSkaler.getContentPane().add(lblNewLabel_2);

		text_result = new JTextField();
		text_result.setEditable(false);
		text_result.setBounds(97, 95, 57, 20);
		frmSkaler.getContentPane().add(text_result);
		text_result.setColumns(10);

	}

	/**
	 * Info window
	 */
	protected void infowindow() {
		JOptionPane.showMessageDialog(frmSkaler, "Scaling Calculator by Martin Motschmann\n"
				+ "GitHub: Gnampfer (https://github.com/Gnampfer)", "Info",
				JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * Calculate scaling
	 */
	protected void berechne() {
		try {
			double von = (Integer) spinner_is.getValue();
			double ziel = (Integer) spinner_goal.getValue();

			double res = (1 / ziel) / (1 / von);

			// text_result.setText(Math.round(res * 100) + "%");
			
			final NumberFormat nf = NumberFormat.getInstance();
	        nf.setMaximumFractionDigits(2);
	        text_result.setText(nf.format(new BigDecimal(res * 100)) + "%");
			
			
		} catch (Exception e) {
			text_result.setText("Error");
		}
	}

	/**
	 * Exit application
	 */
	protected void exit() {
		System.exit(0);
	}
}
