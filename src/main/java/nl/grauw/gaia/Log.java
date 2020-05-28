package nl.grauw.gaia;

import java.util.EventListener;

import nl.grauw.gaia.util.ListenerList;

public class Log {
	
	private StringBuffer log;
	
	private ListenerList<LogUpdateListener> updateListeners = new ListenerList<LogUpdateListener>();
	
	public Log() {
		log = new StringBuffer();
	}
	
	public void log(Object message) {
		log.append(message.toString());
		log.append("\n");
		
		fireLogUpdate();
	}
	
	public String getLog() {
		return log.toString();
	}
	
	public void addUpdateListener(LogUpdateListener listener) {
		updateListeners.add(listener);
	}
	
	public void removeUpdateListener(LogUpdateListener listener) {
		updateListeners.remove(listener);
	}
	
	private void fireLogUpdate() {
		for (LogUpdateListener listener : updateListeners)
			listener.onLogUpdate(this);
	}
	
	public interface LogUpdateListener extends EventListener {
		public void onLogUpdate(Log source);
	}
	
}
