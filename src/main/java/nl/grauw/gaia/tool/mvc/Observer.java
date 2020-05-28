package nl.grauw.gaia.tool.mvc;

public interface Observer {
	
	/**
	 * Invoked when the state of an observed object changes.
	 * @param source The observed object.
	 * @param detail Object providing details on the state change.
	 */
	public void update(Observable source, Object detail);
	
}
