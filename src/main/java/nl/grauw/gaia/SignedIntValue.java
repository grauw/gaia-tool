package nl.grauw.gaia;

/**
 * Representation of a positive signed 7-bit integer value.
 * Positive signed means that -64 .. 0 .. 63 is stored as 0 .. 64 .. 127.
 */
public class SignedIntValue extends IntValue {
	
	public SignedIntValue(Parameters parameters, int offset, int min, int max) {
		super(parameters, offset, min, max);
	}
	
	@Override
	public int getValue() {
		return super.getValue() - 64;
	}
	
	@Override
	public void setValueNoCheck(int value) {
		super.setValueNoCheck(value + 64);
	}
	
}
