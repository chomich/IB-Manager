package ibmanager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class StatusBarView extends JPanel {
	private JLabel connectionStatus;
	public StatusBarView() {
		@SuppressWarnings("unused")
		StatusBarConroller controller = new StatusBarConroller(this);
		
		setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.GRAY));
		setMinimumSize(new Dimension(10, 25));
		setPreferredSize(new Dimension(10, 25));		

		GridBagLayout gbl_statusBar = new GridBagLayout();
		gbl_statusBar.columnWidths = new int[]{732, 0};
		gbl_statusBar.rowHeights = new int[]{24, 0};
		gbl_statusBar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_statusBar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gbl_statusBar);
		
		connectionStatus = new JLabel("Not connected.");
		connectionStatus.setBorder(new MatteBorder(0, 0, 0, 10, (Color) null));
		connectionStatus.setHorizontalTextPosition(SwingConstants.LEFT);
		connectionStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
		connectionStatus.setHorizontalAlignment(SwingConstants.LEFT);
		connectionStatus.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_connectionStatus = new GridBagConstraints();
		gbc_connectionStatus.anchor = GridBagConstraints.EAST;
		gbc_connectionStatus.fill = GridBagConstraints.VERTICAL;
		gbc_connectionStatus.gridx = 0;
		gbc_connectionStatus.gridy = 0;
		add(connectionStatus, gbc_connectionStatus);
	}
	
	public void setConnectionStatus(String status) {
		connectionStatus.setText(status);
	}

}
