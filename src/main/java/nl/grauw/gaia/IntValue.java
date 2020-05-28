package nl.grauw.gaia;

public class IntValue extends Value {

	private int min;
	private int max;
	
	public IntValue(Parameters parameters, int offset, int min, int max) {
		super(parameters, offset);
		this.min = min;
		this.max = max;
	}
	
	public int getValue() {
		return parameters.getValue(offset);
	}
	
	public void setValue(int value) {
		if (!isValidValue(value))
			throw new IllegalArgumentException("Value out of range.");
		setValueNoCheck(value);
	}
	
	protected void setValueNoCheck(int value) {
		parameters.setValue(offset, value);
	}
	
	public boolean isValid() {
		return isValidValue(getValue());
	}
	
	public boolean isValidValue(int value) {
		return value >= min && value <= max;
	}
	
	public int getMinimum() {
		return min;
	}
	
	public int getMaximum() {
		return max;
	}
	
	public String toString() {
		return String.valueOf(getValue());
	}
	
}
