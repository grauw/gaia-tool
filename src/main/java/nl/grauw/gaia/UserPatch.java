package nl.grauw.gaia;

public class UserPatch extends GaiaPatch {
	
	private int bank;
	private int patch;
	
	public UserPatch(Gaia gaia, int bank, int patch) {
		super(gaia);
		if (bank < 0 || bank > 7)
			throw new IllegalArgumentException("Invalid bank number.");
		if (patch < 0 || patch > 7)
			throw new IllegalArgumentException("Invalid patch number.");
		this.bank = bank;
		this.patch = patch;
	}
	
	public int getBank() {
		return bank;
	}
	
	public int getPatch() {
		return patch;
	}
	
	public Address getAddress(int byte3) {
		return new Address(0x20, bank << 3 | patch, byte3, 0x00);
	}

}
