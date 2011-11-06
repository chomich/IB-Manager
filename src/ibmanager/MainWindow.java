package ibmanager;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import utils.TabbedPaneUI;
import javax.swing.BoxLayout;


public class MainWindow {

	private JFrame frmIBManager;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmIBManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIBManager = new JFrame();
		frmIBManager.setTitle("ICE Manager");
		frmIBManager.setBounds(150, 150, 748, 602);
		frmIBManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		menuBar.setFont(new Font("Arial", Font.PLAIN, 11));
		menuBar.setBackground(SystemColor.controlHighlight);
		frmIBManager.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Program");
		mnNewMenu.setBackground(SystemColor.menu);
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.setBackground(SystemColor.menu);
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu connection = new JMenu("Connection");
		connection.setSelectedIcon(null);
		connection.setFont(new Font("Tahoma", Font.PLAIN, 12));
		connection.setBackground(SystemColor.menu);
		menuBar.add(connection);
		
		JMenuItem mntmConnect = new JMenuItem("Connect...");
		mntmConnect.setBorderPainted(true);
		mntmConnect.setHorizontalTextPosition(SwingConstants.LEADING);
		mntmConnect.setBorder(null);
		mntmConnect.setBackground(SystemColor.menu);
		mntmConnect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnectionView window = new ConnectionView();
				window.setLocation(new Point(frmIBManager.getLocation().x + 200, frmIBManager.getLocation().y + 100));
				window.setVisible(true);
			}
		});
		connection.add(mntmConnect);
		frmIBManager.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new TabbedPaneUI()); 
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JComponent panel1 = makeTextPanel("tables");
		tabbedPane.addTab("Tables", null, panel1, "");
		tabbedPane.setIconAt(0, null);
		DecompositionsView decompositionsView = new DecompositionsView();
		tabbedPane.addTab("Decompositions", null, decompositionsView, "");
		decompositionsView.setLayout(new BoxLayout(decompositionsView, BoxLayout.X_AXIS));
		
		frmIBManager.getContentPane().add(tabbedPane);
				
	}
	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setAutoscrolls(true);
		panel.setBackground(Color.WHITE);
		panel.setFont(new Font("Arial", Font.PLAIN, 11));
		// Create columns names
		return panel;
	}
}
