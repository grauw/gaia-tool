package nl.grauw.gaia.tool.mvc;

/**
 * This interface is intended for observers that need to be notified on the AWT event thread.
 * 
 * AWT observers are also weakly referenced, allowing them to get garbage collected if they
 * are no longer referenced elsewhere, making un-registering unnecessary.
 */
public interface AWTObserver {
	
	/**
	 * Invoked when the state of an observed object changes.
	 * @param source The observed object.
	 * @param detail Object providing details on the state change.
	 */
	public void update(Observable source, Object detail);
	
}
