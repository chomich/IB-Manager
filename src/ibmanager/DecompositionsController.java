package ibmanager;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import utils.Triple;

public class DecompositionsController implements Observer {

	DecompositionsView view;
	
	public DecompositionsController(DecompositionsView view) {
		this.view = view;
		Connection.getInstance().addObserver(this);
	}

	public void update(Observable arg0, Object arg1) {
		List<Triple<String>> data = new ArrayList<Triple<String>>();
		if(Connection.getInstance().isConnected()) {
			try {
				ResultSet result = Connection.getInstance().executeQuery("select * from sys_infobright.decomposition_dictionary");
				while(result.next())
					data.add(new Triple<String>(result.getString(1), result.getString(2), result.getString(3)));
			} catch (SQLException e) {
				System.err.println("Failed to get the list of decomposition rules. " + e.getMessage());
			}
		}
		view.setValues(data);
	}

}
