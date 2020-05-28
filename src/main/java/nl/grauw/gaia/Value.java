package nl.grauw.gaia;

import nl.grauw.gaia.Parameters.ParameterChange;

public class Value {
	
	protected Parameters parameters;
	protected int offset;
	
	public Value(Parameters parameters, int offset) {
		this.parameters = parameters;
		this.offset = offset;
	}
	
	public Parameters getParameters() {
		return parameters;
	}
	
	/**
	 * Determine whether the value has changed based on information received from
	 * a Parameter observable update notification.
	 * 
	 * @param source The source of the update.
	 * @param change The update’s event object.
	 * @return True if the value has changed.
	 */
	public boolean testChanged(Parameters source, ParameterChange change) {
		return source == parameters && change.includes(offset);
	}
	
}
