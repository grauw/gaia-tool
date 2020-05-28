package nl.grauw.gaia.midi.messages;

public class IdentityRequest extends UniversalSysex {
	
	final static int GENERAL_INFORMATION = 0x06;
	final static int IDENTITY_REQUEST = 0x01;
	
	/**
	 * Construct a broadcast identity request message.
	 */
	public IdentityRequest() {
		super(GENERAL_INFORMATION, IDENTITY_REQUEST);
	}
	
	/**
	 * Construct an identity request message for a specific device.
	 * @param device_id The device ID. Must be between 0x10-0x1F (inclusive).
	 */
	public IdentityRequest(int device_id) {
		super(device_id, GENERAL_INFORMATION, IDENTITY_REQUEST);
		
		// stupid super call restriction prevents me from making this assertion earlier
		if (device_id < 0x10 || device_id > 0x1F)
			throw new IllegalArgumentException("Invalid device ID.");
	}
	
	public String toString() {
		String device = getDeviceId() == UniversalSysex.BROADCAST_DEVICE ? "broadcast" : String.format("%02XH", getDeviceId());
		return "Identity request message. Device ID: " + device + ".";
	}
	
}
