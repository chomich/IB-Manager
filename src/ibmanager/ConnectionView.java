package ibmanager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ConnectionView extends JDialog {
	private JTextField host;
	private JTextField port;
	private JTextField password;
	private JTextField username;
	public ConnectionView() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 318, 247);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Connect");
				okButton.setEnabled(true);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {						
						Connection.getInstance().connect(host.getText(), port.getText(), username.getText(), password.getText());
						setVisible(false);
					}
				});
				okButton.setFont(new Font("Arial", Font.PLAIN, 11));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Arial", Font.PLAIN, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));
			{
				JLabel lblConnectToIce = new JLabel("Connect to ICE");
				lblConnectToIce.setForeground(new Color(112, 128, 144));
				lblConnectToIce.setFont(new Font("Tahoma", Font.BOLD, 12));
				panel.add(lblConnectToIce);
			}
			{
				JLayeredPane layeredPane = new JLayeredPane();
				panel.add(layeredPane);
				layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.X_AXIS));
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Hostname:");
				lblNewLabel.setBounds(23, 26, 52, 17);
				lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 12));
				panel.add(lblNewLabel);
			}
			{
				host = new JTextField();
				host.setBounds(85, 23, 80, 23);
				host.setFont(new Font("Serif", Font.PLAIN, 12));
				host.setText("localhost");
				panel.add(host);
				host.setColumns(10);
			}
			{
				JLabel lblPort = new JLabel("Port:");
				lblPort.setBounds(175, 26, 33, 17);
				lblPort.setFont(new Font("Serif", Font.PLAIN, 12));
				panel.add(lblPort);
			}
			{
				port = new JTextField();
				port.setBounds(204, 23, 41, 23);
				port.setFont(new Font("Serif", Font.PLAIN, 12));
				port.setText("5029");
				panel.add(port);
				port.setColumns(10);
			}
			
			password = new JTextField();
			password.setFont(new Font("Serif", Font.PLAIN, 12));
			password.setColumns(10);
			password.setBounds(85, 115, 160, 23);
			panel.add(password);
			
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Serif", Font.PLAIN, 12));
			lblPassword.setBounds(23, 118, 52, 17);
			panel.add(lblPassword);
			
			username = new JTextField();
			username.setText("mysql");
			username.setFont(new Font("Serif", Font.PLAIN, 12));
			username.setColumns(10);
			username.setBounds(85, 69, 160, 23);
			panel.add(username);
			
			JLabel lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("Serif", Font.PLAIN, 12));
			lblUsername.setBounds(23, 72, 52, 17);
			panel.add(lblUsername);
		}
	}
}
