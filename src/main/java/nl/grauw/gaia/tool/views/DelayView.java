package nl.grauw.gaia.tool.views;

import nl.grauw.gaia.Parameters;
import nl.grauw.gaia.Patch;
import nl.grauw.gaia.parameters.Delay;
import nl.grauw.gaia.parameters.Delay.DelayType;

public class DelayView extends SingleParametersPanel {

	private static final long serialVersionUID = 1L;
	
	private Patch patch;
	
	public DelayView(Patch patch) {
		this.patch = patch;
		patch.addObserver(this);
		initComponents();
	}

	@Override
	public Parameters getParameters() {
		return patch.getDelay();
	}
	
	@Override
	protected String getParametersText() {
		Delay d = patch.getDelay();
		
		StringBuilder delayParameters = new StringBuilder(128);
		for (int i = 1; i <= 20; i++) {
			delayParameters.append(d.getDelayParameter(i));
			delayParameters.append(" ");
		}
		
		StringBuilder text = new StringBuilder();
		text.append(String.format("Delay type: %s\n", d.getDelayType()));
		if (d.getDelayType() != DelayType.OFF) {
			text.append(String.format("Time: %s\n", d.getTime()));
			text.append(String.format("Synced time: %s\n", d.getSyncedTime()));
			text.append(String.format("Feedback: %s\n", d.getFeedback()));
			text.append(String.format("High damp: %s dB\n", d.getHighDamp()));
			text.append(String.format("Level: %s\n", d.getLevel()));
		}
		text.append(String.format("\nDelay parameters: %s\n", delayParameters));
		
		return text.toString();
	}

}
