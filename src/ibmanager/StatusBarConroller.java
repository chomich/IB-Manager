package ibmanager;

import java.util.Observable;
import java.util.Observer;

public class StatusBarConroller implements Observer {

	private StatusBarView view;
	
	public StatusBarConroller(StatusBarView view) {
		this.view = view;
		Connection.getInstance().addObserver(this);
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(Connection.getInstance().isConnected())
			view.setConnectionStatus("Connected.");
		else
			view.setConnectionStatus("Not connected.");
	}

}
