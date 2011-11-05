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

@SuppressWarnings("serial")
public class DecompositionsView extends JPanel {
	DecompositionsModel model;
	private JTable table;
	final String columnNames[] = { "ID", "Rule", "Comments" };
	
	public DecompositionsView() {
		model = new DecompositionsModel(this);
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		table = new JTable(tableModel);		
		setAlignmentY(Component.BOTTOM_ALIGNMENT);
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setAutoscrolls(true);
		setBackground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 11));
		
		//IceConnection.getInstance().connect();
		JScrollPane scrollPane = new JScrollPane(table);
		add( scrollPane, "cell 0 0,grow" );
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
