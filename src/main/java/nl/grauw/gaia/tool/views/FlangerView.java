package nl.grauw.gaia.tool.views;

import nl.grauw.gaia.Parameters;
import nl.grauw.gaia.Patch;
import nl.grauw.gaia.parameters.Flanger;
import nl.grauw.gaia.parameters.Flanger.FlangerType;

public class FlangerView extends SingleParametersPanel {

	private static final long serialVersionUID = 1L;

	private Patch patch;
	
	public FlangerView(Patch patch) {
		this.patch = patch;
		patch.addObserver(this);
		initComponents();
	}

	@Override
	public Parameters getParameters() {
		return patch.getFlanger();
	}
	
	@Override
	protected String getParametersText() {
		Flanger f = patch.getFlanger();
		
		StringBuilder flangerParameters = new StringBuilder(128);
		for (int i = 1; i <= 20; i++) {
			flangerParameters.append(f.getFlangerParameter(i));
			flangerParameters.append(" ");
		}
		
		StringBuilder text = new StringBuilder();
		text.append(String.format("Flanger type: %s\n", f.getFlangerType()));
		if (f.getFlangerType() == FlangerType.FLANGER) {
			text.append(String.format("Feedback: %s\n", f.getFeedback()));
		}
		if (f.getFlangerType() == FlangerType.PHASER) {
			text.append(String.format("Resonance: %s\n", f.getResonance()));
		}
		if (f.getFlangerType() == FlangerType.FLANGER || f.getFlangerType() == FlangerType.PHASER) {
			text.append(String.format("Rate: %s\n", f.getRate()));
			text.append(String.format("Depth: %s\n", f.getDepth()));
		}
		if (f.getFlangerType() == FlangerType.PITCH_SHIFTER) {
			text.append(String.format("Pitch: %s semitones\n", f.getPitch()));
			text.append(String.format("Detune: %s cent\n", f.getDetune()));
		}
		if (f.getFlangerType() != FlangerType.OFF) {
			text.append(String.format("Level: %s\n", f.getLevel()));
		}
		text.append(String.format("\nFlanger parameters: %s\n", flangerParameters));
		
		return text.toString();
	}

}
