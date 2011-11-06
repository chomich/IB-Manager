package ibmanager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.Triple;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class DecompositionsView extends JPanel {
	DecompositionsModel model;
	private JTable table;
	final String columnNames[] = { "ID", "Rule", "Comments" };
	
	public DecompositionsView() {
		model = new DecompositionsModel(this);
		setAlignmentY(Component.BOTTOM_ALIGNMENT);
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setAutoscrolls(true);
		setBackground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 11));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		table = new JTable(new DefaultTableModel( new Object[][] {}, columnNames));
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		scrollPane.setBackground(Color.WHITE);
	}
	
	public void setValues(List<Triple<String>> values) {
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		Iterator<Triple<String>> it = values.iterator();
		while (it.hasNext()) {
			Triple<String> row = (Triple<String>)it.next();
			tableModel.addRow(new Object[]{row.first, row.second, row.third});
		}
	}
}
