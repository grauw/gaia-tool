package nl.grauw.gaia;

import java.io.IOException;

public class SVDPatch extends Patch {
	
	private SVDPatchGroup patchGroup;
	private int bank;
	private int patch;
	
	public SVDPatch(SVDPatchGroup patchGroup, int bank, int patch) {
		if (bank < 0 || bank > 7)
			throw new IllegalArgumentException("Invalid bank number.");
		if (patch < 0 || patch > 7)
			throw new IllegalArgumentException("Invalid patch number.");
		
		this.patchGroup = patchGroup;
		this.bank = bank;
		this.patch = patch;
	}
	
	public int getBank() {
		return bank;
	}
	
	public int getPatch() {
		return patch;
	}
	
	public void load() throws IOException {
		new SVDPatchLoader(patchGroup).load(patchGroup.getSource(), this);
	}
	
}
