package ibmanager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TableView extends JPanel {

	public TableView() {
		setAlignmentY(Component.BOTTOM_ALIGNMENT);
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setAutoscrolls(true);
		setBackground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 11));
	}
}
