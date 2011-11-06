package ibmanager;

import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class MenuBarView extends JMenuBar {

	protected final JFrame frmIBManager;

	public MenuBarView(JFrame frame) {
		this.frmIBManager = frame;
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setFont(new Font("Arial", Font.PLAIN, 11));
		setBackground(SystemColor.controlHighlight);		
		JMenu programMenu = new JMenu("Program");
		programMenu.setBackground(SystemColor.menu);
		programMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(programMenu);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setBackground(SystemColor.menu);
		programMenu.add(exitMenuItem);
		exitMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu connectionMenu = new JMenu("Connection");
		connectionMenu.setSelectedIcon(null);
		connectionMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		connectionMenu.setBackground(SystemColor.menu);
		add(connectionMenu);
		
		JMenuItem connectMenuItem = new JMenuItem("Connect...");
		connectMenuItem.setBorderPainted(true);
		connectMenuItem.setHorizontalTextPosition(SwingConstants.LEADING);
		connectMenuItem.setBorder(null);
		connectMenuItem.setBackground(SystemColor.menu);
		connectMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		connectMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnectionView window = new ConnectionView();
				window.setLocation(new Point(frmIBManager.getLocation().x + 200, frmIBManager.getLocation().y + 100));
				window.setVisible(true);
			}
		});
		connectionMenu.add(connectMenuItem);
	}

}
