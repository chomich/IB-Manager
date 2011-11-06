package ibmanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import utils.TabbedPaneUI;


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
		frmIBManager.setBounds(150, 150, 750, 600);
		frmIBManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		frmIBManager.setJMenuBar(new MenuBarView(frmIBManager));
		
		frmIBManager.getContentPane().setLayout(new BorderLayout(0, 0));
		frmIBManager.getContentPane().add(new StatusBarView(), BorderLayout.SOUTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new TabbedPaneUI()); 
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 12));
		
		tabbedPane.addTab("Tables", null, new TableView(), "");
		tabbedPane.setIconAt(0, null);
		
		DecompositionsView decompositionsView = new DecompositionsView();
		tabbedPane.addTab("Decompositions", null, decompositionsView, "");
		decompositionsView.setLayout(new BoxLayout(decompositionsView, BoxLayout.X_AXIS));
		
		frmIBManager.getContentPane().add(tabbedPane);
				
	}
}
